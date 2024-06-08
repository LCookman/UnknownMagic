package com.crimsonbrood.unknownmagic.events.server;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

/**
 * Register Server Specific Events!
 */
@Mod.EventBusSubscriber(modid = UnknownMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerEventHandler {
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        Logger serverLogger = LogUtils.getLogger();
        serverLogger.info("HELLO from server starting :wave:");
    }
}
