package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ChiseledRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ChiseledRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //standard recipe
        brickRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE, Items.STONE, Items.STONE);
        stonecuttingRecipes(recipeOutput, Items.STONE_BRICKS, ChiseledBlocks.POLISHED_STONE);
        //stairs
        stairRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE_STAIRS, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        stonecuttingRecipes(recipeOutput, Items.STONE_BRICK_STAIRS, ChiseledBlocks.POLISHED_STONE);
        //slab
        slabRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE_SLAB, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        stonecuttingRecipes(2, recipeOutput, Items.STONE_BRICK_SLAB, ChiseledBlocks.POLISHED_STONE);
        //wall
        wallRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE_WALL, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        stonecuttingRecipes(recipeOutput, Items.STONE_BRICK_WALL, ChiseledBlocks.POLISHED_STONE);
        //pillar
        pillarRecipes(recipeOutput, ChiseledBlocks.STONE_PILLAR, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        //cut bricks
        cutBricksRecipes(recipeOutput, ChiseledBlocks.CUT_STONE_BRICKS, ChiseledBlocks.POLISHED_STONE_SLAB, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        //cracked bricks
        crackingRecipe(recipeOutput, ChiseledBlocks.CUT_STONE_BRICKS, ChiseledBlocks.CRACKED_CUT_STONE_BRICKS);


        //S I N G U L A R  S T O N E  W A L L
        wallRecipes(recipeOutput, ChiseledBlocks.STONE_WALL, Blocks.STONE, Items.STONE);
    }

    protected static void stonecuttingRecipes(RecipeOutput recipeOutput, ItemLike result, ItemLike... material) {
        stonecuttingRecipes(1, recipeOutput, result, material);
    }

    protected static void stonecuttingRecipes(int count, RecipeOutput recipeOutput, ItemLike result, ItemLike... material) {
        for(ItemLike input : material) stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, result, input, count);
    }

    protected static void stairRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput, ItemLike... stonecutterInputs) {
        stairBuilder(craftingOutput, Ingredient.of(craftingInput))
                .unlockedBy(getHasName(craftingInput),has(craftingInput)).save(recipeOutput);
        stonecuttingRecipes(recipeOutput, craftingOutput, stonecutterInputs);
    }

    protected static void slabRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput, ItemLike... stonecutterInputs) {
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, craftingOutput, craftingInput);
        stonecuttingRecipes(2, recipeOutput, craftingOutput, stonecutterInputs);
    }

    protected static void wallRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput, ItemLike... stonecutterInputs) {
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, craftingOutput, craftingInput);
        stonecuttingRecipes(recipeOutput, craftingOutput, stonecutterInputs);
    }

    protected static void brickRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput, ItemLike... stonecutterInputs) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, craftingOutput)
                .pattern("## ")
                .pattern("## ")
                .pattern("   ")
                .define('#', craftingInput)
                .unlockedBy(getHasName(craftingInput),has(craftingInput)).save(recipeOutput);
        stonecuttingRecipes(recipeOutput, craftingOutput, stonecutterInputs);
    }

    protected static void pillarRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput, ItemLike... stonecutterInputs) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, craftingOutput, 2)
                .pattern("#  ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', craftingInput)
                .unlockedBy(getHasName(craftingInput),has(craftingInput)).save(recipeOutput);
        stonecuttingRecipes(recipeOutput, craftingOutput, stonecutterInputs);
    }

    protected static void cutBricksRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput, ItemLike... stonecutterInputs) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, craftingOutput)
                .pattern("#  ")
                .pattern("#  ")
                .pattern("   ")
                .define('#', craftingInput)
                .unlockedBy(getHasName(craftingInput),has(craftingInput)).save(recipeOutput);
        stonecuttingRecipes(recipeOutput, craftingOutput, stonecutterInputs);
    }

    protected static void crackingRecipe(RecipeOutput recipeOutput, ItemLike input, ItemLike output) {
        oreSmelting(recipeOutput, List.of(input), RecipeCategory.BUILDING_BLOCKS, output, 0.1f, 200,getItemName(output));
    }
}
