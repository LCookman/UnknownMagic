package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.datagen.loot.UnknownMagicBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class UnknownMagicLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(UnknownMagicBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
