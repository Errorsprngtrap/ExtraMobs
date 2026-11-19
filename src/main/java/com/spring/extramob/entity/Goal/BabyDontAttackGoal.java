package com.spring.extramob.entity.Goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class BabyDontAttackGoal extends MeleeAttackGoal {
    public BabyDontAttackGoal(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
    }

    @Override
    public boolean canUse() {
        return !mob.isBaby() && super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        return !mob.isBaby() && super.canContinueToUse();
    }
}

