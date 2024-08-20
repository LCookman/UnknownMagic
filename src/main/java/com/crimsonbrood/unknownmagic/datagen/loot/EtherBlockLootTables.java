package com.crimsonbrood.unknownmagic.datagen.loot;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.EtherBlocks;
import com.crimsonbrood.unknownmagic.items.EtherItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EtherBlockLootTables extends BlockLootSubProvider {

    public EtherBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter((block) -> UnknownMagic.MODID.equals(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getNamespace()))
                .collect(Collectors.toList());
    }

    @Override
    protected void generate() {
        this.dropSelf(EtherBlocks.WHITESTONE_BLOCK.get());

        this.add(EtherBlocks.ETHER_ORE.get(),
                block -> createEtherOreDrop(EtherBlocks.ETHER_ORE.get(), EtherItems.RAW_ETHER.get())
        );
        this.add(EtherBlocks.DEEPSLATE_ETHER_ORE.get(),
                block -> createEtherOreDrop(EtherBlocks.DEEPSLATE_ETHER_ORE.get(), EtherItems.RAW_ETHER.get())
        );

        this.dropWhenSilkTouch(EtherBlocks.VAROOT_STONE.get());

        // TODO: Remove this later
        this.dropSelf(EtherBlocks.SOUND_BLOCK.get());

        this.dropSelf(EtherBlocks.WHITESTONE_STAIRS.get());
        this.dropSelf(EtherBlocks.WHITESTONE_BUTTON.get());
        this.dropSelf(EtherBlocks.WHITESTONE_PRESSURE_PLATE.get());
        this.dropSelf(EtherBlocks.WHITESTONE_TRAPDOOR.get());
        this.dropSelf(EtherBlocks.WHITESTONE_FENCE.get());
        this.dropSelf(EtherBlocks.WHITESTONE_FENCE_GATE.get());
        this.dropSelf(EtherBlocks.WHITESTONE_WALL.get());

        this.add(EtherBlocks.WHITESTONE_SLAB.get(),
                block -> createSlabItemTable(EtherBlocks.WHITESTONE_SLAB.get()));
        this.add(EtherBlocks.WHITESTONE_DOOR.get(),
                block -> createDoorTable(EtherBlocks.WHITESTONE_DOOR.get()));
    }

    protected LootTable.Builder createEtherOreDrop(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }
}
