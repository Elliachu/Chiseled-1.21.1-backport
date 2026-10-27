package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Chiseled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.POLISHED_STONE.get())
                .add(ModBlocks.POLISHED_STONE_STAIRS.get())
                .add(ModBlocks.POLISHED_STONE_SLAB.get());


        tag(BlockTags.WALLS).add(ModBlocks.POLISHED_STONE_WALL.get());
    }
}
