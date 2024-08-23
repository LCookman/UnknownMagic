package com.crimsonbrood.unknownmagic.datagen;

import com.crimsonbrood.unknownmagic.blocks.EtherBlocks;
import com.crimsonbrood.unknownmagic.items.EtherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class EtherRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public EtherRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EtherBlocks.WHITESTONE_BLOCK.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', EtherItems.WHITESTONE.get())
                .unlockedBy("has_whitestone", has(EtherItems.WHITESTONE))
                .save(writer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EtherItems.WHITESTONE.get(), 9)
                .requires(EtherBlocks.WHITESTONE_BLOCK.get())
                .unlockedBy(getHasName(EtherBlocks.WHITESTONE_BLOCK.get()), has(EtherBlocks.WHITESTONE_BLOCK.get()))
                .save(writer);
    }
}
