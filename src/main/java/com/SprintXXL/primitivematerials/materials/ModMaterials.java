package com.SprintXXL.primitivematerials.materials;

import com.SprintXXL.primitivematerials.materials.util.MaterialForms;

import static com.SprintXXL.primitivematerials.materials.util.MaterialForm.*;

public final class ModMaterials {

    private ModMaterials() {}

    public static final MaterialDefinition IRON =
            new MaterialDefinition(
                    MaterialIDs.IRON,
                    new MaterialForms(
                            INGOT,
                            DUST
                    )
            );

    public static final MaterialDefinition GOLD =
            new MaterialDefinition(
                    MaterialIDs.GOLD,
                    new MaterialForms(
                            INGOT,
                            DUST
                    )
            );

    public static final MaterialDefinition COPPER =
            new MaterialDefinition(
                    MaterialIDs.COPPER,
                    new MaterialForms(
                            INGOT,
                            DUST
                    )
            );

    public static final MaterialDefinition TIN =
            new MaterialDefinition(
                    MaterialIDs.TIN,
                    new MaterialForms(
                            INGOT,
                            DUST
                    )
            );

    public static final MaterialDefinition BRONZE =
            new MaterialDefinition(
                    MaterialIDs.BRONZE,
                    new MaterialForms(
                            INGOT,
                            DUST
                    )
            );
}
