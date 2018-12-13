package com.piggahbrostudios.elderscrollsmod.item.spell;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import net.minecraft.item.Item;

public class SpellBase extends Item {

    private String name;

    SpellBase() {
        ModItems.ITEMS.add(this); // sure?
    }

    SpellBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tab);

        name = name.toUpperCase();
        this.name = name.replace("_", " ");

        ModItems.ITEMS.add(this);
    }

    public String getName() {
        return name;
    }
}
