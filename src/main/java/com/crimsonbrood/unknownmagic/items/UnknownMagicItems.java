package com.crimsonbrood.unknownmagic.items;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.items.custom.EtherDetectorItem;
import com.crimsonbrood.unknownmagic.items.custom.EtherItem;
import com.crimsonbrood.unknownmagic.items.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UnknownMagicItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UnknownMagic.MODID);

    public static final RegistryObject<Item> WHITESTONE = ITEMS.register("whitestone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ETHER = ITEMS.register("raw_ether",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ETHER = ITEMS.register("ether",
            () -> new EtherItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> VAROOT_STONE = ITEMS.register("varoot_stone",
            () -> new Item(new Item.Properties()));


    // TODO: Remove the below registered items and associated textures/blocks as they are mainly just tutorial items
    public static final RegistryObject<Item> ETHER_DETECTOR = ITEMS.register("ether_detector",
            () -> new EtherDetectorItem(new Item.Properties().durability(150)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(UnknownMagicFoods.STRAWBERRY)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
