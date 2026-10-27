package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ChiseledBlockStateProvider extends BlockStateProvider {
    public ChiseledBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chiseled.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //bricks
        blockWithItem(ChiseledBlocks.POLISHED_STONE);
        //stairs
        stairsBlock(ChiseledBlocks.POLISHED_STONE_STAIRS, ChiseledBlocks.POLISHED_STONE);
        //slabs
        slabBlock(ChiseledBlocks.POLISHED_STONE_SLAB, ChiseledBlocks.POLISHED_STONE);
        //walls
        wallBlock(ChiseledBlocks.POLISHED_STONE_WALL.get(),blockTexture(ChiseledBlocks.POLISHED_STONE.get()));
        //pillars
        rotatedPillarBlock(ChiseledBlocks.STONE_PILLAR);
        //cut bricks
        blockWithItem(ChiseledBlocks.CUT_STONE_BRICKS);
        //cracked bricks
        blockWithItem(ChiseledBlocks.CRACKED_CUT_STONE_BRICKS);

        //S I N G U L A R  S T O N E  W A L L
        wallBlock(ChiseledBlocks.STONE_WALL.get(),blockTexture(Blocks.STONE));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("chiseled:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("chiseled:block/" + deferredBlock.getId().getPath()));
    }

    private void rotatedPillarBlock(DeferredBlock<RotatedPillarBlock> block) {
        logBlock(block.get());
        blockItem(block);
    }

    private void stairsBlock(DeferredBlock<StairBlock> block, DeferredBlock<Block> fullBlock) {
        stairsBlock(block.get(), blockTexture(fullBlock.get()));
        blockItem(block);
    }

    private void slabBlock(DeferredBlock<SlabBlock> block, DeferredBlock<Block> fullBlock) {
        slabBlock(block.get(), blockTexture(fullBlock.get()), blockTexture(fullBlock.get()));
        blockItem(block);
    }
}
