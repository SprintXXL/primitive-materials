package com.SprintXXL.primitivematerials.library;

import com.SprintXXL.primitivematerials.library.util.MaterialForms;
import com.SprintXXL.primitivematerials.library.util.MaterialType;

public class MaterialDefinition {

    private final String id;
    private final MaterialType type;
    private final MaterialForms forms;

    public MaterialDefinition(
            String id,
            MaterialType type,
            MaterialForms forms
    ) {
        this.id = id;
        this.type = type;
        this.forms = forms;
    }

    public String getID() {
        return id;
    }

    public MaterialType getType() {
        return type;
    }

    public MaterialForms getForms() {
        return forms;
    }

    public String getBlockName() {
        return id + "_block";
    }

    public String getItemName() {
        return id;
    }

    public String getIngotName() {
        return id + "_ingot";
    }

    public String getNuggetName() {
        return id + "_nugget";
    }

    public String getDustName() {
        return id + "_dust";
    }

    public String getPlateName() {
        return id + "_plate";
    }

    public String getDensePlateName() {
        return "dense_" + id + "_plate";
    }

    public String getRodName() {
        return id + "_rod";
    }

    public String getLongRodName() {
        return "long_" + id + "_rod";
    }

    public String getBoltName() {
        return id + "_bolt";
    }

    public String getScrewName() {
        return id + "_screw";
    }

    public String getRingName() {
        return id + "_ring";
    }

    public String getGearName() {
        return id + "_gear";
    }

    public String getSmallGearName() {
        return "small_" + id + "_gear";
    }

    public String getFineWireName() {
        return "fine_" + id + "_wire";
    }
}
