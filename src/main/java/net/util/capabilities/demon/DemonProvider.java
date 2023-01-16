//Provides the methods to grab the capabilities and provides the capabilities to be registered.
package net.util.capabilities.demon;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DemonProvider implements ICapabilitySerializable<NBTTagCompound> {

    @CapabilityInject(IDemonCapability.class)
    public static final Capability<IDemonCapability> DEMON_CAP= null;
    private final IDemonCapability instance = DEMON_CAP.getDefaultInstance();

    @Nonnull
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {

        return capability == DEMON_CAP;

    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == DemonProvider.DEMON_CAP)
            return DEMON_CAP.cast(instance);
        return null;
    }


    @Override
    public NBTTagCompound serializeNBT()
    {
        return (NBTTagCompound) DEMON_CAP.getStorage().writeNBT(DEMON_CAP, this.instance, null);
    }


    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        if(DEMON_CAP != null){
            DEMON_CAP.getStorage().readNBT(DEMON_CAP, this.instance, null, nbt);
        }

    }

}

