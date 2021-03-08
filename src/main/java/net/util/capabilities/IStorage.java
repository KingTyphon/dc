package net.util.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.util.capabilities.slayer.ISlayerCapability;

public class IStorage implements Capability.IStorage<ISlayerCapability>{

    @Override
    public NBTBase writeNBT(Capability<ISlayerCapability> capability, ISlayerCapability instance, EnumFacing side){
        return new NBTTagInt(instance.getBreath());
    }
    @Override
    public void readNBT(Capability<ISlayerCapability> capability, ISlayerCapability instance, EnumFacing side, NBTBase nbt)
    {
        instance.setBreath(((NBTPrimitive) nbt).getInt());
    }
}
