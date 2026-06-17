/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.references;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class MariposaEntityTypeIds {
	public static final ResourceKey<EntityType<?>> SEQUOIA_BOAT = key("sequoia_boat");
	public static final ResourceKey<EntityType<?>> SEQUOIA_CHEST_BOAT = key("sequoia_chest_boat");

	private static ResourceKey<EntityType<?>> key(String name) {
		Identifier id = Mariposa.id(name);
		return ResourceKey.create(Registries.ENTITY_TYPE, id);
	}
}
