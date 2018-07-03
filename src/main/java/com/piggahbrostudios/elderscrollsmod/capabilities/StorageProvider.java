package com.piggahbrostudios.elderscrollsmod.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.piggahbrostudios.elderscrollsmod.Main.CAPABILITY_STORAGE;

public class StorageProvider implements ICapabilitySerializable<NBTTagCompound> {

    IStorage instance = CAPABILITY_STORAGE.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CAPABILITY_STORAGE;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return hasCapability(capability, facing) ? CAPABILITY_STORAGE.<T>cast(instance) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return (NBTTagCompound) CAPABILITY_STORAGE.getStorage().writeNBT(CAPABILITY_STORAGE, instance, null);
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        CAPABILITY_STORAGE.getStorage().readNBT(CAPABILITY_STORAGE, instance, null, nbt);
    }
}
