package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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

        // TODO: Remove This
        blockWithItem(UnknownMagicBlocks.SOUND_BLOCK);
    }

    // Custom methods for extending the BlockStateProvider functionality
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
