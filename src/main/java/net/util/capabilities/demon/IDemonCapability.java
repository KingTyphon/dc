package net.util.capabilities.demon;

public interface IDemonCapability {
    public int getLevel();
    public int getMaxXp();
    public void setMaxXp(int maxXp);
    public int getXP();
    public void levelUp();
    public float getMana();
    public void setXP(int xp);
    public void setLevel(int level);
    public void setMana(float mana);
    public int getArt();
    public void setArt(int breath);
    public int getMaxMana();
    public void setMaxMana(int maxmana);

}
