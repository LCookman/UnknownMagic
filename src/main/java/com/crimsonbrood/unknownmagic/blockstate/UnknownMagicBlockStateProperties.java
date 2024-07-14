package com.crimsonbrood.unknownmagic.blockstate;

import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class UnknownMagicBlockStateProperties {
    public static final int MIN_STONES = 1;
    public static final int MAX_STONES = 4;

    public static final IntegerProperty STONES = IntegerProperty.create("stones", MIN_STONES, MAX_STONES);
}
