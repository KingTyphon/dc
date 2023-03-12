package net.util.capabilities.slayer;

import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.networking.messages.slayer.Slayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SlayerProvider implements ICapabilitySerializable<NBTBase>{

    @CapabilityInject(ISlayerCapability.class)
    public static final Capability<ISlayerCapability> Breath_CAP= null;
    private final ISlayerCapability instance = new SlayerCapability();

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
    public NBTBase serializeNBT()
    {
        return Breath_CAP.getStorage().writeNBT(Breath_CAP, this.instance, null);
    }


    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        if(Breath_CAP != null){
         Breath_CAP.getStorage().readNBT(Breath_CAP, this.instance, null, nbt);}

    }
    public static String slayerToString (ISlayerCapability slayerCapability){
        return Breath_CAP.getStorage().writeNBT(Breath_CAP, slayerCapability, null).toString();
    }

    public static ISlayerCapability stringtoSlayer(String s){
        try{
            ISlayerCapability cap = new SlayerCapability();
            Breath_CAP.getStorage().readNBT(Breath_CAP, cap, null, JsonToNBT.getTagFromJson(s));
            return cap;
        }catch (Exception var2) {
            System.out.println(var2);
            return null;
        }
        }
    }