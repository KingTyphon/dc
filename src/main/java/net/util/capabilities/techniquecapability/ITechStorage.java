package net.util.capabilities.techniquecapability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.util.capabilities.slayer.ISlayerCapability;

public class ITechStorage implements Capability.IStorage<iTechCapability>{

    @Override
    public NBTBase writeNBT(Capability<iTechCapability> capability, iTechCapability instance, EnumFacing side){
        return new NBTTagInt(instance.getTech());
    }
    @Override
    public void readNBT(Capability<iTechCapability> capability, iTechCapability instance, EnumFacing side, NBTBase nbt)
    {
        instance.setTech(((NBTPrimitive) nbt).getInt());

    }
}