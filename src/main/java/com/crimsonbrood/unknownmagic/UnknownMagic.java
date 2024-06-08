package com.crimsonbrood.unknownmagic;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnknownMagic.MODID)
public class UnknownMagic
{
    public static final String MODID = "unknownmagic";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public UnknownMagic()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        /*
         Registering is done through the UnknownMagicEventHandler Class automatically via static event handlers

         Server Specific: ServerEventHandler
         Client Specific: ClientEventHandler

         Our registry registration is also handled through the register() event handler
         */

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
