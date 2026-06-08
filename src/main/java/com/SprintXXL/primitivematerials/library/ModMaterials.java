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
    public static final MaterialDefinition REDSTONE =
            new MaterialDefinition(
                    MaterialIDs.REDSTONE,
                    MaterialType.MINERAL,
                    new MaterialForms(
                            BLOCK,
                            DUST
                    )
            );
    public static final MaterialDefinition CINNABAR =
            new MaterialDefinition(
                    MaterialIDs.CINNABAR,
                    MaterialType.MINERAL,
                    new MaterialForms(
                            ITEM
                    )
            );
    public static final MaterialDefinition DIAMOND =
            new MaterialDefinition(
                    MaterialIDs.DIAMOND,
                    MaterialType.MINERAL,
                    new MaterialForms(
                            BLOCK,
                            ITEM,
                            DUST
                    )
            );
    public static final MaterialDefinition COAL =
            new MaterialDefinition(
                    MaterialIDs.COAL,
                    MaterialType.MINERAL,
                    new MaterialForms(
                            BLOCK,
                            ITEM,
                            DUST
                    )
            );
    public static final MaterialDefinition LIGNITE_COAL =
            new MaterialDefinition(
                    MaterialIDs.LIGNITE_COAL,
                    MaterialType.MINERAL,
                    new MaterialForms(
                            BLOCK,
                            ITEM,
                            DUST
                    )
            );

    // RESOURCE MATERIALS \\
    public static final MaterialDefinition OBSIDIAN =
            new MaterialDefinition(
                    MaterialIDs.OBSIDIAN,
                    MaterialType.RESOURCE,
                    new MaterialForms(
                            BLOCK,
                            DUST,
                            ROD
                    )
            );
    public static final MaterialDefinition FLINT =
            new MaterialDefinition(
                    MaterialIDs.FLINT,
                    MaterialType.RESOURCE,
                    new MaterialForms(
                            DUST
                    )
            );
    public static final MaterialDefinition SAND =
            new MaterialDefinition(
                    MaterialIDs.SAND,
                    MaterialType.RESOURCE,
                    new MaterialForms(
                            BLOCK,
                            DUST
                    )
            );
    public static final MaterialDefinition BONE =
            new MaterialDefinition(
                    MaterialIDs.BONE,
                    MaterialType.RESOURCE,
                    new MaterialForms(
                            BLOCK,
                            DUST
                    )
            );
    public static final MaterialDefinition WOOD =
            new MaterialDefinition(
                    MaterialIDs.WOOD,
                    MaterialType.RESOURCE,
                    new MaterialForms(
                            DUST,
                            ROD
                    )
            );
    public static final MaterialDefinition STONE =
            new MaterialDefinition(
                    MaterialIDs.STONE,
                    MaterialType.RESOURCE,
                    new MaterialForms(
                            BLOCK
                    )
            );
}
