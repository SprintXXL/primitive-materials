package com.SprintXXL.primitivematerials;

import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class PrimitiveMaterials
{

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        MaterialRegistry.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
