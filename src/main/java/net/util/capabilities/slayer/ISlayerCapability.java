package net.util.capabilities.slayer;

import net.minecraftforge.common.util.INBTSerializable;

public interface ISlayerCapability {

    public int getBreath();
    public void setBreath(int breath);
    public boolean isSlayer();

}
