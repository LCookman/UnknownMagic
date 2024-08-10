package com.crimsonbrood.unknownmagic.utility;

import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.blocks.custom.VarootStoneBlock;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ConfiguredModel;

public class BlockStateTransformer {
    public static <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> createVarootStoneModels() {
        return builder -> builder.blockstate((context, provider) -> {
            provider.getVariantBuilder(UnknownMagicBlocks.VAROOT_STONE.get()).forAllStatesExcept(state -> {
                int stateValue = state.getValue(VarootStoneBlock.STONES);
                ResourceLocation loc;
                int rotation = 0;

                switch (stateValue) {
                    case 1:
                    default:
                        loc = provider.modLoc("varoot_stones");
                        break;
                    case 2:
                        loc = provider.modLoc("two_varoot_stones");
                        break;
                    case 3:
                        loc = provider.modLoc("three_varoot_stones");
                        break;
                    case 4:
                        loc = provider.modLoc("four_varoot_stones");
                        break;
                }

                Direction direction = state.getValue(VarootStoneBlock.FACING);
                switch (direction) {
                    case EAST -> rotation = 90;
                    case SOUTH -> rotation = 180;
                    case WEST -> rotation = 270;
                }

                return ConfiguredModel.builder()
                        .modelFile(provider.models().getExistingFile(loc))
                        .uvLock(false)
                        .rotationY(rotation)
                        .build();
            });
        });
    }
}
