package com.spring.extramob.toolmaterial;

import com.spring.extramob.tags.ModTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterial {
    public static final ToolMaterial TestMaterial = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_TEST_TOOL,
            10,
            10,
            10,
            10,
            ItemTags.REPAIRS_DIAMOND_ARMOR
    );


}
