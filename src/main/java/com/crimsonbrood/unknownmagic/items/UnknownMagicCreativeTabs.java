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

    public static final RegistryObject<CreativeModeTab> UNKNOWN_MAGIC_TAB = CREATIVE_MODE_TABS.register(UnknownMagic.MODID + "_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(UnknownMagicItems.ETHER.get()))
                    .title(Component.translatable("creativetab.unknownmagic_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(UnknownMagicItems.WHITESTONE.get());
                        pOutput.accept(UnknownMagicItems.RAW_ETHER.get());
                        pOutput.accept(UnknownMagicItems.ETHER.get());
                        pOutput.accept(UnknownMagicItems.VAROOT_STONE.get());

                        pOutput.accept(UnknownMagicBlocks.ETHER_ORE.get());
                        pOutput.accept(UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_BLOCK.get());

                        // Tutorial Items (Remove Later or Destroy The Branch)
                        pOutput.accept(UnknownMagicItems.ETHER_DETECTOR.get());
                        pOutput.accept(UnknownMagicBlocks.SOUND_BLOCK.get());
                        pOutput.accept(UnknownMagicItems.STRAWBERRY.get());
                        pOutput.accept(UnknownMagicItems.PINE_CONE.get());

                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_STAIRS.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_SLAB.get());

                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_BUTTON.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_PRESSURE_PLATE.get());

                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_FENCE.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_FENCE_GATE.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_WALL.get());

                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_DOOR.get());
                        pOutput.accept(UnknownMagicBlocks.WHITESTONE_TRAPDOOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
