package xyz.samcarson.betaui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import xyz.samcarson.betaui.client.*;
import xyz.samcarson.betaui.common.*;

@Mod(Main.MODID)
public class Main {
	
	public static final String MODID = "betaui";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public Main() {
		LOGGER.debug(Main.MODID);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ProxyHandler::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ProxyHandler::commonSetup);
	}

	public static class ProxyHandler {
		// Client only
		public static void clientSetup(FMLClientSetupEvent event) {
			MinecraftForge.EVENT_BUS.register(ClientGui.class);
			MinecraftForge.EVENT_BUS.register(ClientPlayer.class);
		}
		// Client and server
		public static void commonSetup(FMLCommonSetupEvent event) {
			MinecraftForge.EVENT_BUS.register(CommonPlayer.class);
		}
	}
	
}
