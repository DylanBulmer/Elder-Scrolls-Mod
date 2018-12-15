package com.piggahbrostudios.elderscrollsmod.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;

import static com.piggahbrostudios.elderscrollsmod.Main.CAPABILITY_STORAGE;

public class Storage implements IStorage {

    // Magika storage
    private float magika = 20;
    private float maxMagika = 20;

    // Stamina Storage
    private int stamina = 20;
    private int maxStamina = 20;

    // Tick counter
    private int currentTick = 0;
    private int resetTick = 20;

    // Track player's position and movement
    private double currentX = 0,
            currentY = 0,
            currentZ = 0;
    private double prevX = 0,
            prevY = 0,
            prevZ = 0;

    @Override
    public float getMagika() {
        return this.magika;
    }

    @Override
    public float getMaxMagika() {
        return this.maxMagika;
    }

    @Override
    public void setMagika(float magika) {
        this.magika = magika;
    }

    @Override
    public void addMagika(float magika) {
        this.magika += magika;

        if (this.magika > this.maxMagika) {
            this.magika = maxMagika;
        }
    }

    @Override
    public void removeMagika(float magika) {
        this.magika -= magika;

        if (this.magika < 0)
            this.magika = 0;
    }

    @Override
    public boolean isMagikaFull() {
        return this.magika == this.maxMagika;
    }

    @Override
    public int getMaxStamina() {
        return this.maxStamina;
    }

    @Override
    public int getStamina() {
        return this.stamina;
    }

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public void addStamina(int stamina) {
        this.stamina += stamina;

        if (this.stamina > this.maxStamina) {
            this.stamina = maxStamina;
        }
    }

    @Override
    public void removeStamina(int stamina) {
        this.stamina -= stamina;

        if (this.stamina < 0)
            this.stamina = 0;
    }

    @Override
    public boolean isStaminaFull() {
        return this.stamina == this.maxStamina;
    }

    @Override
    public int getCurrentTick() {
        return this.currentTick;
    }

    @Override
    public int getResetTick() {
        return this.resetTick;
    }

    @Override
    public void incrementCounter() {
        ++this.currentTick;
    }

    @Override
    public void resetCounter() {
        this.currentTick = 0;
    }

    @Override
    public void setPosition(EntityPlayer player) {
        prevX = currentX;
        prevY = currentY;
        prevZ = currentZ;

        currentX = player.posX;
        currentY = player.posY;
        currentZ = player.posZ;
    }

    @Override
    public boolean isMoving() {
        return (currentX != prevX || currentY != prevY || currentZ != prevZ);
    }

    public static IStorage getHandler(Entity entity) {

        if (entity.hasCapability(CAPABILITY_STORAGE, EnumFacing.DOWN))
            return entity.getCapability(CAPABILITY_STORAGE, EnumFacing.DOWN);

        return null;
    }

    public void setResetTick (int ticks) {
        this.resetTick = ticks;
    }

}
