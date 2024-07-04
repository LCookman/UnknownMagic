package com.crimsonbrood.unknownmagic.datagen.loot;

import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class UnknownMagicBlockLootTables extends BlockLootSubProvider {

    public UnknownMagicBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_BLOCK.get());

        this.add(UnknownMagicBlocks.ETHER_ORE.get(),
                block -> createEtherOreDrop(UnknownMagicBlocks.ETHER_ORE.get(), UnknownMagicItems.RAW_ETHER.get())
        );
        this.add(UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get(),
                block -> createEtherOreDrop(UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get(), UnknownMagicItems.RAW_ETHER.get())
        );

        // TODO: Remove this later
        this.dropSelf(UnknownMagicBlocks.SOUND_BLOCK.get());

        this.dropSelf(UnknownMagicBlocks.WHITESTONE_STAIRS.get());
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_BUTTON.get());
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_PRESSURE_PLATE.get());
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_TRAPDOOR.get());
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_FENCE.get());
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_FENCE_GATE.get());
        this.dropSelf(UnknownMagicBlocks.WHITESTONE_WALL.get());

        this.add(UnknownMagicBlocks.WHITESTONE_SLAB.get(),
                block -> createSlabItemTable(UnknownMagicBlocks.WHITESTONE_SLAB.get()));
        this.add(UnknownMagicBlocks.WHITESTONE_DOOR.get(),
                block -> createDoorTable(UnknownMagicBlocks.WHITESTONE_DOOR.get()));
    }

    protected LootTable.Builder createEtherOreDrop(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(pItem)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return UnknownMagicBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
