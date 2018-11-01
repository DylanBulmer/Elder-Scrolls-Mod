package com.piggahbrostudios.elderscrollsmod.init;

import com.piggahbrostudios.elderscrollsmod.block.BlockOre;
import com.piggahbrostudios.elderscrollsmod.gen.OreGen;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModOres {


    // Must be a multiple of 5!
    public static class rarity {
        static int Common = 50;
        static int SemiCommon = 25;
        static int Rare = 10;
    }

    public static void mainRegistry() {

        initWorldGen();

    }

    private static void initWorldGen() {
        registerWorldGen(new OreGen((BlockOre) ModBlocks.MOONSTONE_ORE,10,64,rarity.Common,rarity.Common / 5));
        registerWorldGen(new OreGen((BlockOre) ModBlocks.MALACHITE_ORE,10,64,rarity.SemiCommon,rarity.SemiCommon / 5));
    }

    private static void registerWorldGen(OreGen oreGen) {
        GameRegistry.registerWorldGenerator(oreGen, 0);
    }

}
