package com.piggahbrostudios.elderscrollsmod.init;

import com.piggahbrostudios.elderscrollsmod.block.SteelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block STEEL_BLOCK = new SteelBlock("steel_block", Material.IRON);

}
