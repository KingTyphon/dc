package net.util.capabilities.techniquecapability;

public class TechCapability implements iTechCapability{
    private int tech;

    @Override
    public int getTech(){return tech;}
    @Override
    public void setTech(int tech){this.tech = tech;}
}
