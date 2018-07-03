package com.piggahbrostudios.elderscrollsmod.util.handlers;

import com.piggahbrostudios.elderscrollsmod.capabilities.IStorage;
import com.piggahbrostudios.elderscrollsmod.capabilities.StorageProvider;
import com.piggahbrostudios.elderscrollsmod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.piggahbrostudios.elderscrollsmod.capabilities.Storage.getHandler;

public class ModEventHandler {

    @SubscribeEvent
    public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {

        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Reference.MODID), new StorageProvider());
        }
    }

    @SubscribeEvent
    public void clonePlayer(PlayerEvent.Clone event) {

        final IStorage original = getHandler(event.getOriginal());
        final IStorage clone = getHandler(event.getEntity());

        clone.setMagika(original.getMagika());
        clone.setStamina(original.getStamina());

    }

    @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();

            // Add items to players' inventory
            //player.inventory.addItemStackToInventory(new ItemStack(ModItems.ELVEN_DAGGER));
        }
    }

    @SubscribeEvent
    public void livingDrops(LivingDropsEvent event) {
        // tests if the entity killed is a mob and if the killer is a player.
        if (event.getEntity() instanceof EntityMob && event.getSource().getTrueSource() instanceof EntityPlayer) {

            // Create mob drops here.

        }
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();

            IStorage storage = getHandler(player);

            // Do these things every 5 ticks
            if (storage.getCurrentTick() % 5 == 0) {

                // Update position
                storage.setPosition(player);

                // Remove stamina if sprinting
                if (player.isSprinting()) {
                    if (storage.getStamina() >= 1) {
                        storage.removeStamina(1);
                    } else {
                        player.setSprinting(false);
                    }
                }
            }

            // Do these every 20 ticks (getResetTick is set to 20 in Storage.java)
            if (storage.getCurrentTick() == storage.getResetTick()) {
                // reset the counter
                storage.resetCounter();

                // add magika
                if (storage.getMagika() < storage.getMaxMagika())
                    storage.addMagika(2);

                // add stamina
                if (storage.getStamina() < storage.getMaxStamina() && !player.isSprinting()) {
                    if (storage.isMoving()) { // add 1 if moving
                        storage.addStamina(1);
                    } else { // else or if standing still, add 2
                        storage.addStamina(2);
                    }
                }
            }

            // increment counter every tick
            storage.incrementCounter();
        }
    }

    @SubscribeEvent
    public void livingJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();

            IStorage storage = getHandler(player);

            // Remove 2 stamina every jump
//            if (storage.getStamina() <= 2) {
//                if (event.isCancelable()) {
//                    event.setCanceled(true);
//                }
//            } else {
//                storage.removeStamina(2);
//            }
        }
    }

}
