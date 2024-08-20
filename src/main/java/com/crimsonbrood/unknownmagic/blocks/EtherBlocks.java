package com.crimsonbrood.unknownmagic.blocks;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.custom.SoundBlock;
import com.crimsonbrood.unknownmagic.blocks.custom.VarootStoneBlock;
import com.crimsonbrood.unknownmagic.datagen.ResourceHelper;
import com.crimsonbrood.unknownmagic.datagen.recipe.RecipeHelper;
import com.crimsonbrood.unknownmagic.tags.EtherTags;
import com.crimsonbrood.unknownmagic.utility.BlockStateTransformer;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class EtherBlocks {

    public static final RegistryEntry<DropExperienceBlock> ETHER_ORE = UnknownMagic.REGISTRATE
            .block("ether_ore", supplyExperienceBlock(UniformInt.of(4, 8)))
            .initialProperties(() -> Blocks.STONE)
            .properties(p -> {
                p.strength(3.5f, 3f);
                p.requiresCorrectToolForDrops();
                return p;
            })
            .item()
            .tag(EtherTags.Items.ETHER_SMELTABLE)
            .build()
            .register();

    public static final RegistryEntry<DropExperienceBlock> DEEPSLATE_ETHER_ORE = UnknownMagic.REGISTRATE
            .block("deepslate_ether_ore", supplyExperienceBlock(UniformInt.of(4,8)))
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(p -> p.strength(5F, 3F).requiresCorrectToolForDrops())
            .item()
            .tag(EtherTags.Items.ETHER_SMELTABLE)
            .build()
            .register();

    // TODO: We need to add custom block model handling in here and add Transform to add item model instead of simpleItem based on block
    public static final RegistryEntry<VarootStoneBlock> VAROOT_STONE = UnknownMagic.REGISTRATE
            .block("varoot_stone", VarootStoneBlock::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(p -> {
                p.strength(5F);
                p.noOcclusion();
                p.lightLevel(blockstate -> 1 + 3 * blockstate.getValue(VarootStoneBlock.STONES));
                return p;
            })
            .transform(BlockStateTransformer.createVarootStoneModels())
            .item()
            .model(ResourceHelper::simpleItemModel)
            .build()
            .register();

    // TODO: Add in the item model handling for all of the whitestone stuff
    public static final RegistryEntry<Block> WHITESTONE_BLOCK = UnknownMagic.REGISTRATE
            .block("whitestone_block", Block::new)
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .simpleItem()
            .register();

    public static final RegistryEntry<StairBlock> WHITESTONE_STAIRS = UnknownMagic.REGISTRATE
            .block("whitestone_stairs", p -> new StairBlock(() -> WHITESTONE_BLOCK.get().defaultBlockState(), p))
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) ->
                    provider.stairsBlock(context.get(), provider.blockTexture(EtherBlocks.WHITESTONE_BLOCK.get())))
            .simpleItem()
            .register();

    public static final RegistryEntry<SlabBlock> WHITESTONE_SLAB = UnknownMagic.REGISTRATE
            .block("whitestone_slab", SlabBlock::new)
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) -> {
                Block block = EtherBlocks.WHITESTONE_BLOCK.get();
                provider.slabBlock(context.get(), provider.blockTexture(block), provider.blockTexture(block));
            })
            .simpleItem()
            .register();

    public static final RegistryEntry<ButtonBlock> WHITESTONE_BUTTON = UnknownMagic.REGISTRATE
            .block("whitestone_button", p -> new ButtonBlock(p, BlockSetType.IRON, 10, false))
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) ->
                    provider.buttonBlock(context.get(), provider.blockTexture(EtherBlocks.WHITESTONE_BLOCK.get())))
            .simpleItem()
            .register();

    public static final RegistryEntry<PressurePlateBlock> WHITESTONE_PRESSURE_PLATE = UnknownMagic.REGISTRATE
            .block("whitestone_pressure_plate", p -> new PressurePlateBlock(
                    PressurePlateBlock.Sensitivity.EVERYTHING,
                    p,
                    BlockSetType.IRON
            ))
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) ->
                    provider.pressurePlateBlock(context.get(), provider.blockTexture(EtherBlocks.WHITESTONE_BLOCK.get())))
            .simpleItem()
            .register();

    public static final RegistryEntry<FenceBlock> WHITESTONE_FENCE = UnknownMagic.REGISTRATE
            .block("whitestone_fence", FenceBlock::new)
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) ->
                    provider.fenceBlock((FenceBlock) context.get(), provider.blockTexture(EtherBlocks.WHITESTONE_BLOCK.get())))
            .item()
            .model((context, provider) -> ResourceHelper.simpleFenceModel(context, provider, WHITESTONE_BLOCK.get()))
            .build()
            .register();

    public static final RegistryEntry<FenceGateBlock> WHITESTONE_FENCE_GATE = UnknownMagic.REGISTRATE
            .block("whitestone_fence_gate", p -> new FenceGateBlock(
                    p,
                    SoundEvents.SHULKER_OPEN,
                    SoundEvents.SHULKER_CLOSE
            ))
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) ->
                    provider.fenceGateBlock(context.get(), provider.blockTexture(EtherBlocks.WHITESTONE_BLOCK.get())))
            .simpleItem()
            .register();

    public static final RegistryEntry<WallBlock> WHITESTONE_WALL = UnknownMagic.REGISTRATE
            .block("whitestone_wall", WallBlock::new)
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .blockstate((context, provider) ->
                    provider.wallBlock(context.get(), provider.blockTexture(EtherBlocks.WHITESTONE_BLOCK.get())))
            .item()
            .model((context, provider) -> ResourceHelper.simpleWallModel(context, provider, WHITESTONE_BLOCK.get()))
            .build()
            .register();

    public static final RegistryEntry<DoorBlock> WHITESTONE_DOOR = UnknownMagic.REGISTRATE
            .block("whitestone_door", p -> new DoorBlock(p, BlockSetType.IRON))
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .blockstate((context, provider) -> {
                ResourceLocation bottom = provider.modLoc("block/whitestone_door_bottom");
                ResourceLocation top = provider.modLoc("block/whitestone_door_top");
                provider.doorBlockWithRenderType(context.get(), bottom, top, "cutout");
            })
            .item()
            .model(ResourceHelper::simpleItemModel)
            .build()
            .register();

    public static final RegistryEntry<TrapDoorBlock> WHITESTONE_TRAPDOOR = UnknownMagic.REGISTRATE
            .block("whitestone_trapdoor", p -> new TrapDoorBlock(p, BlockSetType.IRON))
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .blockstate((context, provider) -> {
                ResourceLocation trapDoorLoc = provider.modLoc("block/whitestone_trapdoor");
                provider.trapdoorBlockWithRenderType(context.get(), trapDoorLoc, true, "cutout");
            })
            .item()
            .model(ResourceHelper::simpleTrapdoorModel)
            .build()
            .register();


    /**
     * TODO: REMOVE THE FOLLOWING BLOCKS
     */
    public static final RegistryEntry<SoundBlock> SOUND_BLOCK = UnknownMagic.REGISTRATE
            .block("sound_block", SoundBlock::new)
            .initialProperties(() -> Blocks.REDSTONE_BLOCK)
            .simpleItem()
            .register();

    private static NonNullFunction<BlockBehaviour.Properties, DropExperienceBlock> supplyExperienceBlock(UniformInt expDrop) {
        return b -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE), expDrop);
    }

    // Load this class and its static fields
    public static void register() {}
}
