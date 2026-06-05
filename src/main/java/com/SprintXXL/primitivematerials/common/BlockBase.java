package com.SprintXXL.primitivematerials.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import static com.SprintXXL.primitivematerials.Reference.MODID;

public class BlockBase extends Block {

    public BlockBase(String name) {
        super(Material.ROCK);

        setRegistryName(MODID, name);
        setTranslationKey(MODID + "." + name);
        setCreativeTab(CreativeTabs.MATERIALS);

        setHardness(3.0F);
        setResistance(5.0F);
    }
}
