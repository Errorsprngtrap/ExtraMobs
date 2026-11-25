package com.spring.extramob.entity.client.VoidProwler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.spring.extramob.ExtraMob;
import com.spring.extramob.entity.client.ModModelLayerLocations;
import com.spring.extramob.entity.custom.VoidProwlerEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

public class VoidProwlerRenderer extends MobRenderer<VoidProwlerEntity,VoidProwlerRenderState,VoidProwlerModel> {
    public VoidProwlerRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidProwlerModel(context.bakeLayer(ModModelLayerLocations.VOIDPROWLER)), 0.1f);
        this.addLayer(new VoidProwlerEyeLayer(this,context.getModelSet()));
    }

    @Override
    public Identifier getTextureLocation(VoidProwlerRenderState voidProwlerRenderState) {
        return Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"textures/entity/voidprowler/voidprowler.png");
    }

    @Override
    public VoidProwlerRenderState createRenderState() {
        return new VoidProwlerRenderState();
    }

    @Override
    public void submit(VoidProwlerRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    @Override
    public void extractRenderState(VoidProwlerEntity entity, VoidProwlerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
