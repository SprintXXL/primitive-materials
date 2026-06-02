package com.SprintXXL.primitivematerials.materials;

import com.SprintXXL.primitivematerials.common.BlockBase;
import com.SprintXXL.primitivematerials.common.ItemBase;
import com.SprintXXL.primitivematerials.materials.util.MaterialForm;
import com.SprintXXL.primitivematerials.materials.util.MaterialForms;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.*;

public final class MaterialRegistry {

    private MaterialRegistry() {}

    private static final Map<String, MaterialDefinition> MATERIALS =
            new HashMap<>();

    private static final List<MaterialDefinition> ALL_MATERIALS =
            new ArrayList<>();

    public static List<MaterialDefinition> getAllMaterials() {
        return Collections.unmodifiableList(ALL_MATERIALS);
    }

    public static MaterialDefinition getMaterial(String id) {
        return MATERIALS.get(id);
    }

    public static void register(MaterialDefinition material) {
        MATERIALS.put(material.getID(), material);
        ALL_MATERIALS.add(material);
    }

    public static void initDefinitions() {

        register(ModMaterials.IRON);
        register(ModMaterials.GOLD);
        register(ModMaterials.COPPER);
        register(ModMaterials.TIN);
        register(ModMaterials.BRONZE);
    }

    private static final Map<MaterialForm, Map<MaterialDefinition, Item>> ITEMS =
            new HashMap<>();

    public static Item getItem(MaterialForm form, MaterialDefinition material) {
        return ITEMS.get(form).get(material);
    }

    public static Collection<Item> getItems() {

        Collection<Item> allItems = new ArrayList<>();

        for (Map<MaterialDefinition, Item> itemMap : ITEMS.values()) {
            allItems.addAll(itemMap.values());
        }

        return allItems;
    }

    private static final Map<MaterialForm, Map<MaterialDefinition, Block>> BLOCKS =
            new HashMap<>();

    public static Block getBlock(MaterialForm form, MaterialDefinition material) {
        return BLOCKS.get(form).get(material);
    }

    public static Collection<Block> getBlocks() {

        Collection<Block> allBlocks = new ArrayList<>();

        for (Map<MaterialDefinition, Block> blockMap : BLOCKS.values()) {
            allBlocks.addAll(blockMap.values());
        }

        return allBlocks;
    }

    public static void init() {

        initDefinitions();
        createContent();
    }

    private static void createContent() {

        ITEMS.put(MaterialForm.ITEM, new HashMap<>());
        ITEMS.put(MaterialForm.INGOT, new HashMap<>());
        ITEMS.put(MaterialForm.DUST, new HashMap<>());

        for (MaterialDefinition material : ALL_MATERIALS) {

            MaterialForms forms = material.getForms();

            if (forms.hasForm(MaterialForm.ITEM)) {

                Item item = new ItemBase(material.getID());

                ITEMS.get(MaterialForm.ITEM)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.INGOT)) {

                Item item = new ItemBase(material.getID() + "_ingot");

                ITEMS.get(MaterialForm.INGOT)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.DUST)) {

                Item item = new ItemBase(material.getID() + "_dust");

                ITEMS.get(MaterialForm.DUST)
                        .put(material, item);
            }
        }
    }
}
