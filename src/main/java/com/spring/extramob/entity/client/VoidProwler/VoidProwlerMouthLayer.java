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

public class VoidProwlerMouthLayer extends RenderLayer<VoidProwlerRenderState,VoidProwlerModel> {
    private final VoidProwlerMouthModel voidProwlerMouthModel;
    private static final Identifier Texture = Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"textures/entity/voidprowler/voidprowler_mouth.png");


    public VoidProwlerMouthLayer(RenderLayerParent<VoidProwlerRenderState, VoidProwlerModel> renderer, EntityModelSet modelSet) {
        super(renderer);
        voidProwlerMouthModel = new VoidProwlerMouthModel(modelSet.bakeLayer(ModModelLayerLocations.VOIDPROWLER_MOUTH));

    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCord, VoidProwlerRenderState state, float v, float v1) {
        this.voidProwlerMouthModel.setupAnim(state);
        submitNodeCollector.order(1).submitModel(this.voidProwlerMouthModel,state,poseStack, RenderTypes.entityTranslucentEmissive(Texture,false),
                lightCord, OverlayTexture.NO_OVERLAY, -1, null, state.outlineColor, null);
    }
}
