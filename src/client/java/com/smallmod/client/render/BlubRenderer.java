package com.smallmod.client.render;

import com.smallmod.SmallMod;
import com.smallmod.client.model.BlubModel;
import com.smallmod.entity.Blub;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class BlubRenderer extends MobRenderer<Blub, LivingEntityRenderState, BlubModel> {

    public BlubRenderer(Context context) {
        super(context, new BlubModel(context.bakeLayer(BlubModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return SmallMod.id("textures/entity/blub.png");
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
    
}
