package com.SprintXXL.primitivematerials;

import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.SprintXXL.primitivematerials.Reference.*;

@Mod(
        modid = MODID,
        name = NAME,
        version = VERSION)
public class PrimitiveMaterials
{

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MaterialRegistry.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
