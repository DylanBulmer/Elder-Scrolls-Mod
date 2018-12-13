package com.piggahbrostudios.elderscrollsmod.item.spell;

import com.piggahbrostudios.elderscrollsmod.Main;
import com.piggahbrostudios.elderscrollsmod.init.ModItems;
import com.piggahbrostudios.elderscrollsmod.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class HealSpell extends SpellBase implements IHasModel {

    private float healthPerTick = 0;
    private String name;

    public HealSpell(String name, float healthPerTick) {

        super(name);

        this.healthPerTick = healthPerTick;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {

        System.out.println("On item use...");

        if (player.getHealth() < player.getMaxHealth()) {
            player.setHealth(player.getHealth() + healthPerTick);
        }

        return super.onItemRightClick(world, player, handIn);
    }

    public float getHealthPerTick() {
        return healthPerTick;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "Inventory");
    }
}
