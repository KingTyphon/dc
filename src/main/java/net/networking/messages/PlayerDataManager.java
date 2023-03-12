package net.networking.messages;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.networking.Networking;
import net.networking.messages.slayer.Slayer;
import net.networking.messages.slayer.SlayerMessage;
import net.util.capabilities.slayer.ISlayerCapability;
import net.util.capabilities.slayer.SlayerProvider;

public class PlayerDataManager {


    public static ISlayerCapability getSlayer(EntityLivingBase livingBase){
             return livingBase.getCapability(SlayerProvider.Breath_CAP, null);
    }

    public static void updateClientSlayer(EntityPlayerMP player, ISlayerCapability slayer){
        if(player != null && slayer != null){
            Networking.sendTo(new SlayerMessage(slayer),  player);
        }
    }
}
