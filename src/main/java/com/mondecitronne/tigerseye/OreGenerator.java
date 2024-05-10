package com.mondecitronne.tigerseye;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator extends WorldGenMinable implements IWorldGenerator {
	public final int oreRate = 5;
	
	public OreGenerator() {
		super(Common.tigersEyeOre.getDefaultState(), 2, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
	    BlockPos pos;                                                               
	    for (int i = 0; i < oreRate; i += 1) {
	    	pos = new BlockPos(chunkX * 16, 10, chunkZ * 16);
	    	pos = pos.add(random.nextInt(16), random.nextInt(32), random.nextInt(16));
	    	generate(world, random, pos);
	    }
	}

}
