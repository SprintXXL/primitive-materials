package com.SprintXXL.primitivematerials.util;

import com.SprintXXL.primitivematerials.materials.MaterialDefinition;
import com.SprintXXL.primitivematerials.materials.MaterialRegistry;
import com.SprintXXL.primitivematerials.materials.util.MaterialForm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MaterialJsonGenerator {

    public static void main(String[] args) {

        MaterialRegistry.initDefinitions();

        for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {
            for (MaterialForm form : material.getForms().getForms()) {

                generateItemModel(material, form);
            }
        }
    }

    private static void generateItemModel(MaterialDefinition material, MaterialForm form) {

        String itemName = getItemName(material, form);
        String textureFolder = getTextureFolder(form);

        Path path = Paths.get(
                "src/main/resources/assets/primitivematerials/models/item",
                itemName + ".json"
        );

        String json =
                "{\n" +
                        "  \"parent\": \"item/generated\",\n" +
                        "  \"textures\": {\n" +
                        "    \"layer0\": \"primitivematerials:" + textureFolder + "/" + itemName + "\"\n" +
                        "  }\n" +
                        "}\n";

        try {
            Files.createDirectories(path.getParent());

            Files.write(
                    path,
                    json.getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("Generated: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getItemName(MaterialDefinition material, MaterialForm form) {

        if (form == MaterialForm.ITEM) {
            return material.getID();
        }

        return material.getID() + "_" + form.name().toLowerCase();
    }

    private static String getTextureFolder(MaterialForm form) {

        switch (form) {
            case ITEM:
                return "items";
            case INGOT:
                return "ingots";
            case DUST:
                return "dusts";
            default:
                throw new IllegalArgumentException("Unknown material form: " + form);
        }
    }
}
