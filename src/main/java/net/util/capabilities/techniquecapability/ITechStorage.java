package net.util.capabilities.techniquecapability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.util.capabilities.slayer.ISlayerCapability;

public class ITechStorage implements Capability.IStorage<iTechCapability>{

    @Override
    public NBTBase writeNBT(Capability<iTechCapability> capability, iTechCapability instance, EnumFacing side){
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("tech", instance.getTech());
        tag.setInteger("sp", instance.getSp());
        tag.setInteger("speed", instance.getSpeed());
        tag.setInteger("health", instance.getHealth());
        tag.setInteger("strength", instance.getStrength());
        tag.setInteger("manapoint", instance.getManaPoint());
        return tag;
    }
    @Override
    public void readNBT(Capability<iTechCapability> capability, iTechCapability instance, EnumFacing side, NBTBase nbt)
    {
        int tech = ((NBTTagCompound) nbt).getInteger("tech");
        int sp = ((NBTTagCompound) nbt).getInteger("sp");
        int speed = ((NBTTagCompound) nbt).getInteger("speed");
        int health = ((NBTTagCompound) nbt).getInteger("health");
        int strength = ((NBTTagCompound) nbt).getInteger("strength");


        instance.setTech(tech);
        instance.setSp(sp);
        instance.setHealth(health);
        instance.setSpeed(speed);
        instance.setStrength(strength);

    }
}