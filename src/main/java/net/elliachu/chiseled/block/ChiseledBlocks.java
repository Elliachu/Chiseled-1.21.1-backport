package net.elliachu.chiseled.block;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ChiseledBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Chiseled.MOD_ID);
    //bricks
    public static final DeferredBlock<Block> POLISHED_STONE = registerBlock("polished_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> STONE_TILES = registerBlock("stone_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    //cut bricks
    public static final DeferredBlock<Block> CUT_STONE_BRICKS = registerBlock("cut_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    //stairs
    public static final DeferredBlock<StairBlock> POLISHED_STONE_STAIRS = registerBlock("polished_stone_stairs",
            () -> new StairBlock(ChiseledBlocks.POLISHED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
    public static final DeferredBlock<StairBlock> CUT_STONE_BRICK_STAIRS = registerBlock("cut_stone_brick_stairs",
            () -> new StairBlock(ChiseledBlocks.CUT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
    public static final DeferredBlock<StairBlock> STONE_TILE_STAIRS = registerBlock("stone_tile_stairs",
            () -> new StairBlock(ChiseledBlocks.STONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
    //slabs
    public static final DeferredBlock<SlabBlock> POLISHED_STONE_SLAB = registerBlock("polished_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
    public static final DeferredBlock<SlabBlock> CUT_STONE_BRICK_SLAB = registerBlock("cut_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
    public static final DeferredBlock<SlabBlock> STONE_TILE_SLAB = registerBlock("stone_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
    //walls
    public static final DeferredBlock<WallBlock> POLISHED_STONE_WALL = registerBlock("polished_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
    public static final DeferredBlock<WallBlock> STONE_TILE_WALL = registerBlock("stone_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
    //cracked bricks
    public static final DeferredBlock<Block> CRACKED_CUT_STONE_BRICKS = registerBlock("cracked_cut_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> CRACKED_STONE_TILES = registerBlock("cracked_stone_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    //mossy blocks
    public static final DeferredBlock<Block> MOSSY_CUT_STONE_BRICKS = registerBlock("mossy_cut_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<StairBlock> MOSSY_CUT_STONE_BRICK_STAIRS = registerBlock("mossy_cut_stone_brick_stairs",
            () -> new StairBlock(ChiseledBlocks.MOSSY_CUT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS)));
    public static final DeferredBlock<SlabBlock> MOSSY_CUT_STONE_BRICK_SLAB = registerBlock("mossy_cut_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB)));
    public static final DeferredBlock<Block> MOSSY_STONE_TILES = registerBlock("mossy_stone_tiles",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS)));
    public static final DeferredBlock<StairBlock> MOSSY_STONE_TILE_STAIRS = registerBlock("mossy_stone_tile_stairs",
            () -> new StairBlock(ChiseledBlocks.MOSSY_STONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_STAIRS)));
    public static final DeferredBlock<SlabBlock> MOSSY_STONE_TILE_SLAB = registerBlock("mossy_stone_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_SLAB)));
    public static final DeferredBlock<WallBlock> MOSSY_STONE_TILE_WALL = registerBlock("mossy_stone_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICK_WALL)));


    //S I N G U L A R  S T O N E  W A L L
    public static final DeferredBlock<WallBlock> STONE_WALL = registerBlock("stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
