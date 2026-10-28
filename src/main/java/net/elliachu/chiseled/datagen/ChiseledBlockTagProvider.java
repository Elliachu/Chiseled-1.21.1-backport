package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ChiseledBlockTagProvider extends BlockTagsProvider {
    public ChiseledBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Chiseled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //bricks
                .add(ChiseledBlocks.POLISHED_STONE.get())
                .add(ChiseledBlocks.STONE_TILES.get())
                //cut bricks
                .add(ChiseledBlocks.CUT_STONE_BRICKS.get())
                //stairs
                .add(ChiseledBlocks.POLISHED_STONE_STAIRS.get())
                .add(ChiseledBlocks.CUT_STONE_BRICK_STAIRS.get())
                .add(ChiseledBlocks.STONE_TILE_STAIRS.get())
                //slab
                .add(ChiseledBlocks.POLISHED_STONE_SLAB.get())
                .add(ChiseledBlocks.CUT_STONE_BRICK_SLAB.get())
                .add(ChiseledBlocks.STONE_TILE_SLAB.get())
                //pillar
                .add(ChiseledBlocks.STONE_PILLAR.get())
                //cracked bricks
                .add(ChiseledBlocks.CRACKED_CUT_STONE_BRICKS.get())
                .add(ChiseledBlocks.CRACKED_STONE_TILES.get())
                //mossy blocks
                .add(ChiseledBlocks.MOSSY_CUT_STONE_BRICKS.get())
                .add(ChiseledBlocks.MOSSY_CUT_STONE_BRICK_STAIRS.get())
                .add(ChiseledBlocks.MOSSY_CUT_STONE_BRICK_SLAB.get())
                .add(ChiseledBlocks.MOSSY_STONE_TILES.get())
                .add(ChiseledBlocks.MOSSY_STONE_TILE_STAIRS.get())
                .add(ChiseledBlocks.MOSSY_STONE_TILE_SLAB.get());




        tag(BlockTags.WALLS)
                .add(ChiseledBlocks.POLISHED_STONE_WALL.get())

                //S I N G U L A R  S T O N E  W A L L
                .add(ChiseledBlocks.STONE_WALL.get());
    }
}
