package dev.doctor4t.mariposa.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class MariposaHangingSignBlockEntity extends SignBlockEntity {
    private static final int MAX_TEXT_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;

    public MariposaHangingSignBlockEntity(BlockEntityType<? extends SignBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public int getTextLineHeight() {
        return TEXT_LINE_HEIGHT;
    }

    @Override
    public int getMaxTextWidth() {
        return MAX_TEXT_WIDTH;
    }
}
