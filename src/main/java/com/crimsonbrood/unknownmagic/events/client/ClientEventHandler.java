package com.crimsonbrood.unknownmagic.events.client;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

/**
 * Register Client Specific Events!
 */
@Mod.EventBusSubscriber(modid = UnknownMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        Logger clientLogger = LogUtils.getLogger();
        // Some client setup code
        clientLogger.info("HELLO from client setup :wave:");
        clientLogger.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
