package dev.doctor4t.mariposa.client;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.init.MariposaEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class MariposaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Entity types
		ModelLayerLocation normal = new ModelLayerLocation(Mariposa.id("boat/sequoia"), "main");
		ModelLayerRegistry.registerModelLayer(normal, BoatModel::createBoatModel);
		EntityRenderers.register(MariposaEntityTypes.SEQUOIA_BOAT, context -> new BoatRenderer(context, normal));

		ModelLayerLocation chest = new ModelLayerLocation(Mariposa.id("chest_boat/sequoia"), "main");
		ModelLayerRegistry.registerModelLayer(chest, BoatModel::createChestBoatModel);
		EntityRenderers.register(MariposaEntityTypes.SEQUOIA_CHEST_BOAT, context -> new BoatRenderer(context, chest));
	}
}
