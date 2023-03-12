package net.networking.messages;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.networking.messages.PlayerDataManager;
import net.util.capabilities.slayer.ISlayerCapability;

public class PlayerManager {
    public static void increaseXPUpdate(EntityLivingBase livingBase, float amount){
    if(!livingBase.world.isRemote){
        ISlayerCapability slayer = PlayerDataManager.getSlayer(livingBase);

        if(slayer != null){
            slayer.setXP(Math.min(slayer.getXP() , slayer.getMaxXp()));
        }
        if(livingBase instanceof EntityPlayerMP){
            if(slayer !=null) {
                PlayerDataManager.updateClientSlayer((EntityPlayerMP) livingBase, slayer);
            }
        }
    }
}


    public static void increaseManaUpdater(EntityLivingBase lb, float amount) {
        if (!lb.world.isRemote) {
            ISlayerCapability slayer = PlayerDataManager.getSlayer(lb);

            if (slayer != null) {
                slayer.setMana(slayer.getMana() + amount);
            }
            if (lb instanceof EntityPlayerMP) {
                if (slayer != null) {
                    PlayerDataManager.updateClientSlayer((EntityPlayerMP) lb, slayer);
                }
            }
        }
    }
}
