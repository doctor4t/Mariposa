package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;

public interface MariposaBlockStateProviders {
	ResourceKey<BlockStateProvider> SNOW_BENEATH_TREE = key("snow_beneath_tree");

	private static ResourceKey<BlockStateProvider> key(String name) {
		return ResourceKey.create(Registries.BLOCK_STATE_PROVIDER, Mariposa.id(name));
	}

	static void bootstrap(BootstrapContext<BlockStateProvider> context) {
		context.register(
				SNOW_BENEATH_TREE,
				RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesTag(BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE), Blocks.SNOW_BLOCK)
		);
	}
}
