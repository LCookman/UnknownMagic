package com.crimsonbrood.unknownmagic.items;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import static com.crimsonbrood.unknownmagic.UnknownMagic.REGISTRATE;

public class EtherCreativeTabs {
    public static final RegistryEntry<CreativeModeTab> ETHER_CREATIVE_TAB = REGISTRATE
            .creativeTab("ether", REGISTRATE, builder -> builder
                    .icon(EtherItems.SOLIDIFIED_ETHER::asStack)
                    .displayItems(new EtherItemDisplayGenerator())
                    .title(REGISTRATE.addLang("creativetab", new ResourceLocation(UnknownMagic.MODID, "ether"), "Ether"))
                    .build())
            .register();

    /**
     * Load the class and it's static fields
     */
    public static void register() {}

    /**
     * Inner Class: EtherItemDisplayGenerator
     * <p>
     * Description: Generate a list of items to populate the creative mode tab with
     * TODO: Maybe we can populate different tabs based on item tags or predefined groups of items?
     * </p>
     */
    private static class EtherItemDisplayGenerator implements CreativeModeTab.DisplayItemsGenerator {
        @Override
        public void accept(@NotNull CreativeModeTab.ItemDisplayParameters parameters, @NotNull CreativeModeTab.Output output) {
            populateItems(output);
        }

        /**
         * From the Registered Items, populate the Ether tab with all item entries
         */
        private static void populateItems(CreativeModeTab.Output output) {
            for (RegistryEntry<Item> entry : REGISTRATE.getRegisteredItems()) {
                output.accept(entry.get());
            }
        }
    }
}
