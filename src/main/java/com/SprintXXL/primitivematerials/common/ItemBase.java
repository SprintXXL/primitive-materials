package com.SprintXXL.primitivematerials.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.SprintXXL.primitivematerials.Reference.MODID;

public class ItemBase extends Item {

    public ItemBase(String name) {

        setRegistryName(MODID, name);
        setUnlocalizedName(MODID + "." + name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
