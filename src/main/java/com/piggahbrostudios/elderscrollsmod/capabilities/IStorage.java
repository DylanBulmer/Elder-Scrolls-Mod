package com.piggahbrostudios.elderscrollsmod.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface IStorage {
    // Magika Setup
    int getMagika();
    int getMaxMagika();
    void setMagika(int magika);
    void addMagika(int magika);
    void removeMagika(int magika);
    boolean isMagikaFull();

    // Stamina Setup
    int getStamina();
    int getMaxStamina();
    void setStamina(int stamina);
    void addStamina(int stamina);
    void removeStamina(int stamina);
    boolean isStaminaFull();

    // Tick counter
    int getCurrentTick();
    int getResetTick();
    void incrementCounter();
    void resetCounter();

    // Movement Tracker
    void setPosition(EntityPlayer player);
    boolean isMoving();
}