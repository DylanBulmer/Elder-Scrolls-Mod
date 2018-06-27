package com.piggahbrostudios.elderscrollsmod.block;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.init.ModBlocks;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOre extends Block implements IHasModel {

    private String name, dimension;

    public BlockOre(String name, String dimension) {

        super(Material.ROCK);

        this.name = name;
        this.dimension = dimension;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    public String getName() {
        return name;
    }

    public String getDimension() {
        return dimension;
    }
}
