package com.SprintXXL.primitivematerials.library.util;

import com.SprintXXL.primitivematerials.library.MaterialDefinition;
import com.SprintXXL.primitivematerials.library.ModMaterials;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class VanillaMaterialForms {

    private VanillaMaterialForms() {}

    public static Block getVanillaBlock(MaterialDefinition material) {

        if (material == ModMaterials.STONE) {
            return Blocks.STONE;
        }

        if (material == ModMaterials.OBSIDIAN) {
            return Blocks.OBSIDIAN;
        }

        if (material == ModMaterials.SAND) {
            return Blocks.SAND;
        }

        return null;
    }

    public static Item getVanillaItem(MaterialDefinition material, MaterialForm form) {

        if (form == MaterialForm.ROD && material == ModMaterials.WOOD) {
            return Items.STICK;
        }

        return null;
    }
}
