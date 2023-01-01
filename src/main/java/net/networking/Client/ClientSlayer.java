package net.networking.Client;


import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ClientSlayer implements IMessage {
    public int Breath;
    public float Mana;
    public int XP;
    public int Level;
    public int MaxMana;

    public ClientSlayer(int Breath, Float Mana, int XP, int Level, int MaxMana){
        this.Breath = Breath;
        this.Mana = Mana;
        this.XP = XP;
        this.Level = Level;
        this.MaxMana = MaxMana;
    }
    public ClientSlayer(){}


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

