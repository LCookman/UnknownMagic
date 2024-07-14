package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.tags.UnknownMagicTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UnknownMagicBlockTagGenerator extends BlockTagsProvider {

    public UnknownMagicBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UnknownMagic.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(UnknownMagicTags.Blocks.ETHER_DETECTABLE)
                .add(UnknownMagicBlocks.ETHER_ORE.get(),
                        UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get()
                ).addTag(Tags.Blocks.ORES_DIAMOND);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UnknownMagicBlocks.ETHER_ORE.get(),
                        UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get(),
                        UnknownMagicBlocks.WHITESTONE_BLOCK.get(),
                        UnknownMagicBlocks.SOUND_BLOCK.get(),
                        UnknownMagicBlocks.VAROOT_STONE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(UnknownMagicBlocks.WHITESTONE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(UnknownMagicBlocks.ETHER_ORE.get(),
                        UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get(),
                        UnknownMagicBlocks.VAROOT_STONE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(UnknownMagicBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(UnknownMagicBlocks.WHITESTONE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(UnknownMagicBlocks.WHITESTONE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(UnknownMagicBlocks.WHITESTONE_WALL.get());
    }
}
