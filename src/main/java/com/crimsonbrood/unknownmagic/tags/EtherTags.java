package com.crimsonbrood.unknownmagic.tags;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EtherTags {
    public static class Blocks {
        public static final TagKey<Block> ETHER_DETECTABLE = tag("ether_detectable");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(UnknownMagic.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> WHITESTONE = tag("whitestone");
        public static final TagKey<Item> ETHER_SMELTABLE = tag("ether_smeltable");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(UnknownMagic.MODID, name));
        }
    }
}
