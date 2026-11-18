package com.spring.extramob.entity.client.CubeMob;

import com.spring.extramob.entity.variant.CubeMobVariant;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class CubeMobRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public CubeMobVariant variant;
}
