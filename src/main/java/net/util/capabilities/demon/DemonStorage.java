//Stores the data needed for Demon Entity
package net.util.capabilities.demon;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class DemonStorage implements Capability.IStorage<IDemonCapability>{

    @Override
    public NBTBase writeNBT(Capability<IDemonCapability> capability, IDemonCapability instance, EnumFacing side){

        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("level", instance.getLevel());
        tag.setInteger("xp", instance.getXP());
        tag.setFloat("mana", instance.getMana());
        tag.setInteger("art", instance.getArt());
        tag.setInteger("maxmana", instance.getMaxMana());
        tag.setInteger("maxxp", instance.getMaxXp());

        return tag;
    }
    @Override
    public void readNBT(Capability<IDemonCapability> capability, IDemonCapability instance, EnumFacing side, NBTBase nbt)
    {

        int level = ((NBTTagCompound) nbt).getInteger("level");
        int xp = ((NBTTagCompound) nbt).getInteger("xp");
        float mana = ((NBTTagCompound) nbt).getFloat("mana");
        int art = ((NBTTagCompound) nbt).getInteger("art");
        int maxmana= ((NBTTagCompound) nbt).getInteger("maxmana");
        int maxXp = ((NBTTagCompound) nbt).getInteger("maxxp");

        instance.setArt(art);
        instance.setLevel(level);
        instance.setXP(xp);
        instance.setMana(mana);
        instance.setMaxMana(maxmana);
        instance.setMaxXp(maxXp);


    }
}

