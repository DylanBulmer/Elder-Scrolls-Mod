package com.piggahbrostudios.elderscrollsmod.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface IStorage {
    // Magika Setup
    float getMagika();
    float getMaxMagika();
    void setMagika(float magika);
    void addMagika(float magika);
    void removeMagika(float magika);
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