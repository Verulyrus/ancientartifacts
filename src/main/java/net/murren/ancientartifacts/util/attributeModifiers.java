package net.murren.ancientartifacts.util;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class attributeModifiers {
    public static final AttributeModifier c = new AttributeModifier("reach", 2d, AttributeModifier.Operation.ADDITION);
    public static final AttributeModifier d = new AttributeModifier("followr", .5d, AttributeModifier.Operation.MULTIPLY_BASE);
}
