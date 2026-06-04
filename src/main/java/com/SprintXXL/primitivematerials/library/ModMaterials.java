package com.SprintXXL.primitivematerials.library;

import com.SprintXXL.primitivematerials.library.util.MaterialForms;
import com.SprintXXL.primitivematerials.library.util.MaterialType;

import static com.SprintXXL.primitivematerials.library.util.MaterialForm.*;

public final class ModMaterials {

    private ModMaterials() {}

    // METAL MATERIALS \\
    public static final MaterialDefinition IRON =
            new MaterialDefinition(
                    MaterialIDs.IRON,
                    MaterialType.METAL,
                    new MaterialForms(
                            BLOCK,
                            INGOT,
                            NUGGET,
                            DUST,
                            PLATE,
                            DENSE_PLATE,
                            ROD,
                            LONG_ROD,
                            BOLT,
                            SCREW,
                            GEAR,
                            SMALL_GEAR,
                            RING,
                            FINE_WIRE
                    )
            );

    public static final MaterialDefinition GOLD =
            new MaterialDefinition(
                    MaterialIDs.GOLD,
                    MaterialType.METAL,
                    new MaterialForms(
                            BLOCK,
                            INGOT,
                            NUGGET,
                            DUST,
                            PLATE,
                            DENSE_PLATE,
                            ROD,
                            LONG_ROD,
                            BOLT,
                            SCREW,
                            GEAR,
                            SMALL_GEAR,
                            RING,
                            FINE_WIRE
                    )
            );

    public static final MaterialDefinition COPPER =
            new MaterialDefinition(
                    MaterialIDs.COPPER,
                    MaterialType.METAL,
                    new MaterialForms(
                            BLOCK,
                            INGOT,
                            NUGGET,
                            DUST
                    )
            );

    public static final MaterialDefinition TIN =
            new MaterialDefinition(
                    MaterialIDs.TIN,
                    MaterialType.METAL,
                    new MaterialForms(
                            BLOCK,
                            INGOT,
                            NUGGET,
                            DUST
                    )
            );

    // ALLOY MATERIALS \\
    public static final MaterialDefinition BRONZE =
            new MaterialDefinition(
                    MaterialIDs.BRONZE,
                    MaterialType.METAL,
                    new MaterialForms(
                            BLOCK,
                            INGOT,
                            NUGGET,
                            DUST,
                            PLATE,
                            DENSE_PLATE,
                            ROD,
                            LONG_ROD,
                            BOLT,
                            SCREW,
                            GEAR,
                            SMALL_GEAR,
                            RING,
                            FINE_WIRE
                    )
            );

    // MINERAL MATERIALS \\


    // RESOURCE MATERIALS \\
}
