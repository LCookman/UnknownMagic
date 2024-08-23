package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.EtherBlocks;
import com.crimsonbrood.unknownmagic.tags.EtherTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EtherBlockTagGenerator extends BlockTagsProvider {

    public EtherBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UnknownMagic.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(EtherTags.Blocks.ETHER_DETECTABLE)
                .add(EtherBlocks.ETHER_ORE.get(),
                        EtherBlocks.DEEPSLATE_ETHER_ORE.get()
                ).addTag(Tags.Blocks.ORES_DIAMOND);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EtherBlocks.ETHER_ORE.get(),
                        EtherBlocks.DEEPSLATE_ETHER_ORE.get(),
                        EtherBlocks.WHITESTONE_BLOCK.get(),
                        EtherBlocks.SOUND_BLOCK.get(),
                        EtherBlocks.VAROOT_STONE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(EtherBlocks.WHITESTONE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(EtherBlocks.ETHER_ORE.get(),
                        EtherBlocks.DEEPSLATE_ETHER_ORE.get(),
                        EtherBlocks.VAROOT_STONE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(EtherBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(EtherBlocks.WHITESTONE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(EtherBlocks.WHITESTONE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(EtherBlocks.WHITESTONE_WALL.get());
    }
}
