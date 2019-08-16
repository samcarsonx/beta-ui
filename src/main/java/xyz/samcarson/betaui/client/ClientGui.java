package xyz.samcarson.betaui.client;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientGui {
	
	private static String cornerText = "Minecraft Beta 1.0.2";
	private static TextFormatting textColour = TextFormatting.WHITE;
	
	@SubscribeEvent
    public static void onRenderGuiPost(RenderGameOverlayEvent.Post event) {
		if (event.getType() == ElementType.HEALTH || event.getType() == ElementType.ARMOR) {
			GlStateManager.popMatrix();
		}
		if (event.getType() == ElementType.TEXT) {
			Minecraft.getInstance().fontRenderer.drawStringWithShadow(cornerText, 2, 2, textColour.getColor());
		}
	}
	
	@SubscribeEvent
	public static void onRenderGuiPre(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == ElementType.FOOD || event.getType() == ElementType.EXPERIENCE ||
				event.getType() == ElementType.HEALTHMOUNT) {
	        event.setCanceled(true);
	    }
		
		if (event.getType() == ElementType.HEALTH) {
			GlStateManager.pushMatrix();
			GlStateManager.translated(0, 7, 0);
		}
		if (event.getType() == ElementType.ARMOR) {
			GlStateManager.pushMatrix();
			GlStateManager.translated(101, 17, 0);
		}
	}
	
}