package com.spring.extramob.entity.Goal;

import com.spring.extramob.entity.custom.SanglierEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;

public class GoalAttackTargetNearBaby extends NearestAttackableTargetGoal<Player> {
    public GoalAttackTargetNearBaby(Mob mob, Class<Player> targetType, boolean mustSee) {
        super(mob, targetType, mustSee);
    }

    @Override
    public boolean canUse() {
        if (mob.isBaby()) {
            return false;
        } else {
            if (super.canUse()) {
                for (SanglierEntity sanglier : mob.level().getEntitiesOfClass(SanglierEntity.class, mob.getBoundingBox().inflate(8.0, 4.0, 8.0))) {
                    if (sanglier.isBaby()) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    @Override
    protected double getFollowDistance() {
        return super.getFollowDistance() * 0.5;
    }
}
