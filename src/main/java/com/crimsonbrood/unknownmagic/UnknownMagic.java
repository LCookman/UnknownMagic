package com.crimsonbrood.unknownmagic;

import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.items.UnknownMagicCreativeTabs;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
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
    public static final String MODNAME = "Unknown Magic";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final EtherRegistrate REGISTRATE = EtherRegistrate.create(MODID);

    public UnknownMagic()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);
        register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private static void register() {
        UnknownMagicItems.register();
        UnknownMagicBlocks.register();
        UnknownMagicCreativeTabs.register();
    }
}
