package com.spring.extramob.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class VoidProwlerEntity extends Monster implements NeutralMob {
    //Idle Animation
    public static AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public VoidProwlerEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    public static AttributeSupplier.Builder createVoidProwlerAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, (double)40.0F);
    }

    //anger related
    @Override
    public long getPersistentAngerEndTime() {
        return 0;
    }

    @Override
    public void setPersistentAngerEndTime(long l) {

    }

    @Override
    public @Nullable EntityReference<LivingEntity> getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable EntityReference<LivingEntity> entityReference) {

    }

    @Override
    public void startPersistentAngerTimer() {

    }
}
