package com.spring.extramob.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class VoidProwlerEntity extends Monster {
    //Idle Animation
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState poseAnimationState = new AnimationState();
    private int poseAnimationTimeout = 0;


    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 40);
    private long persistentAngerEndTime;
    private @Nullable EntityReference<LivingEntity> persistentAngerTarget;


    public VoidProwlerEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, (double) 1.0F, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, (double) 1.0F, 0.0F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));

        //this.targetSelector.addGoal(1, new VoidProwlerEntity.VoidProwlerLookForPlayerGoal(this, this::isAngryAt));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Endermite.class, true, false));


    //attribute//
    public static AttributeSupplier.Builder createVoidProwlerAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, (double) 60.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.13F)
                .add(Attributes.FOLLOW_RANGE, 80.0F)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.STEP_HEIGHT, 1.0);
    }

    //data
    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.readPersistentAngerSaveData(this.level(), input);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        this.addPersistentAngerSaveData(output);
    }


    //anim
    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            this.idleAnimationTimeout--;
        }
    }

    //anger related
    @Override
    public long getPersistentAngerEndTime() {
        return this.persistentAngerEndTime;
    }

    @Override
    public void setPersistentAngerEndTime(long endTime) {
        this.persistentAngerEndTime = endTime;
    }

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> entityReference) {
        this.persistentAngerTarget = entityReference;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setTimeToRemainAngry(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    //hurt
    private boolean hurtWithCleanWater(ServerLevel level, DamageSource source, AbstractThrownPotion thrownPotion, float damage) {
        ItemStack potionItemStack = thrownPotion.getItem();
        PotionContents potionContents = potionItemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        return potionContents.is(Potions.WATER) ? super.hurtServer(level, source, damage) : false;
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        if (this.isInvulnerableTo(level, source)) {
            return false;
        } else {
            AbstractThrownPotion thrownPotion = source.getDirectEntity() instanceof AbstractThrownPotion potion ? potion : null;
            if (!source.is(DamageTypeTags.IS_PROJECTILE) && thrownPotion == null) {
                boolean result = super.hurtServer(level, source, damage);
                if (!(source.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
                    teleport();
                }
                return result;
            } else {
                boolean hurtWithCleanWater = thrownPotion != null && this.hurtWithCleanWater(level, source, thrownPotion, damage);

                for (int i = 0; i < 64; i++) {
                    if (this.teleport()) {
                        return true;
                    }
                }

                return hurtWithCleanWater;
            }
        }
    }

    @Override
    public boolean isSensitiveToWater() {
        return true;
    }

    //tp
    protected boolean teleport() {
        if (!this.level().isClientSide() && this.isAlive()) {
            double xx = this.getX() + (this.random.nextDouble() - 0.5) * 64.0;
            double yy = this.getY() + (this.random.nextInt(64) - 32);
            double zz = this.getZ() + (this.random.nextDouble() - 0.5) * 64.0;
            return this.teleport(xx, yy, zz);
        } else {
            return false;
        }
    }

    private boolean teleport(double x, double y, double z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);

        while (pos.getY() > this.level().getMinY() && !this.level().getBlockState(pos).blocksMotion()) {
            pos.move(Direction.DOWN);
        }

        BlockState blockState = this.level().getBlockState(pos);
        boolean couldStandOn = blockState.blocksMotion();
        boolean isWet = blockState.getFluidState().is(FluidTags.WATER);
        if (couldStandOn && !isWet) {
            Vec3 oldPos = this.position();
            boolean result = this.randomTeleport(x, y, z, true);
            if (result) {
                this.level().gameEvent(GameEvent.TELEPORT, oldPos, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    this.level().playSound(null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
                    this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            }

            return result;
        } else {
            return false;
        }
    }

    private boolean teleportTowardsEntity(Entity entity) {
        Vec3 dir = new Vec3(this.getX() - entity.getX(), this.getY(0.5) - entity.getEyeY(), this.getZ() - entity.getZ());
        dir = dir.normalize();
        double d = 16.0;
        double xx = this.getX() + (this.random.nextDouble() - 0.5) * 8.0 - dir.x * 16.0;
        double yy = this.getY() + (this.random.nextInt(16) - 8) - dir.y * 16.0;
        double zz = this.getZ() + (this.random.nextDouble() - 0.5) * 8.0 - dir.z * 16.0;
        return this.teleport(xx, yy, zz);
    }

    //custom goal
    private static class VoidProwlerLookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
        private final VoidProwlerEntity voidProwler;
        private @Nullable Player pendingTarget;
        private int aggroTime;
        private int teleportTime;
        private final TargetingConditions startAggroTargetConditions;
        private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();
        private final TargetingConditions.Selector isAngerInducing;

        public VoidProwlerLookForPlayerGoal(VoidProwlerEntity voidProwler, TargetingConditions.Selector isAngerInducing) {
            super(voidProwler, Player.class, 10, false, false, isAngerInducing);
            this.voidProwler = voidProwler;
            this.isAngerInducing = (target, level) -> (voidProwler.isAngryAt(target, level))
                    && !voidProwler.hasIndirectPassenger(target);
            this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector(this.isAngerInducing);

        }

        @Override
        public boolean canUse() {
            this.pendingTarget = getServerLevel(this.voidProwler).getNearestPlayer(this.startAggroTargetConditions.range(this.getFollowDistance()), this.voidProwler);
            return this.pendingTarget != null;
        }


        @Override
        public void start() {
            this.aggroTime = this.adjustedTickDelay(5);
            this.teleportTime = 0;
        }

        @Override
        public void stop() {
            this.pendingTarget = null;
            super.stop();
        }

        @Override
        public boolean canContinueToUse() {
            if (this.pendingTarget != null) {
                if (!this.isAngerInducing.test(this.pendingTarget, getServerLevel(this.voidProwler))) {
                    return false;
                } else {
                    this.voidProwler.lookAt(this.pendingTarget, 10.0F, 10.0F);
                    return true;
                }
            } else {
                if (this.target != null) {
                    if (this.voidProwler.hasIndirectPassenger(this.target)) {
                        return false;
                    }

                    if (this.continueAggroTargetConditions.test(getServerLevel(this.voidProwler), this.voidProwler, this.target)) {
                        return true;
                    }
                }

                return super.canContinueToUse();
            }
        }

        @Override
        public void tick() {
            if (this.voidProwler.getTarget() == null) {
                super.setTarget(null);
            }

            if (this.pendingTarget != null) {
                if (--this.aggroTime <= 0) {
                    this.target = this.pendingTarget;
                    this.pendingTarget = null;
                    super.start();
                }
            } else {
                if (this.target != null && !this.voidProwler.isPassenger()) {
                    if (this.target.distanceToSqr(this.voidProwler) > 256.0
                            && this.teleportTime++ >= this.adjustedTickDelay(15)
                            && this.voidProwler.teleportTowardsEntity(this.target)) {
                        this.teleportTime = 0;
                    }
                }

                super.tick();
            }
        }
    }
}