package dev.doctor4t.mariposa.block;

import net.minecraft.block.TintedParticleLeavesBlock;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SequoiaLeavesBlock extends TintedParticleLeavesBlock {
	public SequoiaLeavesBlock(float leafParticleChance, Settings settings) {
		super(leafParticleChance, settings);
	}

	@Override
	protected void spawnLeafParticle(World world, BlockPos pos, Random random) {
		EntityEffectParticleEffect entityEffectParticleEffect = EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 0x4d6533);
		ParticleUtil.spawnParticle(world, pos, random, entityEffectParticleEffect);
	}
}
