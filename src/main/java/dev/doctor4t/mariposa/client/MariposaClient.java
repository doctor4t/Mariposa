package dev.doctor4t.mariposa.client;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MariposaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Map special render layers to blocks
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                MariposaBlocks.SEQUOIA_LEAVES,
                MariposaBlocks.SEQUOIA_SAPLING,
                MariposaBlocks.SEQUOIA_DOOR,
                MariposaBlocks.SEQUOIA_TRAPDOOR,
                MariposaBlocks.POTTED_SEQUOIA_SAPLING
        );
    }
}
