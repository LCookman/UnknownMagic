package com.crimsonbrood.unknownmagic.datagen.recipe;

import com.crimsonbrood.unknownmagic.blocks.EtherBlocks;
import com.crimsonbrood.unknownmagic.items.EtherItems;
import com.crimsonbrood.unknownmagic.tags.EtherTags;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Item;

public class RecipeHelper {
    public static final DataIngredient ETHER_SMELTABLES = DataIngredient.tag(EtherTags.Items.ETHER_SMELTABLE);
    public static final DataIngredient WHITESTONE = DataIngredient.ingredient(null, EtherItems.WHITESTONE);
    public static final DataIngredient WHITESTONE_BLOCK = DataIngredient.ingredient(null, EtherBlocks.WHITESTONE_BLOCK.get());

    public static <T extends Item> void smeltAndBlast(DataGenContext<Item, T> context, RegistrateRecipeProvider provider, DataIngredient ingredient) {
        provider.smeltingAndBlasting(ingredient, RecipeCategory.MISC, EtherItems.SOLIDIFIED_ETHER, 2.0f);
    }
}
