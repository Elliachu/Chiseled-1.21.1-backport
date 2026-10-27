package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.block.ModBlocks;
import net.elliachu.chiseled.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //standard recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE.get())
                .pattern("## ")
                .pattern("## ")
                .pattern("   ")
                .define('#', Items.STONE)
                .unlockedBy(getHasName(Items.STONE),has(Items.STONE)).save(recipeOutput);
        //stairs
        stairBuilder(ModBlocks.POLISHED_STONE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_STONE))
                .unlockedBy(getHasName(ModBlocks.POLISHED_STONE),has(ModBlocks.POLISHED_STONE)).save(recipeOutput);
        //slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB.get(), ModBlocks.POLISHED_STONE);
        //wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_WALL.get(), ModBlocks.POLISHED_STONE.get());
        //stonecutting
        stonecuttingRecipes(recipeOutput, ModBlocks.POLISHED_STONE.get(), Items.STONE);
        stonecuttingRecipes(recipeOutput, ModBlocks.POLISHED_STONE_STAIRS.get(), Items.STONE, ModBlocks.POLISHED_STONE.get());
        stonecuttingRecipes(2, recipeOutput, ModBlocks.POLISHED_STONE_SLAB.get(), Items.STONE, ModBlocks.POLISHED_STONE.get());
        stonecuttingRecipes(recipeOutput, ModBlocks.POLISHED_STONE_WALL.get(), Items.STONE, ModBlocks.POLISHED_STONE.get());

    }

    protected static void stonecuttingRecipes(RecipeOutput recipeOutput, ItemLike result, ItemLike... material) {
        stonecuttingRecipes(1, recipeOutput, result, material);
    }

    protected static void stonecuttingRecipes(int count, RecipeOutput recipeOutput, ItemLike result, ItemLike... material) {
        for(ItemLike input : material) stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, result, input, count);
    }
}
