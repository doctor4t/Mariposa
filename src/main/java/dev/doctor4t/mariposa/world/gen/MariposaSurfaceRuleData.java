package dev.doctor4t.mariposa.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class MariposaSurfaceRuleData {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule PODZOL = makeStateRule(Blocks.PODZOL);
    private static final MaterialRules.MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialCondition STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH = MaterialRules.stoneDepth(1, true, VerticalSurfaceType.FLOOR);

    public static MaterialRules.MaterialRule makeRules() {
        return MaterialRules.sequence(
                MaterialRules.condition(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH,
                        MaterialRules.condition(MaterialRules.biome(MariposaBiomes.REDWOOD_FOREST),
                                MaterialRules.condition(surfaceNoiseThreshold (1.75), COARSE_DIRT))),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.condition(MaterialRules.water(0, 0),
                                MaterialRules.condition(MaterialRules.biome(MariposaBiomes.REDWOOD_FOREST), MaterialRules.sequence(
                                        MaterialRules.condition(surfaceNoiseThreshold (-.95), PODZOL),
                                        GRASS_BLOCK
                                )))),
                MaterialRules.condition(STONE_DEPTH_FLOOR_DOWN_1_WITH_DEPTH, MaterialRules.condition(MaterialRules.biome(MariposaBiomes.REDWOOD_FOREST), DIRT))
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    private static MaterialRules.MaterialCondition surfaceNoiseThreshold(double min) {
        return MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, min / 8.25, Double.MAX_VALUE);
    }
}
