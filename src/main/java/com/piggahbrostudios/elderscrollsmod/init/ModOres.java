package com.piggahbrostudios.elderscrollsmod.init;

import com.piggahbrostudios.elderscrollsmod.block.BlockOre;
import com.piggahbrostudios.elderscrollsmod.gen.OreGen;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModOres {

    public static void mainRegistry() {

        initWorldGen();

    }

    public static void initWorldGen() {
        registerWorldGen(new OreGen((BlockOre) ModBlocks.MOONSTONE_ORE,10,64,50,10),0);
        registerWorldGen(new OreGen((BlockOre) ModBlocks.MALACHITE_ORE,10,64,25,5),0);
    }

    private static void registerWorldGen(OreGen oreGen, int weightedProbability) {
        GameRegistry.registerWorldGenerator(oreGen, weightedProbability);
    }

}
