package com.mondecitronne.tigerseye;

import java.util.ArrayList;
import java.util.List;

import com.mondecitronne.tigerseye.block.BlockTigersEyeOre;
import com.mondecitronne.tigerseye.item.ItemTigersEye;
import com.mondecitronne.tigerseye.item.ItemTigersEyeArmor;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber
public class Common {
	public static Block tigersEyeOre;
	public static Block tigersEyeBlock;

	public static Item itemTigersEye;
	public static Item itemTigersEyeBoots;
	public static Item itemTigersEyeLeggings;
	public static Item itemTigersEyeChestplate;
	public static Item itemTigersEyeHelmet;
	
	public static List<Block> blocks = new ArrayList<Block>();
	public static List<Item> items = new ArrayList<Item>();
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		IForgeRegistry<Block> reg = event.getRegistry();
		tigersEyeOre = registerBlock(reg, new BlockTigersEyeOre(), "tigers_eye_ore");
		tigersEyeBlock = registerBlock(reg, new Block(Material.ROCK).setHardness(0.8f), "tigers_eye_block");
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		IForgeRegistry<Item> reg = event.getRegistry();
		registerItemBlock(reg, tigersEyeOre);
		registerItemBlock(reg, tigersEyeBlock);
		
		itemTigersEye = registerItem(reg, new ItemTigersEye(), "tigers_eye");
		itemTigersEyeBoots = registerItem(reg, new ItemTigersEyeArmor(EntityEquipmentSlot.FEET), "tigers_eye_boots");
		itemTigersEyeLeggings = registerItem(reg, new ItemTigersEyeArmor(EntityEquipmentSlot.LEGS), "tigers_eye_leggings");
		itemTigersEyeChestplate = registerItem(reg, new ItemTigersEyeArmor(EntityEquipmentSlot.CHEST), "tigers_eye_chestplate");
		itemTigersEyeHelmet = registerItem(reg, new ItemTigersEyeArmor(EntityEquipmentSlot.HEAD), "tigers_eye_helmet");
	}

	protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name) {
		block.setTranslationKey(TigersEye.prefixName(name));
		register(registry, block, TigersEye.resource(name));
		blocks.add(block);
		return block;
	}
	
	private static <T extends Item> T registerItem(IForgeRegistry<Item> registry, T item, String name) {
		item.setTranslationKey(TigersEye.prefixName(name));
		register(registry, item, TigersEye.resource(name));
		items.add(item);
		return item;
	}
	
	protected static <T extends Block> Item registerItemBlock(IForgeRegistry<Item> registry, T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setTranslationKey(block.getTranslationKey());
		register(registry, itemBlock, block.getRegistryName());
		items.add(itemBlock);
		return itemBlock;
	}
	
	protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, ResourceLocation name) {
		thing.setRegistryName(name);
		registry.register(thing);
		return thing;
	}
}
