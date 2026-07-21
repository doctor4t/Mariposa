package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.references.MariposaEntityTypeIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface MariposaEntityTypes {
	EntityType<Boat> SEQUOIA_BOAT = register(MariposaEntityTypeIds.SEQUOIA_BOAT,
			EntityType.Builder.of(getBoatFactory(() -> MariposaItems.SEQUOIA_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));
	EntityType<ChestBoat> SEQUOIA_CHEST_BOAT = register(MariposaEntityTypeIds.SEQUOIA_CHEST_BOAT,
			EntityType.Builder.of(getChestBoatFactory(() -> MariposaItems.SEQUOIA_CHEST_BOAT), MobCategory.MISC)
					.noLootTable()
					.sized(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.clientTrackingRange(10));

	private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key.identifier(), builder.build(key));
	}

	private static EntityType.EntityFactory<Boat> getBoatFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new Boat(type, world, itemSupplier);
	}

	private static EntityType.EntityFactory<ChestBoat> getChestBoatFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new ChestBoat(type, world, itemSupplier);
	}

	static void initialize() {
	}
}
