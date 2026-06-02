package com.SprintXXL.primitivematerials.materials;

import com.SprintXXL.primitivematerials.materials.util.MaterialForms;

public class MaterialDefinition {

    private final String id;
    private final MaterialForms forms;

    public MaterialDefinition(
            String id,
            MaterialForms forms
    ) {
        this.id = id;
        this.forms = forms;
    }

    public String getID() {
        return id;
    }

    public MaterialForms getForms() {
        return forms;
    }
}
