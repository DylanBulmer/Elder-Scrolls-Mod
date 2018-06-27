package com.piggahbrostudios.elderscrollsmod.init;

import com.piggahbrostudios.elderscrollsmod.item.ItemBase;
import com.piggahbrostudios.elderscrollsmod.item.tool.ToolSpade;
import com.piggahbrostudios.elderscrollsmod.item.tool.ToolSword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    // Materials
    public static final Item.ToolMaterial MATERIAL_STEEL = EnumHelper.addToolMaterial("material_steel", 1, 250, 6.0F, 2.0F, 15);
    public static final Item.ToolMaterial MATERIAL_GLASS = EnumHelper.addToolMaterial("material_glass", 1, 250, 6.0F, 2.0F, 15);
    public static final Item.ToolMaterial MATERIAL_ELVEN = EnumHelper.addToolMaterial("material_elven", 2, 300, 7.0F, 2.0F, 15);

    // Items
    public static final Item STEEL_INGOT = new ItemBase("steel_ingot");
    public static final Item MALACHITE_INGOT = new ItemBase("malachite_ingot");
    public static final Item MOONSTONE_INGOT = new ItemBase("moonstone_ingot");
    public static final Item MALACHITE_NUGGET = new ItemBase("malachite_nugget");
    public static final Item MOONSTONE_NUGGET = new ItemBase("moonstone_nugget");
    public static final Item STEEL_NUGGET = new ItemBase("steel_nugget");

    // Tools
    public static final ItemSword ELVEN_SWORD = new ToolSword("elven_sword", MATERIAL_ELVEN);
    public static final ItemSword ELVEN_DAGGER = new ToolSword("elven_dagger", MATERIAL_ELVEN);
    public static final ItemSword GLASS_SWORD = new ToolSword("glass_sword", MATERIAL_GLASS);
    public static final ItemSword GLASS_DAGGER = new ToolSword("glass_dagger", MATERIAL_GLASS);

    public static final ItemSpade STEEL_SHOVEL = new ToolSpade("steel_shovel", MATERIAL_STEEL);

}
