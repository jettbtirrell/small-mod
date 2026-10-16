package com.smallmod.client;

import com.smallmod.ModEntities;
import com.smallmod.client.model.BlubModel;
import com.smallmod.client.render.BlubRenderer;
import com.smallmod.client.render.TamedVexRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityTypes;

public class SmallModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModelLayerRegistry.registerModelLayer(BlubModel.LAYER_LOCATION, BlubModel::createBodyLayer);
    	EntityRenderers.register(ModEntities.BLUB, BlubRenderer::new);
		EntityRenderers.register(EntityTypes.VEX, TamedVexRenderer::new);
	}
}
