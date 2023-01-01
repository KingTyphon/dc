package net.util.capabilities.slayer;

import net.minecraftforge.common.util.INBTSerializable;

public interface ISlayerCapability {

    public int getLevel();
    public int getXP();
    public void levelUp();
    public float getMana();
    public void setXP(int xp);
    public void setLevel(int level);
    public void setMana(float mana);
    public int getBreath();
    public void setBreath(int breath);
    public int getMaxMana();
    public void setMaxMana(int maxmana);
}
