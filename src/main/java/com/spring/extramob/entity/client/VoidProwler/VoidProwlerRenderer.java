package com.spring.extramob.entity.client.VoidProwler;

import com.spring.extramob.entity.custom.VoidProwler;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class VoidProwlerRenderer extends MobRenderer<VoidProwler,VoidProwlerRenderState,VoidProwlerModel> {
    public VoidProwlerRenderer(EntityRendererProvider.Context context, VoidProwlerModel model, float shadow) {
        super(context, model, shadow);
    }

    @Override
    public Identifier getTextureLocation(VoidProwlerRenderState voidProwlerRenderState) {
        return null;
    }

    @Override
    public VoidProwlerRenderState createRenderState() {
        return new VoidProwlerRenderState();
    }
}
