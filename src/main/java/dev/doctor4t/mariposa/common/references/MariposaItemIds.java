/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.references;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class MariposaItemIds {
	public static final ResourceKey<Item> SEQUOIA_BOAT = key("sequoia_boat");
	public static final ResourceKey<Item> SEQUOIA_CHEST_BOAT = key("sequoia_chest_boat");

	private static ResourceKey<Item> key(String name) {
		Identifier id = Mariposa.id(name);
		return ResourceKey.create(Registries.ITEM, id);
	}
}
