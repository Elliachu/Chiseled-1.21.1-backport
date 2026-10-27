package net.elliachu.chiseled.item;

import net.elliachu.chiseled.Chiseled;
import net.elliachu.chiseled.block.ChiseledBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chiseled.MOD_ID);

    public static final Supplier<CreativeModeTab> CHISELED_ITEMS_TAB = CREATIVE_MODE_TAB.register("chiseled_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ChiseledBlocks.POLISHED_STONE.get()))
                    .title(Component.translatable("creativetab.chiseled.chiseled_blocks"))
                    .displayItems((parameters, output) -> {
                        //S I N G U L A R  S T O N E  W A L L
                        output.accept(ChiseledBlocks.STONE_WALL);

                        //polished stone
                        output.accept(ChiseledBlocks.POLISHED_STONE);
                        output.accept(ChiseledBlocks.POLISHED_STONE_STAIRS);
                        output.accept(ChiseledBlocks.POLISHED_STONE_SLAB);
                        output.accept(ChiseledBlocks.POLISHED_STONE_WALL);
                        output.accept(ChiseledBlocks.STONE_PILLAR);
                        output.accept(ChiseledBlocks.CUT_STONE_BRICKS);
                        output.accept(ChiseledBlocks.CRACKED_CUT_STONE_BRICKS);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}