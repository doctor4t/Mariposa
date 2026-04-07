/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.world.level.levelgen;

import dev.doctor4t.mariposa.common.init.MariposaBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class MariposaSurfaceRuleData {
	private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
	private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
	private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
	private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
	private static final SurfaceRules.ConditionSource STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH = SurfaceRules.stoneDepthCheck(1, true, CaveSurface.FLOOR);

	public static SurfaceRules.RuleSource makeRules() {
		return SurfaceRules.sequence(
				// redwood forest
				SurfaceRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH,
						SurfaceRules.ifTrue(SurfaceRules.isBiome(MariposaBiomes.REDWOOD_FOREST),
								SurfaceRules.ifTrue(surfaceNoiseThreshold(1.75), COARSE_DIRT))),
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0, 0),
								SurfaceRules.ifTrue(SurfaceRules.isBiome(MariposaBiomes.REDWOOD_FOREST), SurfaceRules.sequence(
										SurfaceRules.ifTrue(surfaceNoiseThreshold(-.95), PODZOL),
										GRASS_BLOCK
								)))),
				SurfaceRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH, SurfaceRules.ifTrue(SurfaceRules.isBiome(MariposaBiomes.REDWOOD_FOREST), DIRT)),

				// snowy redwood forest
				SurfaceRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH,
						SurfaceRules.ifTrue(SurfaceRules.isBiome(MariposaBiomes.SNOWY_REDWOOD_FOREST),
								SurfaceRules.ifTrue(surfaceNoiseThreshold(1.75), SNOW_BLOCK))),
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0, 0),
								SurfaceRules.ifTrue(SurfaceRules.isBiome(MariposaBiomes.SNOWY_REDWOOD_FOREST), SurfaceRules.sequence(
										SurfaceRules.ifTrue(surfaceNoiseThreshold(-.95), SNOW_BLOCK),
										GRASS_BLOCK
								)))),
				SurfaceRules.ifTrue(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH, SurfaceRules.ifTrue(SurfaceRules.isBiome(MariposaBiomes.SNOWY_REDWOOD_FOREST), DIRT))
		);
	}

	private static SurfaceRules.RuleSource makeStateRule(Block block) {
		return SurfaceRules.state(block.defaultBlockState());
	}

	private static SurfaceRules.ConditionSource surfaceNoiseThreshold(double min) {
		return SurfaceRules.noiseCondition(Noises.SURFACE, min / 8.25, Double.MAX_VALUE);
	}
}
