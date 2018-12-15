package com.piggahbrostudios.elderscrollsmod.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class StorageHandler implements Capability.IStorage<IStorage> {

    @Override
    public NBTBase writeNBT(Capability<IStorage> capability, IStorage instance, EnumFacing side) {
        final NBTTagCompound tag = new NBTTagCompound();
        tag.setFloat("magika", instance.getMagika());
        tag.setInteger("stamina", instance.getStamina());
        return tag;
    }

    @Override
    public void readNBT(Capability<IStorage> capability, IStorage instance, EnumFacing side, NBTBase nbt) {
        final NBTTagCompound tag = (NBTTagCompound) nbt;
        instance.setMagika(tag.getFloat("magika"));
        instance.setStamina(tag.getInteger("stamina"));
    }

}
