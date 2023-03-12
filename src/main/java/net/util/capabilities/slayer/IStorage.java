package net.util.capabilities.slayer;

import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.util.capabilities.slayer.ISlayerCapability;

public class IStorage implements Capability.IStorage<ISlayerCapability>{

    public IStorage(){

    }

    @Override
    public NBTBase writeNBT(Capability<ISlayerCapability> capability, ISlayerCapability instance, EnumFacing side){

        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("level", instance.getLevel());
        tag.setInteger("xp", instance.getXP());
        tag.setFloat("mana", instance.getMana());
        tag.setInteger("breath", instance.getBreath());
        tag.setInteger("maxmana", instance.getMaxMana());
        tag.setInteger("maxxp", instance.getMaxXp());
        return tag;
    }
    @Override
    public void readNBT(Capability<ISlayerCapability> capability, ISlayerCapability instance, EnumFacing side, NBTBase nbt)
    {
        int breath = ((NBTTagCompound) nbt).getInteger("breath");
        int level = ((NBTTagCompound) nbt).getInteger("level");
        int xp = ((NBTTagCompound) nbt).getInteger("xp");
        float mana = ((NBTTagCompound) nbt).getFloat("mana");
        int maxmana= ((NBTTagCompound) nbt).getInteger("maxmana");
        int maxXp = ((NBTTagCompound) nbt).getInteger("maxxp");

        instance.setBreath(breath);
        instance.setLevel(level);
        instance.setXP(xp);
        instance.setMana(mana);
        instance.setMaxMana(maxmana);
        instance.setMaxXp(maxXp);

    }
}
