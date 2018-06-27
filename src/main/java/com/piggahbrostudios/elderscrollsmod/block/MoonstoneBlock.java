package com.piggahbrostudios.elderscrollsmod.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MoonstoneBlock extends BlockBase {

    public MoonstoneBlock(String name, Material material) {
        super(name, material);

        // Walking/Running over
        setSoundType(SoundType.STONE);

        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);

    }
}
