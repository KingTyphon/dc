package net.util.capabilities.techniquecapability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TechProvider implements ICapabilitySerializable<NBTTagCompound> {

    @CapabilityInject(iTechCapability.class)
    public static final Capability<iTechCapability> TECH_CAP= null;
    private final iTechCapability instance = TECH_CAP.getDefaultInstance();

    @Nonnull
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {

        return capability == TECH_CAP;

    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == net.util.capabilities.techniquecapability.TechProvider.TECH_CAP)
            return TECH_CAP.cast(instance);
        return null;
    }


    @Override
    public NBTTagCompound serializeNBT()
    {

        return (NBTTagCompound) TECH_CAP.getStorage().writeNBT(TECH_CAP, this.instance, null);
    }


    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        if(TECH_CAP != null){
        TECH_CAP.getStorage().readNBT(TECH_CAP, this.instance, null, nbt);}

    }

}