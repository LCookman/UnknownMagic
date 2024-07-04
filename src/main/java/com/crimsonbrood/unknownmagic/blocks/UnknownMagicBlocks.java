package com.crimsonbrood.unknownmagic.blocks;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.custom.SoundBlock;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class UnknownMagicBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UnknownMagic.MODID);

    public static final RegistryObject<Block> WHITESTONE_BLOCK = registerBlock("whitestone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));

    public static final RegistryObject<Block> ETHER_ORE = registerBlock("ether_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.5F, 3F).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> DEEPSLATE_ETHER_ORE = registerBlock("deepslate_ether_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5F, 3F).requiresCorrectToolForDrops(), UniformInt.of(4,8)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> WHITESTONE_STAIRS = registerBlock("whitestone_stairs",
            () -> new StairBlock(() -> UnknownMagicBlocks.WHITESTONE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));
    public static final RegistryObject<Block> WHITESTONE_SLAB = registerBlock("whitestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));

    public static final RegistryObject<Block> WHITESTONE_BUTTON = registerBlock("whitestone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, false));
    public static final RegistryObject<Block> WHITESTONE_PRESSURE_PLATE = registerBlock("whitestone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK), BlockSetType.IRON));

    public static final RegistryObject<Block> WHITESTONE_FENCE = registerBlock("whitestone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));
    public static final RegistryObject<Block> WHITESTONE_FENCE_GATE = registerBlock("whitestone_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK), SoundEvents.SHULKER_OPEN, SoundEvents.SHULKER_CLOSE));
    public static final RegistryObject<Block> WHITESTONE_WALL = registerBlock("whitestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));

    public static final RegistryObject<Block> WHITESTONE_DOOR = registerBlock("whitestone_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> WHITESTONE_TRAPDOOR = registerBlock("whitestone_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK).noOcclusion(), BlockSetType.IRON));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return UnknownMagicItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
}
