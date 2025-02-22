package dev.doctor4t.mariposa.client;

import dev.doctor4t.mariposa.index.MariposaBlockEntities;
import dev.doctor4t.mariposa.index.MariposaBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

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
        BlockEntityRendererFactories.register(MariposaBlockEntities.SEQUOIA_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(MariposaBlockEntities.SEQUOIA_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
    }
}
