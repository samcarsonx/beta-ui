package xyz.samcarson.betaui.common;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonPlayer {
	
	@SubscribeEvent
    public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
        event.getEntityLiving().setSprinting(false);
    }

}
