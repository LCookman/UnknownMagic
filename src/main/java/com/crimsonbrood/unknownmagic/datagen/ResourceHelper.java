package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.registries.ForgeRegistries;

public class ResourceHelper {
    public static <I extends BlockItem> ItemModelBuilder simpleItemModel(
            DataGenContext<Item, I> context,
            RegistrateItemModelProvider provider
    ) {
        return provider
                .withExistingParent(context.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(UnknownMagic.MODID, "item/" + context.getId().getPath()));
    }

    public static <I extends BlockItem> ItemModelBuilder simpleItemModel(
            String locationMod,
            DataGenContext<Item, I> context,
            RegistrateItemModelProvider provider
    ) {
        return provider
                .withExistingParent(ForgeRegistries.BLOCKS.getKey(context.get().getBlock()).getPath(), provider.mcLoc("block/" + locationMod + "_inventory"))
                .texture("texture", new ResourceLocation(UnknownMagic.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(context.get().getBlock()).getPath()));

    }

    public static <I extends BlockItem> ItemModelBuilder simpleWallModel(
            DataGenContext<Item, I> context,
            RegistrateItemModelProvider provider,
            Block baseBlock
    ) {
        return provider
                .withExistingParent(ForgeRegistries.BLOCKS.getKey(context.get().getBlock()).getPath(), provider.mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(UnknownMagic.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }

    public static <I extends BlockItem> ItemModelBuilder simpleFenceModel(
            DataGenContext<Item, I> context,
            RegistrateItemModelProvider provider,
            Block baseBlock
    ) {
        return provider.withExistingParent(ForgeRegistries.BLOCKS.getKey(context.get().getBlock()).getPath(), provider.mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(UnknownMagic.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }

    public static <I extends BlockItem> ItemModelBuilder simpleTrapdoorModel(
            DataGenContext<Item, I> context,
            RegistrateItemModelProvider provider
    ) {
        Block block = context.get().getBlock();
        return provider.withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(),
                provider.modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_bottom"));
    }
}
