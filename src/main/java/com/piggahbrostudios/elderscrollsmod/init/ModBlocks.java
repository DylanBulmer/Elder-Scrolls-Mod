package com.piggahbrostudios.elderscrollsmod.init;

import com.piggahbrostudios.elderscrollsmod.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    // Blocks
    public static final Block STEEL_BLOCK = new SteelBlock("steel_block", Material.IRON);
    public static final Block MOONSTONE_BLOCK = new MoonstoneBlock("moonstone_block", Material.IRON);
    public static final Block MALACHITE_BLOCK = new MalachiteBlock("malachite_block", Material.IRON);

    // Ores
    public static final Block MOONSTONE_ORE = new MoonstoneOre("moonstone_ore", "overworld");
    public static final Block MALACHITE_ORE = new MalachiteOre("malachite_ore", "overworld");

}
