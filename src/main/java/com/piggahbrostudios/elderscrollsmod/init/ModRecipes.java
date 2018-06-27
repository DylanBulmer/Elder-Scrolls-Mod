package com.piggahbrostudios.elderscrollsmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {
        // Smelting Recipes
        GameRegistry.addSmelting(ModBlocks.MALACHITE_ORE, new ItemStack(ModItems.MALACHITE_INGOT, 1), 0.0F);
        GameRegistry.addSmelting(ModBlocks.MOONSTONE_ORE, new ItemStack(ModItems.MOONSTONE_INGOT, 1), 0.0F);
        GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(ModItems.STEEL_INGOT, 1), 0.0F);
    }

}
