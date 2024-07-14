package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class UnknownMagicRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ETHER_SMELTABLES = List.of(UnknownMagicBlocks.ETHER_ORE.get(),
            UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get(), UnknownMagicItems.RAW_ETHER.get());

    public UnknownMagicRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        oreSmelting(pRecipeOutput, ETHER_SMELTABLES, RecipeCategory.MISC, UnknownMagicItems.ETHER.get(), 2.0f, 250, "ether");
        oreBlasting(pRecipeOutput, ETHER_SMELTABLES, RecipeCategory.MISC, UnknownMagicItems.ETHER.get(), 2.0f, 150, "ether");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UnknownMagicBlocks.WHITESTONE_BLOCK.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', UnknownMagicItems.WHITESTONE.get())
                .unlockedBy(getHasName(UnknownMagicItems.WHITESTONE.get()), has(UnknownMagicItems.WHITESTONE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UnknownMagicItems.WHITESTONE.get(), 9)
                .requires(UnknownMagicBlocks.WHITESTONE_BLOCK.get())
                .unlockedBy(getHasName(UnknownMagicBlocks.WHITESTONE_BLOCK.get()), has(UnknownMagicBlocks.WHITESTONE_BLOCK.get()))
                .save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, UnknownMagic.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
