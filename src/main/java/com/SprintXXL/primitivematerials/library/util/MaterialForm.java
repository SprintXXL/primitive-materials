package com.SprintXXL.primitivematerials.library.util;

import com.SprintXXL.primitivematerials.library.MaterialDefinition;

import java.util.function.Function;

public enum MaterialForm {

    BLOCK(MaterialDefinition::getBlockName),
    ITEM(MaterialDefinition::getItemName),
    INGOT(MaterialDefinition::getIngotName),
    NUGGET(MaterialDefinition::getNuggetName),
    DUST(MaterialDefinition::getDustName),
    PLATE(MaterialDefinition::getPlateName),
    DENSE_PLATE(MaterialDefinition::getDensePlateName),
    ROD(MaterialDefinition::getRodName),
    LONG_ROD(MaterialDefinition::getLongRodName),
    BOLT(MaterialDefinition::getBoltName),
    SCREW(MaterialDefinition::getScrewName),
    RING(MaterialDefinition::getRingName),
    FINE_WIRE(MaterialDefinition::getFineWireName),
    GEAR(MaterialDefinition::getGearName),
    SMALL_GEAR(MaterialDefinition::getSmallGearName);

    private final Function<MaterialDefinition, String> nameGetter;

    MaterialForm(Function<MaterialDefinition, String> nameGetter) {

        this.nameGetter = nameGetter;
    }

    public String getName(MaterialDefinition material) {
        return nameGetter.apply(material);
    }
}
