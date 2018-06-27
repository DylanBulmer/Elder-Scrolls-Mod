package com.piggahbrostudios.elderscrollsmod.world;

import com.piggahbrostudios.elderscrollsmod.block.BlockOre;
import com.piggahbrostudios.elderscrollsmod.init.ModBlocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class World {

    public static void mainRegistry() {

        initWorldGen();

    }

    public static void initWorldGen() {
        registerWorldGen(new WorldGen((BlockOre) ModBlocks.MOONSTONE_ORE, 64, 10), 1);
        registerWorldGen(new WorldGen((BlockOre) ModBlocks.MALACHITE_ORE, 48, 5), 2);
    }

    private static void registerWorldGen(WorldGen worldGen, int weightedProbability) {
        GameRegistry.registerWorldGenerator(worldGen, weightedProbability);
    }

}
