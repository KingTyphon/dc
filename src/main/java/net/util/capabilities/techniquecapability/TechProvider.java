package net.util.capabilities.techniquecapability;

import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.networking.messages.tech.Tech;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerCapability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TechProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(ITechCapability.class)
    public static final Capability<ITechCapability> TECH_CAP= null;
    private final ITechCapability instance = new TechCapability();

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
    public NBTBase serializeNBT()
    {

        return TECH_CAP.getStorage().writeNBT(TECH_CAP, this.instance, null);
    }


    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        if(TECH_CAP != null){
        TECH_CAP.getStorage().readNBT(TECH_CAP, this.instance, null, nbt);}

    }
    public static String techToString (ITechCapability techCapability){
        return TECH_CAP.getStorage().writeNBT(TECH_CAP, techCapability, null).toString();
    }
    public static ITechCapability stringtoTech(String s){
        try{
            ITechCapability cap = new TechCapability();
            TECH_CAP.getStorage().readNBT(TECH_CAP, cap, null, JsonToNBT.getTagFromJson(s));
            return cap;
        }catch (Exception var2) {
            System.out.println(var2);
            return null;
        }
    }
}