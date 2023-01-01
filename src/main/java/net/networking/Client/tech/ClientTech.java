package net.networking.Client.tech;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.util.capabilities.techniquecapability.TechProvider;

public class ClientTech implements IMessage {
    //Data for every user
    public int tech;
    public int sp;
    public int health;
    public int speed;
    public int strength;
    public int manaPoint;

    public ClientTech(EntityPlayer player){
        //Takes the parameters and sets it to each one
        this.tech = player.getCapability(TechProvider.TECH_CAP, null).getTech();
        this.sp = player.getCapability(TechProvider.TECH_CAP, null).getSp();
        this.health = player.getCapability(TechProvider.TECH_CAP, null).getHealth();
        this.speed = player.getCapability(TechProvider.TECH_CAP,null).getSpeed();
        this.strength = player.getCapability(TechProvider.TECH_CAP, null).getStrength();
        this.manaPoint = player.getCapability(TechProvider.TECH_CAP, null).getManaPoint();

    }
    public ClientTech(){}

    @Override
    public void toBytes(ByteBuf buf) {
        //Writes hte ints into the ByteBuf
        buf.writeInt(tech);
        buf.writeInt(sp);
        buf.writeInt(health);
        buf.writeInt(speed);
        buf.writeInt(strength);
        buf.writeInt(manaPoint);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
        tech = buf.readInt();
        sp = buf.readInt();
        health = buf.readInt();
        speed = buf.readInt();
        strength = buf.readInt();
        manaPoint = buf.readInt();

    }
}
