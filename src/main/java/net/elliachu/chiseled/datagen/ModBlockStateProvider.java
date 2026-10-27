package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chiseled.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //simple block
        blockWithItem(ModBlocks.POLISHED_STONE);

        //stairs and slabs
        stairsBlock(ModBlocks.POLISHED_STONE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_STONE.get()));
        slabBlock(ModBlocks.POLISHED_STONE_SLAB.get(), blockTexture(ModBlocks.POLISHED_STONE.get()), blockTexture(ModBlocks.POLISHED_STONE.get()));

        //walls innit
        wallBlock(ModBlocks.POLISHED_STONE_WALL.get(),blockTexture(ModBlocks.POLISHED_STONE.get()));

        //other thing for stairs and slabs
        blockItem(ModBlocks.POLISHED_STONE_STAIRS);
        blockItem(ModBlocks.POLISHED_STONE_SLAB);
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
}
