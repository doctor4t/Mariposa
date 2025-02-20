package dev.doctor4t.mariposa.block;

import dev.doctor4t.mariposa.block.entity.MariposaHangingSignBlockEntity;
import dev.doctor4t.mariposa.index.MariposaBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MariposaWallHangingSignBlock extends WallHangingSignBlock {
    public MariposaWallHangingSignBlock(Settings settings, WoodType type) {
        super(settings, type);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MariposaHangingSignBlockEntity(MariposaBlockEntities.SEQUOIA_HANGING_SIGN_BLOCK_ENTITY, pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, MariposaBlockEntities.SEQUOIA_HANGING_SIGN_BLOCK_ENTITY, MariposaHangingSignBlockEntity::tick);
    }
}
