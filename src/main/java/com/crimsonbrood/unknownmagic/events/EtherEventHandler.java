package com.crimsonbrood.unknownmagic.events;

import com.crimsonbrood.unknownmagic.Config;
import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

/**
 * <p>
 * Class: UnknownMagicEventHandler
 * Function: Register the main event handlers for the Mod
 * </p>
 *
 * NOTES:
 * - We can register our own registry through the `NewRegistryEvent` and we can use the RegistryBuilder to build it.
 * TODO:
 *  The top level event subscriber class, we may want to split this up into different more specialized files later on
 */
@Mod.EventBusSubscriber(modid = UnknownMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EtherEventHandler {

    private static final String MODID = UnknownMagic.MODID;
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        boolean test = Config.logDirtBlock;

        if (Config.logDirtBlock) {
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        }

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
}
