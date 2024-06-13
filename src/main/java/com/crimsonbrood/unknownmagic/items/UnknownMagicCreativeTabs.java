package com.crimsonbrood.unknownmagic.items;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UnknownMagicCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnknownMagic.MODID);

    public static final RegistryObject<CreativeModeTab> UNKNOWN_MAGIC_TAB = CREATIVE_MODE_TABS.register("unknownmagic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(UnknownMagicItems.WHITESTONE.get()))
                    .title(Component.translatable("creativetab.unknownmagic_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(UnknownMagicItems.WHITESTONE.get());
                        pOutput.accept(UnknownMagicItems.RAW_ETHER.get());

                        pOutput.accept(UnknownMagicBlocks.ETHER_ORE.get());
                        pOutput.accept(UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
