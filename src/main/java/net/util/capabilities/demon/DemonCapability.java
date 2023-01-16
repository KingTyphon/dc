package net.util.capabilities.demon;

public class DemonCapability implements IDemonCapability {
    private int art;
    private float mana;
    private int level;
    private int xp;
    private int maxmana;
    private int maxXp;


    @Override
    public int getXP() {
        return xp;
    }

    @Override
    public int getMaxXp() {
        return maxXp;
    }

    @Override
    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    @Override
    public void levelUp() {
        if (this.xp == maxXp) {
            this.maxXp += 20 + 20 / maxXp;
            this.xp = 0;
            this.level += 1;
        }
    }

    @Override
    public void setXP(int xp) {
        this.xp = xp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public float getMana() {
        return mana;
    }

    @Override
    public void setMana(float mana) {
        this.mana = mana;
    }

    @Override
    public int getArt() {
        return art;
    }

    @Override
    public void setArt(int art) {
        this.art = art;
    }

    @Override
    public int getMaxMana() {
        return maxmana;
    }

    @Override
    public void setMaxMana(int maxmana) {
        this.maxmana = maxmana;
    }
}
