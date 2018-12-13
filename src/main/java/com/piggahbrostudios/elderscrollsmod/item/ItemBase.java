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

        name = name.toUpperCase();
        this.name = name.replace("_", " ");

        /*String[] names = name.toUpperCase().split("_");

        for (String part : names) {
            this.name += part + " ";
        }*/

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
