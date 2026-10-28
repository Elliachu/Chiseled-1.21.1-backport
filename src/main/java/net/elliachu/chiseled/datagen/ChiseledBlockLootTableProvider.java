package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ChiseledBlockLootTableProvider extends BlockLootSubProvider {
    protected ChiseledBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //bricks
        dropSelf(ChiseledBlocks.POLISHED_STONE.get());
        //cut bricks
        dropSelf(ChiseledBlocks.CUT_STONE_BRICKS.get());
        //stairs
        dropSelf(ChiseledBlocks.POLISHED_STONE_STAIRS.get());
        dropSelf(ChiseledBlocks.CUT_STONE_BRICK_STAIRS.get());
        //slabs
        add(ChiseledBlocks.POLISHED_STONE_SLAB.get(),
                block -> createSlabItemTable(ChiseledBlocks.POLISHED_STONE_SLAB.get()));
        add(ChiseledBlocks.CUT_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ChiseledBlocks.CUT_STONE_BRICK_SLAB.get()));
        //walls
        dropSelf(ChiseledBlocks.POLISHED_STONE_WALL.get());
        //pillars
        dropSelf(ChiseledBlocks.STONE_PILLAR.get());
        //cracked bricks
        dropSelf(ChiseledBlocks.CRACKED_CUT_STONE_BRICKS.get());
        //mossy blocks
        dropSelf(ChiseledBlocks.MOSSY_CUT_STONE_BRICKS.get());
        dropSelf(ChiseledBlocks.MOSSY_CUT_STONE_BRICK_STAIRS.get());
        add(ChiseledBlocks.MOSSY_CUT_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ChiseledBlocks.MOSSY_CUT_STONE_BRICK_SLAB.get()));

        //S I N G U L A R  S T O N E  W A L L
        dropSelf(ChiseledBlocks.STONE_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ChiseledBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
