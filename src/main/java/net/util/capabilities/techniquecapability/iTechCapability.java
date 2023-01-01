package net.util.capabilities.techniquecapability;

import java.util.ArrayList;

public interface iTechCapability {
    public int getTech();
    public void setTech(int tech);
    public int getSp();
    public void setSp(int sp);
    public int getSpeed();
    public void setSpeed(int speed);
    public int getHealth();
    public void setHealth(int health);
    public int getStrength();
    public void setStrength(int strength);
    public int getManaPoint();
    public void setManaPoint(int mana);

    public void upgradeStat(String stat, int amount);



}
