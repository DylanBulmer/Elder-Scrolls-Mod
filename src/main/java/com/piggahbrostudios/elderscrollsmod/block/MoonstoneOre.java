package com.piggahbrostudios.elderscrollsmod.block;

public class MoonstoneOre extends BlockOre {

    public MoonstoneOre(String name, String dimension) {
        super(name, dimension);

        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);

    }
}
