/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.references;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.util.BlockItemId;
import net.minecraft.resources.Identifier;

public class MariposaBlockItemIds {
	public static final BlockItemId SEQUOIA_SAPLING = id("sequoia_sapling");
	public static final BlockItemId SEQUOIA_LOG = id("sequoia_log");
	public static final BlockItemId SEQUOIA_WOOD = id("sequoia_wood");
	public static final BlockItemId STRIPPED_SEQUOIA_LOG = id("stripped_sequoia_log");
	public static final BlockItemId STRIPPED_SEQUOIA_WOOD = id("stripped_sequoia_wood");
	public static final BlockItemId STACKED_SEQUOIA_LOGS = id("stacked_sequoia_logs");
	public static final BlockItemId SEQUOIA_LEAVES = id("sequoia_leaves");
	public static final BlockItemId SEQUOIA_PLANKS = id("sequoia_planks");
	public static final BlockItemId SEQUOIA_STAIRS = id("sequoia_stairs");
	public static final BlockItemId SEQUOIA_SLAB = id("sequoia_slab");
	public static final BlockItemId SEQUOIA_FENCE = id("sequoia_fence");
	public static final BlockItemId SEQUOIA_FENCE_GATE = id("sequoia_fence_gate");
	public static final BlockItemId SEQUOIA_DOOR = id("sequoia_door");
	public static final BlockItemId SEQUOIA_TRAPDOOR = id("sequoia_trapdoor");
	public static final BlockItemId SEQUOIA_PRESSURE_PLATE = id("sequoia_pressure_plate");
	public static final BlockItemId SEQUOIA_BUTTON = id("sequoia_button");
	public static final BlockItemId SEQUOIA_SHELF = id("sequoia_shelf");
	public static final BlockItemId SEQUOIA_SIGN = id("sequoia_sign");
	public static final BlockItemId SEQUOIA_HANGING_SIGN = id("sequoia_hanging_sign");

	private static BlockItemId id(String name) {
		Identifier id = Mariposa.id(name);
		return BlockItemId.create(id, id);
	}
}
