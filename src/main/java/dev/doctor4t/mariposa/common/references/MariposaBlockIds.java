/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.references;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class MariposaBlockIds {
	public static final ResourceKey<Block> POTTED_SEQUOIA_SAPLING = key("potted_sequoia_sapling");
	public static final ResourceKey<Block> SEQUOIA_WALL_SIGN = key("sequoia_wall_sign");
	public static final ResourceKey<Block> SEQUOIA_WALL_HANGING_SIGN = key("sequoia_wall_hanging_sign");

	private static ResourceKey<Block> key(String name) {
		Identifier id = Mariposa.id(name);
		return ResourceKey.create(Registries.BLOCK, id);
	}
}
