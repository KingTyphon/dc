package net.networking.Client.demon;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.util.capabilities.slayer.SlayerProvider;

public class DemonMessage implements IMessage {
    public int Art;
    public float Mana;
    public int XP;
    public int Level;
    public int MaxMana;

    public DemonMessage(int art, Float Mana, int XP, int Level, int MaxMana){
        this.Art = art;
        this.Mana = Mana;
        this.XP = XP;
        this.Level = Level;
        this.MaxMana = MaxMana;
    }
    public DemonMessage(EntityPlayer player){
        this.Art = player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
        this.Mana = player.getCapability(SlayerProvider.Breath_CAP, null).getMana();
        this.XP = player.getCapability(SlayerProvider.Breath_CAP, null).getXP();
        this.Level = player.getCapability(SlayerProvider.Breath_CAP, null).getLevel();
        this.MaxMana = player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana();
    }
    //if it a server entity it sends the message
    public DemonMessage(EntityPlayerMP player){
        //Takes the parameters and sets it to each one
        this.Art = player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
        this.Mana = player.getCapability(SlayerProvider.Breath_CAP, null).getMana();
        this.XP = player.getCapability(SlayerProvider.Breath_CAP, null).getXP();
        this.Level = player.getCapability(SlayerProvider.Breath_CAP, null).getLevel();
        this.MaxMana = player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana();

    }
    public DemonMessage(){}


    @Override public void toBytes(ByteBuf buf) {
        // Writes the int into the buf
        buf.writeInt(Art);
        buf.writeFloat(Mana);
        buf.writeInt(XP);
        buf.writeInt(Level);
        buf.writeInt(MaxMana);
    }

    @Override public void fromBytes(ByteBuf buf) {
        // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
        Art = buf.readInt();
        Mana = buf.readFloat();
        XP = buf.readInt();
        Level = buf.readInt();
        MaxMana = buf.readInt();
    }
}
