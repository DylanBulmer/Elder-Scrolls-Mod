package com.piggahbrostudios.elderscrollsmod.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SteelBlock extends BlockBase {

    public SteelBlock(String name, Material material) {
        super(name, material);

        // Walking/Running over
        setSoundType(SoundType.METAL);

        setHardness(5.0F);
        setResistance(30.0F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(0.0F);

    }
}
