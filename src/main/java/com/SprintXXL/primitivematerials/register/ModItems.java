package com.SprintXXL.primitivematerials.register;

import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                MaterialRegistry.getItems().toArray(new Item[0])
        );
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        for (Block block : MaterialRegistry.getBlocks()) {
            event.getRegistry().register(createItemBlock(block));
        }
    }

    private static ItemBlock createItemBlock(Block block) {
        return (ItemBlock) new ItemBlock(block)
                .setRegistryName(block.getRegistryName());
    }
}
