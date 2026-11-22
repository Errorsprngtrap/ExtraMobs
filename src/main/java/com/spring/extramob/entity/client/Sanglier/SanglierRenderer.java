package com.spring.extramob.entity.client.Sanglier;

import com.mojang.blaze3d.vertex.PoseStack;
import com.spring.extramob.ExtraMob;
import com.spring.extramob.entity.client.ModModelLayerLocations;
import com.spring.extramob.entity.custom.SanglierEntity;
import net.minecraft.client.model.animal.sheep.BabySheepModel;
import net.minecraft.client.model.animal.sheep.SheepModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.AgeableMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

public class SanglierRenderer extends AgeableMobRenderer<SanglierEntity,SanglierRenderState,SanglierModel> {
    private static final Identifier SANGLIER_LOCATION = Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"textures/entity/sanglier/sanglier.png");
    private static final Identifier SANGLIER_BABY_LOCATION = Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"textures/entity/sanglier/baby/baby_sanglier.png");


    public SanglierRenderer(EntityRendererProvider.Context context) {
       super(context, new SanglierModelAdult(context.bakeLayer(ModModelLayerLocations.SANGLIER)), new BabySanglierModel(context.bakeLayer(ModModelLayerLocations.BABY_SANGLIER)), 0.5F);
    }

    @Override
    public Identifier getTextureLocation(SanglierRenderState sanglierRenderState) {
        return sanglierRenderState.isBaby ? SANGLIER_BABY_LOCATION : SANGLIER_LOCATION;
    }

    @Override
    public SanglierRenderState createRenderState() {
        return new SanglierRenderState();
    }

    @Override
    public void submit(SanglierRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    @Override
    public void extractRenderState(SanglierEntity entity, SanglierRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }

}
