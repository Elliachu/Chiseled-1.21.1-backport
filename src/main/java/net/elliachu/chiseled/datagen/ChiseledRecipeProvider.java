package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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

        //bricks
        brickRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE, Items.STONE, Items.STONE);
        stonecuttingRecipes(recipeOutput, Items.STONE_BRICKS, ChiseledBlocks.POLISHED_STONE);
        brickRecipes(recipeOutput, ChiseledBlocks.STONE_TILES, Items.STONE_BRICKS, Items.STONE, ChiseledBlocks.POLISHED_STONE, Items.STONE_BRICKS);
        //cut bricks
        cutBricksRecipes(recipeOutput, ChiseledBlocks.CUT_STONE_BRICKS, ChiseledBlocks.POLISHED_STONE_SLAB, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        //stairs
        stairRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE_STAIRS, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        stonecuttingRecipes(recipeOutput, Items.STONE_BRICK_STAIRS, ChiseledBlocks.POLISHED_STONE);
        stairRecipes(recipeOutput, ChiseledBlocks.CUT_STONE_BRICK_STAIRS, ChiseledBlocks.CUT_STONE_BRICKS, Items.STONE, ChiseledBlocks.POLISHED_STONE, ChiseledBlocks.CUT_STONE_BRICKS);
        stairRecipes(recipeOutput, ChiseledBlocks.STONE_TILE_STAIRS, ChiseledBlocks.STONE_TILES, Items.STONE, ChiseledBlocks.POLISHED_STONE, Items.STONE_BRICKS, ChiseledBlocks.STONE_TILES);
        //slab
        slabRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE_SLAB, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        stonecuttingRecipes(2, recipeOutput, Items.STONE_BRICK_SLAB, ChiseledBlocks.POLISHED_STONE);
        slabRecipes(recipeOutput, ChiseledBlocks.CUT_STONE_BRICK_SLAB, ChiseledBlocks.CUT_STONE_BRICKS, Items.STONE, ChiseledBlocks.POLISHED_STONE, ChiseledBlocks.CUT_STONE_BRICKS);
        slabRecipes(recipeOutput, ChiseledBlocks.STONE_TILE_SLAB, ChiseledBlocks.STONE_TILES, Items.STONE, ChiseledBlocks.POLISHED_STONE, Items.STONE_BRICKS, ChiseledBlocks.STONE_TILES);
        //wall
        wallRecipes(recipeOutput, ChiseledBlocks.POLISHED_STONE_WALL, ChiseledBlocks.POLISHED_STONE, Items.STONE, ChiseledBlocks.POLISHED_STONE);
        stonecuttingRecipes(recipeOutput, Items.STONE_BRICK_WALL, ChiseledBlocks.POLISHED_STONE);
        wallRecipes(recipeOutput, ChiseledBlocks.STONE_TILE_WALL, ChiseledBlocks.STONE_TILES, Items.STONE, ChiseledBlocks.POLISHED_STONE, Items.STONE_BRICKS, ChiseledBlocks.STONE_TILES);
        //cracked bricks
        crackingRecipe(recipeOutput, ChiseledBlocks.CUT_STONE_BRICKS, ChiseledBlocks.CRACKED_CUT_STONE_BRICKS);
        crackingRecipe(recipeOutput, ChiseledBlocks.STONE_TILES, ChiseledBlocks.CRACKED_STONE_TILES);
        //mossy blocks
        mossyRecipes(recipeOutput, ChiseledBlocks.MOSSY_CUT_STONE_BRICKS, ChiseledBlocks.CUT_STONE_BRICKS);
        stairRecipes(recipeOutput, ChiseledBlocks.MOSSY_CUT_STONE_BRICK_STAIRS, ChiseledBlocks.MOSSY_CUT_STONE_BRICKS, ChiseledBlocks.MOSSY_CUT_STONE_BRICKS);
        slabRecipes(recipeOutput, ChiseledBlocks.MOSSY_CUT_STONE_BRICK_SLAB, ChiseledBlocks.MOSSY_CUT_STONE_BRICKS, ChiseledBlocks.MOSSY_CUT_STONE_BRICKS);
        mossyRecipes(recipeOutput, ChiseledBlocks.MOSSY_STONE_TILES, ChiseledBlocks.STONE_TILES);
        stairRecipes(recipeOutput, ChiseledBlocks.MOSSY_STONE_TILE_STAIRS, ChiseledBlocks.MOSSY_STONE_TILES, ChiseledBlocks.MOSSY_STONE_TILES);
        slabRecipes(recipeOutput, ChiseledBlocks.MOSSY_STONE_TILE_SLAB, ChiseledBlocks.MOSSY_STONE_TILES, ChiseledBlocks.MOSSY_STONE_TILES);
        wallRecipes(recipeOutput, ChiseledBlocks.MOSSY_STONE_TILE_WALL, ChiseledBlocks.MOSSY_STONE_TILES, ChiseledBlocks.MOSSY_STONE_TILES);



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

    protected static void mossyRecipes(RecipeOutput recipeOutput, ItemLike craftingOutput, ItemLike craftingInput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, craftingOutput)
                .requires(craftingInput)
                .requires(Items.MOSS_BLOCK)
                .unlockedBy(getHasName(craftingInput), has(craftingInput))
                .save(recipeOutput, getItemName(craftingOutput)+"_from_moss");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, craftingOutput)
                .requires(craftingInput)
                .requires(Items.VINE)
                .unlockedBy(getHasName(craftingInput), has(craftingInput))
                .save(recipeOutput, getItemName(craftingOutput)+"_from_vine");
    }
}
