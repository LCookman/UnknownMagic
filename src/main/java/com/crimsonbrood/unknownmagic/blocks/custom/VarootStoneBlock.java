package com.crimsonbrood.unknownmagic.blocks.custom;

import com.crimsonbrood.unknownmagic.blocks.WaterloggableBlock;
import com.crimsonbrood.unknownmagic.blockstate.UnknownMagicBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * Class: VarootStoneBlock
 * <p>
 * Description: The Varoot stone is the most basic storage of ether in the mod. They can cluster between 1 - 4 stones
 * similar to a turtle egg.
 * </p>
 *
 * TODO:
 *  1. Make this mineable by diamond or higher pickaxes and have to have Silk Tough to do so
 *  2. Add an Ether amount to individual block items. We need to implement the Ether system before we do that though
 *  3. We need to actually make a decent model for this block, maybe add more shapes to the block
 */
public class VarootStoneBlock extends WaterloggableBlock {
    public static final IntegerProperty STONES = UnknownMagicBlockStateProperties.STONES;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape ONE_STONE_AABB = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 7.0D, 12.0D);
    private static final VoxelShape MULTIPLE_STONES_AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 7.0D, 15.0D);

    public VarootStoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(STONES, Integer.valueOf(UnknownMagicBlockStateProperties.MIN_STONES))
                        .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STONES, FACING);
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
        this.decreaseStones(pLevel, pPos, pState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockState blockState = placeContext.getLevel().getBlockState(placeContext.getClickedPos());
        if (blockState.is(this)) {
            blockState = blockState.setValue(STONES, Integer.valueOf(Math.min(UnknownMagicBlockStateProperties.MAX_STONES, blockState.getValue(STONES) + 1)));
        } else {
            blockState = super.getStateForPlacement(placeContext);
            blockState = blockState.setValue(FACING, placeContext.getHorizontalDirection());
        }

        return blockState;
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext useContext) {
        Boolean test = !useContext.isSecondaryUseActive()
                && useContext.getItemInHand().is(this.asItem())
                && blockState.getValue(STONES) < UnknownMagicBlockStateProperties.MAX_STONES
                || super.canBeReplaced(blockState, useContext);
        return test;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return blockState.getValue(STONES) > 1 ? MULTIPLE_STONES_AABB : ONE_STONE_AABB;
    }


    private void decreaseStones(Level pLevel, BlockPos pPos, BlockState pState) {
        pLevel.playSound((Player) null, pPos, SoundEvents.BASALT_BREAK, SoundSource.BLOCKS);
        int i = pState.getValue(STONES);
        if (i <= 1) {
            pLevel.destroyBlock(pPos, false);
        } else {
            pLevel.setBlock(pPos, pState.setValue(STONES, Integer.valueOf(i - 1)), 2);
            pLevel.gameEvent(GameEvent.BLOCK_DESTROY, pPos, GameEvent.Context.of(pState));
            pLevel.levelEvent(2001, pPos, Block.getId(pState));
        }
    }
}
