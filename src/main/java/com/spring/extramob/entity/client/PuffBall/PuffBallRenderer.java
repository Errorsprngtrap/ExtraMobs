package com.spring.extramob.entity.client.PuffBall;

import com.mojang.blaze3d.vertex.PoseStack;
import com.spring.extramob.TemplateMod;
import com.spring.extramob.entity.client.ModModelLayerLocations;
import com.spring.extramob.entity.custom.PuffBallEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

public class PuffBallRenderer extends MobRenderer<PuffBallEntity, PuffBallRenderState, PuffBallModel> {

    public PuffBallRenderer(EntityRendererProvider.Context context) {
        super(context, new PuffBallModel(context.bakeLayer(ModModelLayerLocations.PUFFBALL)), 0.05f);
    }

    @Override
    public Identifier getTextureLocation(PuffBallRenderState state) {
        return Identifier.fromNamespaceAndPath(TemplateMod.MOD_ID,"textures/entity/puffball/puffball.png");
    }

    @Override
    public PuffBallRenderState createRenderState() {
        return new PuffBallRenderState();
    }

    @Override
    public void submit(PuffBallRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if(state.isBaby){
            poseStack.scale(0.5f,0.5f,0.5f);

        }else{
            poseStack.scale(1f,1f,1f);
        }
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    @Override
    public void extractRenderState(PuffBallEntity entity, PuffBallRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
