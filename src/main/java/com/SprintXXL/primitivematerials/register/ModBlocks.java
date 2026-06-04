package com.SprintXXL.primitivematerials.register;

import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBlocks {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                MaterialRegistry.getBlocks().toArray(new Block[0])
        );
    }
}
