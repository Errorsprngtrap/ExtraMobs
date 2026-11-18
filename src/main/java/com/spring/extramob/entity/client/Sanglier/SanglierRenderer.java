package com.spring.extramob.entity.client.Sanglier;

import com.mojang.blaze3d.vertex.PoseStack;
import com.spring.extramob.TemplateMod;
import com.spring.extramob.entity.client.ModModelLayerLocations;
import com.spring.extramob.entity.custom.SanglierEntity;
import net.minecraft.client.model.animal.fish.PufferfishBigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

public class SanglierRenderer extends MobRenderer<SanglierEntity,SanglierRenderState,SanglierModel> {
    public SanglierRenderer(EntityRendererProvider.Context context) {
        super(context, new SanglierModel(context.bakeLayer(ModModelLayerLocations.SANGLIER)), 0.2F);
    }

    @Override
    public Identifier getTextureLocation(SanglierRenderState sanglierRenderState) {
        return Identifier.fromNamespaceAndPath(TemplateMod.MOD_ID,"textures/entity/sanglier/sanglier.png");
    }

    @Override
    public SanglierRenderState createRenderState() {
        return new SanglierRenderState();
    }

    @Override
    public void submit(SanglierRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        //to rework later
        if(state.isBaby){
            poseStack.scale(0.5f,0.5f,0.5f);

        }else{
            poseStack.scale(1f,1f,1f);
        }
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    @Override
    public void extractRenderState(SanglierEntity entity, SanglierRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);

    }
}
