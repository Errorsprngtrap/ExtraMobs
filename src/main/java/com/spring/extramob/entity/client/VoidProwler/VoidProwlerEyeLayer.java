package com.spring.extramob.entity.client.VoidProwler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.spring.extramob.ExtraMob;
import com.spring.extramob.entity.client.ModModelLayerLocations;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.LightCoordsUtil;

//Eye
public class VoidProwlerEyeLayer extends RenderLayer<VoidProwlerRenderState,VoidProwlerModel> {
    private final VoidProwlerEyeModel voidProwlerEyeModel;
    private static final Identifier eyesTexture = Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"textures/entity/voidprowler/voidprowler_eye.png");

    public VoidProwlerEyeLayer(RenderLayerParent<VoidProwlerRenderState, VoidProwlerModel> renderer, EntityModelSet modelSet) {
        super(renderer);
        voidProwlerEyeModel = new VoidProwlerEyeModel(modelSet.bakeLayer(ModModelLayerLocations.VOIDPROWLER_EYE));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCord, VoidProwlerRenderState state, float v, float v1) {
        this.voidProwlerEyeModel.setupAnim(state);
        submitNodeCollector.order(1).submitModel(this.voidProwlerEyeModel,state,poseStack, RenderTypes.entityTranslucentEmissive(eyesTexture,false),
                LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, -1, null, state.outlineColor, null);
    }
}
