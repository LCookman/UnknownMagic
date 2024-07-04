package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class UnknownMagicBlockStateProvider extends BlockStateProvider {
    public UnknownMagicBlockStateProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, UnknownMagic.MODID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(UnknownMagicBlocks.ETHER_ORE);
        blockWithItem(UnknownMagicBlocks.DEEPSLATE_ETHER_ORE);

        blockWithItem(UnknownMagicBlocks.WHITESTONE_BLOCK);

        stairsBlock((StairBlock) UnknownMagicBlocks.WHITESTONE_STAIRS.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));
        slabBlock((SlabBlock) UnknownMagicBlocks.WHITESTONE_SLAB.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));

        buttonBlock((ButtonBlock) UnknownMagicBlocks.WHITESTONE_BUTTON.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) UnknownMagicBlocks.WHITESTONE_PRESSURE_PLATE.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));

        fenceBlock((FenceBlock) UnknownMagicBlocks.WHITESTONE_FENCE.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) UnknownMagicBlocks.WHITESTONE_FENCE_GATE.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));
        wallBlock((WallBlock) UnknownMagicBlocks.WHITESTONE_WALL.get(), blockTexture(UnknownMagicBlocks.WHITESTONE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) UnknownMagicBlocks.WHITESTONE_DOOR.get(), modLoc("block/whitestone_door_bottom"), modLoc("block/whitestone_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) UnknownMagicBlocks.WHITESTONE_TRAPDOOR.get(), modLoc("block/whitestone_trapdoor"), true, "cutout");

        // TODO: Remove This
        blockWithItem(UnknownMagicBlocks.SOUND_BLOCK);
    }

    // Custom methods for extending the BlockStateProvider functionality
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
