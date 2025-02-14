package dev.doctor4t.redwood.client;

import dev.doctor4t.redwood.index.RedwoodBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RedwoodClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Map special render layers to blocks
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), RedwoodBlocks.SEQUOIA_LEAVES, RedwoodBlocks.SEQUOIA_SAPLING, RedwoodBlocks.SEQUOIA_DOOR, RedwoodBlocks.SEQUOIA_TRAPDOOR, RedwoodBlocks.POTTED_SEQUOIA_SAPLING);
    }
}
