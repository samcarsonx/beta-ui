package xyz.samcarson.betaui.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientPlayer {
	
	@SubscribeEvent
    public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
	    if (event.getEntityLiving() instanceof PlayerEntity) {
	      	KeyBinding.setKeyBindState(Minecraft.getInstance().gameSettings.keyBindSprint.getKey(), false);
	    }
    }

}
