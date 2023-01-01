package net.util.capabilities.slayer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SlayerProvider implements ICapabilitySerializable<NBTTagCompound>{

    @CapabilityInject(ISlayerCapability.class)
    public static final Capability<ISlayerCapability> Breath_CAP= null;
    private final ISlayerCapability instance = Breath_CAP.getDefaultInstance();

    @Nonnull
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {

        return capability == Breath_CAP;

    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == SlayerProvider.Breath_CAP)
            return Breath_CAP.cast(instance);
        return null;
    }


    @Override
    public NBTTagCompound serializeNBT()
    {
        return (NBTTagCompound) Breath_CAP.getStorage().writeNBT(Breath_CAP, this.instance, null);
    }


    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        if(Breath_CAP != null){
         Breath_CAP.getStorage().readNBT(Breath_CAP, this.instance, null, nbt);}

    }

}