package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.block.entity.MariposaHangingSignBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface MariposaBlockEntities {
    BlockEntityType<SignBlockEntity> SEQUOIA_SIGN_BLOCK_ENTITY = register("sequoia_sign",
            (blockPos, blockState) -> new SignBlockEntity(MariposaBlockEntities.SEQUOIA_SIGN_BLOCK_ENTITY, blockPos, blockState),
            MariposaBlocks.SEQUOIA_SIGN,
            MariposaBlocks.SEQUOIA_WALL_SIGN
    );

    BlockEntityType<MariposaHangingSignBlockEntity> SEQUOIA_HANGING_SIGN_BLOCK_ENTITY = register("sequoia_hanging_sign",
            (blockPos, blockState) -> new MariposaHangingSignBlockEntity(MariposaBlockEntities.SEQUOIA_HANGING_SIGN_BLOCK_ENTITY, blockPos, blockState),
            MariposaBlocks.SEQUOIA_HANGING_SIGN,
            MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> factory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Mariposa.id(name),
                FabricBlockEntityTypeBuilder.<T>create(factory, blocks).build());
    }

    static void initialize() {
        // static initialisation
    }
}
