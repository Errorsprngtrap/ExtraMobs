package com.spring.extramob.entity.custom;

import com.spring.extramob.entity.Goal.BabyDontAttackGoal;
import com.spring.extramob.entity.Goal.GoalAttackTargetNearBaby;
import com.spring.extramob.entity.ModEntities;
import com.spring.extramob.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class SanglierEntity extends Animal implements NeutralMob {
    //Idle Anim
    public static AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(10, 20);
    private long persistentAngerEndTime;
    private @Nullable EntityReference<LivingEntity> persistentAngerTarget;


    public SanglierEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0, sanglier -> sanglier.isBaby() ? DamageTypeTags.PANIC_CAUSES : DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, (new BabyDontAttackGoal(this,2,false)));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.25F));
        this.goalSelector.addGoal(4, new AvoidEntityGoal(this, Monster.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new SanglierWaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6,new SheakSleepPlace(this,2D));
        this.goalSelector.addGoal(12, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new GoalAttackTargetNearBaby(this,Player.class,true));


    }

    public static AttributeSupplier.Builder createSanglierAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 25.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.FOLLOW_RANGE, 25.0F)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.STEP_HEIGHT, 1.0);
    }

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
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        }else{
            this.idleAnimationTimeout--;
        }
    }

    //anger
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

    //
    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.SANGLIER.get().create(serverLevel, EntitySpawnReason.BREEDING);

    }

    private class SheakSleepPlace extends FleeSunGoal{

        public SheakSleepPlace(PathfinderMob mob, double speedModifier) {
            super(mob, speedModifier);
        }

        @Override
        public boolean canUse() {
            if (mob.getTarget() == null) {
                if (mob.level().isDarkOutside() && mob.level().canSeeSky(mob.blockPosition())){
                    return this.setWantedPos();
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }

        @Override
        protected @Nullable Vec3 getHidePos() {
            RandomSource random = mob.getRandom();
            BlockPos pos = mob.blockPosition();

            BlockPos best = null;
            double bestDistSq = Double.MAX_VALUE;


            int[] horizontalRadii = {10, 20, 32,40};
            int[] verticalRadii = {3, 5, 8,10};

            for (int tier = 0; tier < horizontalRadii.length; tier++) {
                int hRadius = horizontalRadii[tier];
                int vRadius = verticalRadii[tier];

                for (int i = 0; i < 10; ++i) {
                    BlockPos randomPos = pos.offset(random.nextInt(hRadius * 2) - hRadius, random.nextInt(vRadius * 2) - vRadius, random.nextInt(hRadius * 2) - hRadius);

                    boolean notSeeSky = !mob.level().canSeeSky(randomPos);
                    boolean standable = mob.level().getBlockState(randomPos).isAir()
                            && mob.level().getBlockState(randomPos.above()).isAir()
                            && mob.level().getBlockState(randomPos.below()).isSolid();
                    boolean notSnowTerrain = !mob.level().getBlockState(randomPos.below()).is(Blocks.SNOW)
                            && !mob.level().getBlockState(randomPos.below()).is(Blocks.POWDER_SNOW)
                            && !mob.level().getBlockState(randomPos.above()).is(Blocks.SNOW)
                            && !mob.level().getBlockState(randomPos.above()).is(Blocks.POWDER_SNOW);

                    if (notSeeSky && standable && notSnowTerrain ) {
                        double distSq = randomPos.distSqr(pos);
                        if (distSq < bestDistSq) {
                            bestDistSq = distSq;
                            best = randomPos;
                        }
                    }
                }

                if (best != null) {
                    return Vec3.atBottomCenterOf(best);
                }
            }
            return null;
        }
    }

    public class SanglierWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal{

        public SanglierWaterAvoidingRandomStrollGoal(PathfinderMob mob, double speedModifier) {
            super(mob, speedModifier);
        }

        @Override
        public boolean canUse() {
            return !mob.level().isDarkOutside() && super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            return !mob.level().isDarkOutside() && super.canContinueToUse();
        }


    }

    //sound


    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.SANGLIER_NOISE.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SANGLIER_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.PIGLIN_DEATH;
    }
}
