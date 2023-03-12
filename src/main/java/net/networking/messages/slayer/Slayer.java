package net.networking.messages.slayer;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;

public class Slayer implements IMessage {
    public int Breath;
    public float Mana;
    public int XP;
    public int Level;
    public int MaxMana;


    public Slayer(int xp){
        this.XP = xp;
    }
    public Slayer(ISlayerCapability lb){
        this.Breath = lb.getBreath();
        this.Mana = lb.getMana();
        this.XP = lb.getXP();
        this.Level = lb.getLevel();
        this.MaxMana = lb.getMaxMana();
    }
    public Slayer(int breath, float mana, int xp, int level, int maxMana){
        this.Breath = breath;
        this.Mana = mana;
        this.XP = xp;
        this.Level = level;
        this.MaxMana = maxMana;
    }
    public Slayer(){}




    @Override public void toBytes(ByteBuf buf) {
        // Writes the int into the buf
        buf.writeInt(Breath);
        buf.writeFloat(Mana);
        buf.writeInt(XP);
        buf.writeInt(Level);
        buf.writeInt(MaxMana);



    }

    @Override public void fromBytes(ByteBuf buf) {
        // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
        this.Breath = buf.readInt();
        this.Mana = buf.readFloat();
        this.XP = buf.readInt();
        this.Level = buf.readInt();
        this.MaxMana = buf.readInt();

    }
}

