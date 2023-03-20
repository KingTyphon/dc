package net.util.capabilities.slayer;

import net.minecraftforge.common.util.INBTSerializable;

public interface ISlayerCapability {

    public void levelUp();
    public float getMana();
    public int getXP();
    public int getLevel();
    public int getMaxXp();
    public int getBreath();
    public int getMaxMana();

    public void setMaxXp(int maxXp);
    public void setXP(int xp);
    public void setLevel(int level);
    public void setMana(float mana);
    public void setBreath(int breath);
    public void setMaxMana(int maxmana);
    public void copyFrom(ISlayerCapability player);
}
