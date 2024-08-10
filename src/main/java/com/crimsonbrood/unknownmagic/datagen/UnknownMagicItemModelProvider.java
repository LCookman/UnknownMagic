package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UnknownMagicItemModelProvider extends ItemModelProvider {
    public UnknownMagicItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UnknownMagic.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        simpleItem(UnknownMagicItems.RAW_ETHER);
//        simpleItem(UnknownMagicItems.ETHER);
//        simpleItem(UnknownMagicItems.WHITESTONE);
//
//        // Remove ether detector here since we made a custom model
//        // simpleItem(UnknownMagicItems.ETHER_DETECTOR);
//        simpleItem(UnknownMagicItems.STRAWBERRY);
//        simpleItem(UnknownMagicItems.PINE_CONE);

        // When generating models we need to generate the item models for corresponding blocks
//        simpleBlockItem(UnknownMagicBlocks.WHITESTONE_DOOR);
//        simpleBlockItem(UnknownMagicBlocks.VAROOT_STONE);

//        evenSimplerBlockItem(UnknownMagicBlocks.WHITESTONE_STAIRS);
//        evenSimplerBlockItem(UnknownMagicBlocks.WHITESTONE_SLAB);
//        evenSimplerBlockItem(UnknownMagicBlocks.WHITESTONE_PRESSURE_PLATE);
//        evenSimplerBlockItem(UnknownMagicBlocks.WHITESTONE_FENCE_GATE);
//
//        fenceItem((Block)UnknownMagicBlocks.WHITESTONE_FENCE.get(), (Block) UnknownMagicBlocks.WHITESTONE_BLOCK.get());
//        buttonItem(UnknownMagicBlocks.WHITESTONE_BUTTON, UnknownMagicBlocks.WHITESTONE_BLOCK);
//        wallItem(UnknownMagicBlocks.WHITESTONE_WALL, UnknownMagicBlocks.WHITESTONE_BLOCK);
//        trapdoorItem(UnknownMagicBlocks.WHITESTONE_TRAPDOOR);
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(UnknownMagic.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(UnknownMagic.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(UnknownMagic.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture(
                "layer0", new ResourceLocation(UnknownMagic.MODID, "item/" + item.getId().getPath())
        );
    }

    public ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UnknownMagic.MODID, "item/" + item.getId().getPath()));
    }

    private void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(UnknownMagic.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}
