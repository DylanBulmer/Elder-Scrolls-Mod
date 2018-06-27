package com.piggahbrostudios.elderscrollsmod.block;

public class MalachiteOre extends BlockOre {

    public MalachiteOre(String name, String dimension) {

        super(name, dimension);

        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);

    }
}
