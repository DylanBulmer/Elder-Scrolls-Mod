package com.piggahbrostudios.elderscrollsmod.gen;

import com.piggahbrostudios.elderscrollsmod.block.BlockOre;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    private WorldGenerator gen;
    private String dimension;
    private int minY, maxY, chance;

    public OreGen(BlockOre ore, int minY, int maxY, int chance, int blockCount) {
        this.gen = new WorldGenMinable(ore.getDefaultState(), blockCount);
        this.dimension = ore.getDimension();
        this.minY = minY;
        this.maxY = maxY;
        this.chance = chance;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (dimension) {
            case "nether":
                break;
            case "overworld":
                runGenerator(this.gen, world, random, chunkX * 16, chunkZ * 16, this.chance, this.minY, this.maxY);
                break;
            case "end":
                break;

        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random random, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {

        // Calculate how high the ore can generate
        int heightDiff = maxHeight - minHeight + 1;
        int x,y,z;

        for (int i = 0; i < chance; i++) {
            // Bind X and Z to be maintained within the 16x16 chunk.
            // Bind Y to -> min height < random y < min height + height difference
            x = chunkX + random.nextInt(16);
            y = minHeight + random.nextInt(heightDiff);
            z = chunkZ + random.nextInt(16);

            gen.generate(world, random, new BlockPos(x, y, z));
        }
    }
}