package com.SprintXXL.primitivematerials.library;

import com.SprintXXL.primitivematerials.common.BlockBase;
import com.SprintXXL.primitivematerials.common.ItemBase;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;
import com.SprintXXL.primitivematerials.library.util.MaterialForms;
import com.SprintXXL.primitivematerials.library.util.VanillaMaterialForms;
import net.minecraft.block.Block;
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
        register(ModMaterials.STONE);
    }

    private static final Map<MaterialForm, Map<MaterialDefinition, Item>> ITEMS =
            new HashMap<>();

    private static final Map<MaterialForm, Map<MaterialDefinition, Item>> CUSTOM_ITEMS =
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

    public static Collection<Item> getCustomItems() {

        Collection<Item> allCustomItems = new ArrayList<>();

        for (Map<MaterialDefinition, Item> itemMap : CUSTOM_ITEMS.values()) {
            allCustomItems.addAll(itemMap.values());
        }

        return allCustomItems;
    }

    private static final Map<MaterialForm, Map<MaterialDefinition, Block>> BLOCKS =
            new HashMap<>();

    private static final Map<MaterialForm, Map<MaterialDefinition, Block>> CUSTOM_BLOCKS =
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

    public static Collection<Block> getCustomBlocks() {

        Collection<Block> allCustomBlocks = new ArrayList<>();

        for (Map<MaterialDefinition, Block> blockMap : CUSTOM_BLOCKS.values()) {
            allCustomBlocks.addAll(blockMap.values());
        }

        return allCustomBlocks;
    }

    public static void init() {

        initDefinitions();
        createContent();
    }

    private static void createContent() {

        initializeMap(ITEMS);
        initializeMap(CUSTOM_ITEMS);

        initializeMap(BLOCKS);
        initializeMap(CUSTOM_BLOCKS);

        for (MaterialDefinition material : ALL_MATERIALS) {

            MaterialForms forms = material.getForms();

            if (forms.hasForm(MaterialForm.BLOCK)) {
                createBlock(material);
            }

            for (MaterialForm form : MaterialForm.values()) {

                if (form == MaterialForm.BLOCK) {
                    continue;
                }

                if (!forms.hasForm(form)) {
                    continue;
                }

                createItem(material, form);
            }
        }
    }

    public static void createItem(MaterialDefinition material, MaterialForm form) {

        Item item = VanillaMaterialForms.getVanillaItem(material, form);

        if (item == null) {
            item = new ItemBase(form.getName(material));

            CUSTOM_ITEMS.get(form)
                    .put(material, item);
        }

        ITEMS.get(form)
                .put(material, item);
    }

    public static void createBlock(MaterialDefinition material) {

        Block block = VanillaMaterialForms.getVanillaBlock(material);

        if (block == null) {
            block = new BlockBase(material.getBlockName());

            CUSTOM_BLOCKS.get(MaterialForm.BLOCK)
                    .put(material, block);
        }

        BLOCKS.get(MaterialForm.BLOCK)
                .put(material, block);
    }

    private static <T> void initializeMap(Map<MaterialForm, Map<MaterialDefinition, T>> map) {

        for (MaterialForm form : MaterialForm.values()) {
            map.put(form, new HashMap<>());
        }
    }
}