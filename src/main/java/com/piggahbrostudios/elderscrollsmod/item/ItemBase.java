package com.piggahbrostudios.elderscrollsmod.item;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.util.IHasModel;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    private String name = "";

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tab);

        String[] names = name.toUpperCase().split("_");

        for (int i = 0; i < names.length; i++) {
            if (i != names.length) {
                this.name += names + " ";
            }
        }

        ModItems.ITEMS.add(this);
    }

    public String getName () {
        return this.name;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "Inventory");
    }
}
