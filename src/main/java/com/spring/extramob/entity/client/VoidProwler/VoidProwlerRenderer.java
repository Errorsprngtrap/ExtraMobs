package com.spring.extramob.entity.client.VoidProwler;

import com.spring.extramob.ExtraMob;
import com.spring.extramob.entity.client.ModModelLayerLocations;
import com.spring.extramob.entity.custom.VoidProwlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class VoidProwlerRenderer extends MobRenderer<VoidProwlerEntity,VoidProwlerRenderState,VoidProwlerModel> {
    public VoidProwlerRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidProwlerModel(context.bakeLayer(ModModelLayerLocations.VOIDPROWLER)), 0.1f);
    }

    @Override
    public Identifier getTextureLocation(VoidProwlerRenderState voidProwlerRenderState) {
        return Identifier.fromNamespaceAndPath(ExtraMob.MOD_ID,"textures/entity/voidprowler/voidprowler.png");
    }

    @Override
    public VoidProwlerRenderState createRenderState() {
        return new VoidProwlerRenderState();
    }
}
