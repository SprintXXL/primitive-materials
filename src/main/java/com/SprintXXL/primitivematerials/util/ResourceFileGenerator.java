package com.SprintXXL.primitivematerials.util;

import com.SprintXXL.primitivematerials.library.MaterialDefinition;
import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceFileGenerator {

    public static void main(String[] args) {

        MaterialRegistry.initDefinitions();

        for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {

            if (material.getForms().hasForm(MaterialForm.BLOCK)) {
                generateBlockModel(material);

                generateBlockState(material);

                generateItemBlock(material);
            }

            for (MaterialForm form : material.getForms().getForms()) {

                if (form == MaterialForm.BLOCK) {
                    continue;
                }

                generateItemModel(material, form);
            }
        }

        generateLang();
    }

    private static void generateBlockModel(MaterialDefinition material) {

        Path path = Paths.get(
                "src/main/resources/assets/primitivematerials/models/block",
                material.getBlockName() + ".json"
        );

        String json =
                "{\n" +
                        "  \"parent\": \"block/cube_all\",\n" +
                        "  \"textures\": {\n" +
                        "    \"all\": \"primitivematerials:generated/" + material.getBlockName() + "\"\n" +
                        "  }\n" +
                        "}";

        writeFile(path, json);
    }

    private static void generateBlockState(MaterialDefinition material) {
        Path path = Paths.get(
                "src/main/resources/assets/primitivematerials/blockstates",
                material.getBlockName() + ".json"
        );

        String json =
                "{\n" +
                        "  \"variants\": {\n" +
                        "    \"normal\": {\n" +
                        "      \"model\": \"primitivematerials:" + material.getBlockName() + "\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n";

        writeFile(path, json);
    }

    private static void generateItemBlock(MaterialDefinition material) {
        Path path = Paths.get(
                "src/main/resources/assets/primitivematerials/models/item",
                material.getBlockName() + ".json"
        );

        String json =
                "{\n" +
                        "  \"parent\": \"primitivematerials:block/" + material.getBlockName() + "\"\n" +
                        "}\n";

        writeFile(path, json);
    }

    private static void generateItemModel(MaterialDefinition material, MaterialForm form) {

        String itemName = getItemName(material, form);
        String texturePath = getTexturePath(form);

        Path path = Paths.get(
                "src/main/resources/assets/primitivematerials/models/item",
                itemName + ".json"
        );

        String json =
                "{\n" +
                        "  \"parent\": \"item/generated\",\n" +
                        "  \"textures\": {\n" +
                        "    \"layer0\": \"" + texturePath + itemName + "\"\n" +
                        "  }\n" +
                        "}\n";

        writeFile(path, json);
    }

    private static void generateLang() {

        Path path = Paths.get(
                "src/main/resources/assets/primitivematerials/lang",
                "en_us.lang"
        );

        StringBuilder lang = new StringBuilder();

        lang.append("// Material Blocks \\\\\n");

        for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {
            lang.append("tile.primitivematerials.")
                    .append(material.getBlockName())
                    .append(".name=")
                    .append(toDisplayName(material.getBlockName()))
                    .append("\n");
        }

        lang.append("\n// Material Items \\\\\n");

        for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {
            for (MaterialForm form : material.getForms().getForms()) {

                if (form == MaterialForm.BLOCK) {
                    continue;
                }

                String itemName = getItemName(material, form);

                lang.append("item.primitivematerials.")
                        .append(itemName)
                        .append(".name=")
                        .append(toDisplayName(itemName))
                        .append("\n");
            }
        }

        writeFile(path, lang.toString());
    }

    private static String getItemName(MaterialDefinition material, MaterialForm form) {

        switch (form) {
            case ITEM:
                return material.getItemName();
            case INGOT:
                return material.getIngotName();
            case NUGGET:
                return material.getNuggetName();
            case DUST:
                return material.getDustName();
            case PLATE:
                return material.getPlateName();
            case DENSE_PLATE:
                return material.getDensePlateName();
            case ROD:
                return material.getRodName();
            case LONG_ROD:
                return material.getLongRodName();
            case BOLT:
                return material.getBoltName();
            case SCREW:
                return material.getScrewName();
            case RING:
                return material.getRingName();
            case FINE_WIRE:
                return material.getFineWireName();
            case GEAR:
                return material.getGearName();
            case SMALL_GEAR:
                return material.getSmallGearName();
            default:
                throw new IllegalArgumentException("Unknown material form: " + form);
        }
    }

    private static String toDisplayName(String registryName) {

        String[] parts = registryName.split("_");

        StringBuilder name = new StringBuilder();

        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }

            name.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }

        return name.toString().trim();
    }

    private static void writeFile(Path path, String contents) {

        try {
            Files.createDirectories(path.getParent());

            Files.write(
                    path,
                    contents.getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("Generated: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTexturePath(MaterialForm form) {

        if (form == MaterialForm.ITEM) {
            return "primitivematerials:items/";
        }

        return "primitivematerials:generated/";
    }
}
