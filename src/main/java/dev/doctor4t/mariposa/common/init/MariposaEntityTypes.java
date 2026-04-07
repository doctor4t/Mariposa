/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface MariposaEntityTypes {
	EntityType<Boat> SEQUOIA_BOAT = registerEntityType("sequoia_boat",
			EntityType.Builder.of(getBoatFactory(() -> MariposaItems.SEQUOIA_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));
	EntityType<ChestBoat> SEQUOIA_CHEST_BOAT = registerEntityType("sequoia_chest_boat",
			EntityType.Builder.of(getChestBoatFactory(() -> MariposaItems.SEQUOIA_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));

	static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType.Builder<T> builder) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Mariposa.id(name));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key.identifier(), builder.build(key));
	}

	static void initialize() {
	}

	private static EntityType.EntityFactory<Boat> getBoatFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new Boat(type, world, itemSupplier);
	}

	private static EntityType.EntityFactory<ChestBoat> getChestBoatFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new ChestBoat(type, world, itemSupplier);
	}
}
