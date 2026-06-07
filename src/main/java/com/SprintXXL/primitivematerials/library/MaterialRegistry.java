package com.SprintXXL.primitivematerials.library;

import com.SprintXXL.primitivematerials.common.BlockBase;
import com.SprintXXL.primitivematerials.common.ItemBase;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;
import com.SprintXXL.primitivematerials.library.util.MaterialForms;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

public final class MaterialRegistry {

    private static boolean initialized = false;

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

    public static MaterialDefinition getMaterialFromStack(ItemStack stack, MaterialForm form) {

        if (stack.isEmpty()) {
            return null;
        }

        for (MaterialDefinition material : ALL_MATERIALS) {

            Item item = getItem(form, material);

            if (item == null) {
                continue;
            }

            if (stack.getItem() == item) {
                return material;
            }
        }

        return null;
    }

    public static void register(MaterialDefinition material) {
        MATERIALS.put(material.getID(), material);
        ALL_MATERIALS.add(material);
    }

    public static void initDefinitions() {

        if (initialized) {
            return;
        }

        initialized = true;

        register(ModMaterials.IRON);
        register(ModMaterials.GOLD);
        register(ModMaterials.COPPER);
        register(ModMaterials.TIN);

        register(ModMaterials.BRONZE);

        register(ModMaterials.REDSTONE);
        register(ModMaterials.CINNABAR);
        register(ModMaterials.DIAMOND);
        register(ModMaterials.COAL);
        register(ModMaterials.LIGNITE_COAL);

        register(ModMaterials.OBSIDIAN);
        register(ModMaterials.FLINT);
        register(ModMaterials.SAND);
        register(ModMaterials.BONE);
        register(ModMaterials.WOOD);
    }

    private static final Map<MaterialForm, Map<MaterialDefinition, Item>> ITEMS =
            new HashMap<>();

    public static Item getItem(MaterialForm form, MaterialDefinition material) {

        Map<MaterialDefinition, Item> itemMap = ITEMS.get(form);

        if (itemMap == null) {
            return null;
        }

        return itemMap.get(material);
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

        Map<MaterialDefinition, Block> blockMap = BLOCKS.get(form);

        if (blockMap == null) {
            return null;
        }

        return blockMap.get(material);
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

        BLOCKS.put(MaterialForm.BLOCK, new HashMap<>());

        ITEMS.put(MaterialForm.ITEM, new HashMap<>());
        ITEMS.put(MaterialForm.INGOT, new HashMap<>());
        ITEMS.put(MaterialForm.NUGGET, new HashMap<>());
        ITEMS.put(MaterialForm.DUST, new HashMap<>());
        ITEMS.put(MaterialForm.PLATE, new HashMap<>());
        ITEMS.put(MaterialForm.DENSE_PLATE, new HashMap<>());
        ITEMS.put(MaterialForm.ROD, new HashMap<>());
        ITEMS.put(MaterialForm.LONG_ROD, new HashMap<>());
        ITEMS.put(MaterialForm.BOLT, new HashMap<>());
        ITEMS.put(MaterialForm.SCREW, new HashMap<>());
        ITEMS.put(MaterialForm.RING, new HashMap<>());
        ITEMS.put(MaterialForm.FINE_WIRE, new HashMap<>());
        ITEMS.put(MaterialForm.GEAR, new HashMap<>());
        ITEMS.put(MaterialForm.SMALL_GEAR, new HashMap<>());

        for (MaterialDefinition material : ALL_MATERIALS) {

            MaterialForms forms = material.getForms();

            if (forms.hasForm(MaterialForm.BLOCK)) {

                Block block = new BlockBase(material.getBlockName());

                BLOCKS.get(MaterialForm.BLOCK)
                        .put(material, block);
            }

            if (forms.hasForm(MaterialForm.ITEM)) {

                Item item = new ItemBase(material.getItemName());

                ITEMS.get(MaterialForm.ITEM)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.INGOT)) {

                Item item = new ItemBase(material.getIngotName());

                ITEMS.get(MaterialForm.INGOT)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.NUGGET)) {

                Item item = new ItemBase(material.getNuggetName());

                ITEMS.get(MaterialForm.NUGGET)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.DUST)) {

                Item item = new ItemBase(material.getDustName());

                ITEMS.get(MaterialForm.DUST)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.PLATE)) {

                Item item = new ItemBase(material.getPlateName());

                ITEMS.get(MaterialForm.PLATE)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.DENSE_PLATE)) {

                Item item = new ItemBase(material.getDensePlateName());

                ITEMS.get(MaterialForm.DENSE_PLATE)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.ROD)) {

                Item item;

                if (material == ModMaterials.WOOD) {
                    item = Items.STICK;
                } else {
                    item = new ItemBase(material.getRodName());
                }

                ITEMS.get(MaterialForm.ROD)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.LONG_ROD)) {

                Item item = new ItemBase(material.getLongRodName());

                ITEMS.get(MaterialForm.LONG_ROD)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.BOLT)) {

                Item item = new ItemBase(material.getBoltName());

                ITEMS.get(MaterialForm.BOLT)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.SCREW)) {

                Item item = new ItemBase(material.getScrewName());

                ITEMS.get(MaterialForm.SCREW)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.GEAR)) {

                Item item = new ItemBase(material.getGearName());

                ITEMS.get(MaterialForm.GEAR)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.SMALL_GEAR)) {

                Item item = new ItemBase(material.getSmallGearName());

                ITEMS.get(MaterialForm.SMALL_GEAR)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.RING)) {

                Item item = new ItemBase(material.getRingName());

                ITEMS.get(MaterialForm.RING)
                        .put(material, item);
            }

            if (forms.hasForm(MaterialForm.FINE_WIRE)) {

                Item item = new ItemBase(material.getFineWireName());

                ITEMS.get(MaterialForm.FINE_WIRE)
                        .put(material, item);
            }
        }
    }
}
