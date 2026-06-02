package com.SprintXXL.primitivematerials.register;

import com.SprintXXL.primitivematerials.materials.MaterialRegistry;
import net.minecraft.item.Item;
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
}
