package dev.doctor4t.mariposa.common.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;

public class SequoiaLeavesBlock extends TintedParticleLeavesBlock {
	public SequoiaLeavesBlock(float leafParticleChance, Properties settings) {
		super(leafParticleChance, settings);
	}

	@Override
	protected void spawnFallingLeavesParticle(Level world, BlockPos pos, RandomSource random) {
		ColorParticleOption tintedParticleEffect = ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0x4d6533);
		ParticleUtils.spawnParticleBelow(world, pos, random, tintedParticleEffect);
	}
}
