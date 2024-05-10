package com.mondecitronne.tigerseye;

import java.io.File;

import org.apache.logging.log4j.Logger;


import com.mondecitronne.tigerseye.proxy.Proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TigersEye.MODID, name = TigersEye.NAME, version = TigersEye.VERSION)
public class TigersEye {
	public static final String MODID = "tigerseye";
	public static final String NAME = "Tiger's Eye";
	public static final String VERSION = "0.0";

	@SidedProxy(clientSide = "com.mondecitronne.tigerseye.proxy.ClientProxy", serverSide = "com.mondecitronne.tigerseye.proxy.ServerProxy")
	public static Proxy proxy;

	@Mod.Instance
	public static TigersEye instance;

	public Logger logger;
	File dataDir;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	public static ResourceLocation resource(String name) {
		return new ResourceLocation(TigersEye.MODID, name);
	}
	
	public static String prefixName(String name) {
		return String.format("%s.%s", TigersEye.MODID, name);
	}
}
