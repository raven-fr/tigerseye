package com.mondecitronne.tigerseye.block;

import java.util.Random;

import com.mondecitronne.tigerseye.Common;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockTigersEyeOre extends BlockOre {
	public BlockTigersEyeOre() {
		super();
		setHardness(3.0F);
		setResistance(5.0F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Common.itemTigersEye;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return random.nextInt(10) == 1 ? random.nextInt(3) + 1 : 1;
	}
}
