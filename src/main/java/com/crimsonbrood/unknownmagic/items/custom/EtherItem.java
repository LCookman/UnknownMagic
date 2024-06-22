package com.crimsonbrood.unknownmagic.items.custom;

import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EtherItem extends Item {
    public EtherItem(Properties pProp) {
        super(pProp);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
        if (stack.is(UnknownMagicItems.ETHER.get())) {
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20));
        }
    }
}
