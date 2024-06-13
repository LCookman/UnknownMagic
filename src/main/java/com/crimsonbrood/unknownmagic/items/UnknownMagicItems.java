package com.crimsonbrood.unknownmagic.items;

import com.crimsonbrood.unknownmagic.UnknownMagic;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
