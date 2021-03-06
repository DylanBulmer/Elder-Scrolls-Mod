package com.piggahbrostudios.elderscrollsmod.item.tool;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.util.IHasModel;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel {

    public ToolHoe(String name, ToolMaterial material) {

        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tab);

        ModItems.ITEMS.add(this);

    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "Inventory");
    }
}
