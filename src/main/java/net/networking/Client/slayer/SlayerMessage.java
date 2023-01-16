package net.networking.Client.slayer;


import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.util.capabilities.slayer.SlayerProvider;

public class SlayerMessage implements IMessage {
    public int Breath;
    public float Mana;
    public int XP;
    public int Level;
    public int MaxMana;

    public SlayerMessage(int Breath, Float Mana, int XP, int Level, int MaxMana){
        this.Breath = Breath;
        this.Mana = Mana;
        this.XP = XP;
        this.Level = Level;
        this.MaxMana = MaxMana;
    }
    public SlayerMessage(EntityPlayer player){
        this.Breath = player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
        this.Mana = player.getCapability(SlayerProvider.Breath_CAP, null).getMana();
        this.XP = player.getCapability(SlayerProvider.Breath_CAP, null).getXP();
        this.Level = player.getCapability(SlayerProvider.Breath_CAP, null).getLevel();
        this.MaxMana = player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana();
    }
    //if it a server entity it sends the message
    public SlayerMessage(EntityPlayerMP player){
        //Takes the parameters and sets it to each one
        this.Breath = player.getCapability(SlayerProvider.Breath_CAP, null).getBreath();
        this.Mana = player.getCapability(SlayerProvider.Breath_CAP, null).getMana();
        this.XP = player.getCapability(SlayerProvider.Breath_CAP, null).getXP();
        this.Level = player.getCapability(SlayerProvider.Breath_CAP, null).getLevel();
        this.MaxMana = player.getCapability(SlayerProvider.Breath_CAP, null).getMaxMana();

    }
    public SlayerMessage(){}


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
        Breath = buf.readInt();
        Mana = buf.readFloat();
        XP = buf.readInt();
        Level = buf.readInt();
        MaxMana = buf.readInt();
    }
}

