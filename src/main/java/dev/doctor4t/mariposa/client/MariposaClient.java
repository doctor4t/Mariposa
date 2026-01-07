package dev.doctor4t.mariposa.client;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.index.MariposaBlocks;
import dev.doctor4t.mariposa.index.MariposaEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class MariposaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Map special render layers to blocks
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, MariposaBlocks.SEQUOIA_LEAVES, MariposaBlocks.SEQUOIA_SAPLING, MariposaBlocks.SEQUOIA_DOOR, MariposaBlocks.SEQUOIA_TRAPDOOR, MariposaBlocks.POTTED_SEQUOIA_SAPLING);
		// Entity types
		EntityModelLayer normal = new EntityModelLayer(Mariposa.id("boat/sequoia"), "main");
		EntityModelLayerRegistry.registerModelLayer(normal, BoatEntityModel::getTexturedModelData);
		EntityRendererFactories.register(MariposaEntityTypes.SEQUOIA_BOAT, context -> new BoatEntityRenderer(context, normal));

		EntityModelLayer chest = new EntityModelLayer(Mariposa.id("chest_boat/sequoia"), "main");
		EntityModelLayerRegistry.registerModelLayer(chest, BoatEntityModel::getChestTexturedModelData);
		EntityRendererFactories.register(MariposaEntityTypes.SEQUOIA_CHEST_BOAT, context -> new BoatEntityRenderer(context, chest));
	}
}
