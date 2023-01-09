package net.util.capabilities.techniquecapability;

import net.minecraft.client.Minecraft;

import java.util.ArrayList;

public class TechCapability implements iTechCapability {
    private int tech;
    private int sp;
    private int health;
    private int speed;
    private int strength;
    private int manaPoint;
    private int skill;

    @Override
    public int getSkill(){
        return this.skill;
    }
    @Override
    public void setSkill(int skill){
        this.skill = skill;
    }

    @Override
    public int getSp() {return this.sp;}

    @Override
    public void setSp(int sp) {this.sp = sp;}


    @Override
    public int getSpeed() {return speed;}

    @Override
    public void setSpeed(int speed) {this.speed = speed;}

    @Override
    public int getHealth() {return health;}
    @Override
    public void setHealth(int health) {this.health = health;}

    @Override
    public int getTech() {return tech;}
    @Override
    public void setTech(int tech) {this.tech = tech;}

    @Override
    public int getStrength(){
        return strength;
    }
    @Override
    public void setStrength(int strength){this.strength = strength;}

    @Override
    public int getManaPoint(){return manaPoint;}
    @Override
    public void setManaPoint(int manaPoint){
        this.manaPoint = manaPoint;
    }

    @Override
    public void upgradeStat(String stat, int amount) {
        switch (stat) {
            case ("health"):
                setHealth(getHealth()+amount);
                setSp(getSp()-amount);
                break;
            case ("speed"):
                setSpeed(getSpeed()+amount);
                setSp(getSp()-amount);
                break;
            case ("strength"):
                setStrength(getStrength()+amount);
                setSp(getSp()-amount);
                break;
            case ("mana"):
                setManaPoint(getManaPoint()+amount);
                setSp(getSp()-amount);
            case ("technique"):
                setSp(getSp()-amount);
                break;
            default:
                break;
        }

    }

}

