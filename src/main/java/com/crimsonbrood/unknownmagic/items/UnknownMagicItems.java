package com.crimsonbrood.unknownmagic.items;

import com.crimsonbrood.unknownmagic.datagen.ResourceHelper;
import com.crimsonbrood.unknownmagic.items.custom.EtherDetectorItem;
import com.crimsonbrood.unknownmagic.items.custom.EtherItem;
import com.crimsonbrood.unknownmagic.items.custom.FuelItem;
import com.crimsonbrood.unknownmagic.tags.UnknownMagicTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.crimsonbrood.unknownmagic.UnknownMagic.REGISTRATE;

public class UnknownMagicItems {

    public static final ItemEntry<Item> WHITESTONE = REGISTRATE
            .item("whitestone", Item::new)
            .register();
    // TODO: We should be able to continue with the recipie overhaul I wanted to do now that we downgraded to that of Create. So REGISTRATE should function as intended.

    public static final ItemEntry<Item> RAW_ETHER = REGISTRATE
            .item("raw_ether", Item::new)
            .tag(UnknownMagicTags.Items.ETHER_SMELTABLE)
            .register();

    public static final ItemEntry<EtherItem> SOLIDIFIED_ETHER = REGISTRATE
            .item("solidified_ether", p -> new EtherItem(p.stacksTo(16)))
            .register();

    public static final ItemEntry<EtherDetectorItem> ETHER_DETECTOR = REGISTRATE
            .item("ether_detector", EtherDetectorItem::new)
            .properties(p -> p.durability(500))
//            .model(ResourceHelper.itemModelWithPartials())
            .register();

    // TODO: Remove the below registered items and associated textures/blocks as they are mainly just tutorial items
    public static final ItemEntry<Item> STRAWBERRY = REGISTRATE
            .item("strawberry", Item::new)
            .properties(p -> p.food(UnknownMagicFoods.STRAWBERRY))
            .register();

    public static final ItemEntry<FuelItem> PINE_CONE = REGISTRATE
            .item("pine_cone", p -> new FuelItem(p, 400))
            .register();

    public static void register() { }
}
