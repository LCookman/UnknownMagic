package com.crimsonbrood.unknownmagic.events;

import com.crimsonbrood.unknownmagic.Config;
import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
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
public class UnknownMagicEventHandler {

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

    // TODO: Pull out this method into a creative event handler class?
    // Add the example block item to the building blocks tab
    @SubscribeEvent
    public static void onAddCreative(BuildCreativeModeTabContentsEvent event) {
        RegistryObject<Item> umItem = RegistryObject.create(new ResourceLocation(UnknownMagic.MODID, "um_item"), ForgeRegistries.ITEMS);
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(umItem);
        }
    }

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        // TODO: This is probably not the ideal way to do this we need a RegistryObject<Block> as instantiating this here isn't ideal. For now we can create them inline
        LOGGER.info("Hello from the register() event!");

        event.register(ForgeRegistries.Keys.BLOCKS, blockRegisterHelper -> {
            blockRegisterHelper.register(new ResourceLocation(MODID, "um_block"), new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
        });

        RegistryObject<Block> umBlock = RegistryObject.create(new ResourceLocation(MODID,"um_block"), ForgeRegistries.BLOCKS);
        event.register(ForgeRegistries.Keys.ITEMS, itemRegisterHelper -> {
            itemRegisterHelper.register(new ResourceLocation(MODID, "um_block"), new BlockItem(umBlock.get(), new Item.Properties()));

            itemRegisterHelper.register(new ResourceLocation(MODID, "um_item"), new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .alwaysEat().nutrition(4).saturationMod(4f).build())));
        });

        RegistryObject<Item> umItem = RegistryObject.create(new ResourceLocation(MODID, "um_block"), ForgeRegistries.ITEMS);
        event.register(Registries.CREATIVE_MODE_TAB, creativeModeTabRegisterHelper -> {
            creativeModeTabRegisterHelper.register(new ResourceLocation("um_tab"), CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(Items.WRITABLE_BOOK::getDefaultInstance)
                    .displayItems((parameters, output) -> {
                        output.accept(umItem.get());
                    }).build());
        });
    }
}
