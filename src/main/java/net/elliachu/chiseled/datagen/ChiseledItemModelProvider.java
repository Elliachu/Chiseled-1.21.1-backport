package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ChiseledItemModelProvider extends ItemModelProvider {
    public ChiseledItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Chiseled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //add new walls
        wallItem(ChiseledBlocks.POLISHED_STONE_WALL, ChiseledBlocks.POLISHED_STONE);
        wallItem(ChiseledBlocks.STONE_TILE_WALL, ChiseledBlocks.STONE_TILES);
        wallItem(ChiseledBlocks.MOSSY_STONE_TILE_WALL, ChiseledBlocks.MOSSY_STONE_TILES);

        //S I N G U L A R  S T O N E  W A L L (vanilla walls)
        wallItem(ChiseledBlocks.STONE_WALL, "block/stone");
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Chiseled.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    //S I N G U L A R  S T O N E  W A L L method
    public void wallItem(DeferredBlock<?> block, String texture) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.withDefaultNamespace(texture));
    }
}
