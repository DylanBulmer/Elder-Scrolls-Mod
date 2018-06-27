package com.piggahbrostudios.elderscrollsmod.world;

import com.piggahbrostudios.elderscrollsmod.block.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGen implements IWorldGenerator {

    Block block;
    String dimension;
    int maxYGen, blockCount;

    WorldGen (BlockOre ore, int maxYGen, int blockCount) {
        this.block = ore;
        this.dimension = ore.getDimension();
        this.maxYGen = maxYGen;
        this.blockCount = blockCount;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (dimension) {
            case "nether":
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case "overworld":
                generateWorld(world, random, chunkX * 16, chunkZ * 16);
                break;
            case "end":
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;

        }
    }

    private void generateWorld(World world, Random random, int chunkX, int chunkZ) {
        for (int i = 0; i < 100; i++) {
            BlockPos randPos = new BlockPos(chunkX + random.nextInt(16), random.nextInt(this.maxYGen), chunkZ + random.nextInt(16));

            (new WorldGenMinable(this.block.getDefaultState(), this.blockCount)).generate(world, random, randPos);
        }
    }

    private void generateNether(World world, Random random, int chunkX, int chunkZ) {

    }

    private void generateEnd(World world, Random random, int chunkX, int chunkZ) {

    }
}
