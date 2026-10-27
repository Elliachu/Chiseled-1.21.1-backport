package net.elliachu.chiseled.datagen;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ModBlocks;
import net.elliachu.chiseled.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Chiseled.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        wallItem(ModBlocks.POLISHED_STONE_WALL, ModBlocks.POLISHED_STONE);

    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Chiseled.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
