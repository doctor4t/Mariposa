package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public interface MariposaEntityTypes {
	EntityType<BoatEntity> SEQUOIA_BOAT = registerEntityType("sequoia_boat",
			EntityType.Builder.create(getBoatFactory(() -> MariposaItems.SEQUOIA_BOAT), SpawnGroup.MISC)
					.dropsNothing()
					.dimensions(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.maxTrackingRange(10));
	EntityType<ChestBoatEntity> SEQUOIA_CHEST_BOAT = registerEntityType("sequoia_chest_boat",
			EntityType.Builder.create(getChestBoatFactory(() -> MariposaItems.SEQUOIA_CHEST_BOAT), SpawnGroup.MISC)
					.dropsNothing()
					.dimensions(1.375F, 0.5625F)
					.eyeHeight(0.5625F)
					.maxTrackingRange(10));

	static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType.Builder<T> builder) {
		RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Mariposa.id(name));
		return Registry.register(Registries.ENTITY_TYPE, key.getValue(), builder.build(key));
	}

	static void initialize() {
	}

	private static EntityType.EntityFactory<BoatEntity> getBoatFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new BoatEntity(type, world, itemSupplier);
	}

	private static EntityType.EntityFactory<ChestBoatEntity> getChestBoatFactory(Supplier<Item> itemSupplier) {
		return (type, world) -> new ChestBoatEntity(type, world, itemSupplier);
	}
}
