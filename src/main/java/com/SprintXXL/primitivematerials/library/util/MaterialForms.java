package com.SprintXXL.primitivematerials.library.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaterialForms {

    private final Set<MaterialForm> forms;

    public MaterialForms(MaterialForm... forms) {

        this.forms = new HashSet<>(Arrays.asList(forms));
    }

    public Set<MaterialForm> getForms() {
        return forms;
    }

    public boolean hasForm(MaterialForm form) {
        return forms.contains(form);
    }
}
