package com.piggahbrostudios.elderscrollsmod.item.spell;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import net.minecraft.item.ItemSnowball;

public class DamageSpellBase extends ItemSnowball {

    private String name;

    public DamageSpellBase(String name, int damage) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tab);

        setMaxDamage(damage);

        name = name.toUpperCase();
        this.name = name.replace("_", " ");

        ModItems.ITEMS.add(this);
    }

    public String getName () {
        return this.name;
    }

}
