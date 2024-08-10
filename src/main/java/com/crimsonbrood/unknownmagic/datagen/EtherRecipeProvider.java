package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.EtherRegistrate;
import com.crimsonbrood.unknownmagic.UnknownMagic;
import com.crimsonbrood.unknownmagic.blocks.UnknownMagicBlocks;
import com.crimsonbrood.unknownmagic.items.UnknownMagicItems;
import com.crimsonbrood.unknownmagic.tags.UnknownMagicTags;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class EtherRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private final RegistrateRecipeProvider recipeProvider;

    private static final List<ItemLike> ETHER_SMELTABLES = List.of(UnknownMagicBlocks.ETHER_ORE.get(),
            UnknownMagicBlocks.DEEPSLATE_ETHER_ORE.get(), UnknownMagicItems.RAW_ETHER.get());

    public EtherRecipeProvider(RegistrateRecipeProvider provider,  PackOutput output) {
        super(output);
        recipeProvider = provider;
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> writer) {
        DataIngredient smeltableEther = DataIngredient.tag(UnknownMagicTags.Items.ETHER_SMELTABLE);
        recipeProvider.smeltingAndBlasting(smeltableEther, RecipeCategory.MISC, UnknownMagicItems.SOLIDIFIED_ETHER, 2.0f);
//        oreSmelting(writer, ETHER_SMELTABLES, RecipeCategory.MISC, UnknownMagicItems.SOLIDIFIED_ETHER.get(), 2.0f, 250, "ether");
//        oreBlasting(writer, ETHER_SMELTABLES, RecipeCategory.MISC, UnknownMagicItems.SOLIDIFIED_ETHER.get(), 2.0f, 150, "ether");

        DataIngredient whitestone = DataIngredient.ingredient(null, UnknownMagicItems.WHITESTONE);
        recipeProvider.singleItem(whitestone, RecipeCategory.MISC, );
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UnknownMagicBlocks.WHITESTONE_BLOCK.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', UnknownMagicItems.WHITESTONE.get())
                .unlockedBy("has_whitestone", has(UnknownMagicItems.WHITESTONE))
                .save(writer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UnknownMagicItems.WHITESTONE.get(), 9)
                .requires(UnknownMagicBlocks.WHITESTONE_BLOCK.get())
                .unlockedBy(getHasName(UnknownMagicBlocks.WHITESTONE_BLOCK.get()), has(UnknownMagicBlocks.WHITESTONE_BLOCK.get()))
                .save(writer);
    }

    public void oreSmelting(Consumer<FinishedRecipe> writer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        recipeProvider.smeltingAndBlasting();
        oreCooking(writer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    public void oreBlasting(Consumer<FinishedRecipe> writer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(writer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    public void oreCooking(Consumer<FinishedRecipe> writer, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        recipeProvider.
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(writer, UnknownMagic.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
