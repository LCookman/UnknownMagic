package com.crimsonbrood.unknownmagic.items;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class EtherCreativeTab extends CreativeModeTab {
    public EtherCreativeTab(String id) {
        super (createEtherTab(id));
    }

    public static Builder createEtherTab(String id) {
        return CreativeModeTab.builder()
                .title(Component.translatable("creativetab." + id))
                .icon(() -> new ItemStack(EtherItems.SOLIDIFIED_ETHER.get()))
                .displayItems(new EtherItemDisplayGenerator());
    }

    static class EtherItemDisplayGenerator implements CreativeModeTab.DisplayItemsGenerator {
        @Override
        public void accept(@NotNull ItemDisplayParameters parameters, @NotNull Output output) {
            populateItems(output);
        }
    }

    private static Collection<RegistryEntry<Item>> getRegisteredItems() {
        return UnknownMagic.REGISTRATE.getAll(ForgeRegistries.ITEMS.getRegistryKey());
    }

    /**
     * From the Registered Items, populate the Ether tab with all item entries
     */
    private static void populateItems(Output output) {
        for (RegistryEntry<Item> entry : getRegisteredItems()) {
            output.accept(entry.get());
        }
    }
}
