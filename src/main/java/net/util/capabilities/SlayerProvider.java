package net.util.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.util.capabilities.slayer.ISlayerCapability;

public class SlayerProvider implements ICapabilitySerializable<NBTBase>{

    @CapabilityInject(ISlayerCapability.class)
    public static final Capability<ISlayerCapability> Breath_CAP= null;


    private ISlayerCapability instance = Breath_CAP.getDefaultInstance();


    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {

        return capability == Breath_CAP;

    }


    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == Breath_CAP && facing == null) Breath_CAP.<T>cast(this.instance);
        return null;
    }


    @Override
    public NBTBase serializeNBT()
    {

        return Breath_CAP.getStorage().writeNBT(Breath_CAP, this.instance, null);

    }


    @Override
    public void deserializeNBT(NBTBase nbt)
    {

        Breath_CAP.getStorage().readNBT(Breath_CAP, this.instance, null, nbt);

    }

}