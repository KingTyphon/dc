package net.networking.messages;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.networking.messages.PlayerDataManager;
import net.util.capabilities.slayer.ISlayerCapability;

public class PlayerManager {
    public static void increaseXPUpdate(EntityLivingBase livingBase, int amount){
        ISlayerCapability slayer = PlayerDataManager.getSlayer(livingBase);
        int maxXp = slayer.getMaxXp();
        int xpNew=(slayer.getXP() + amount);
        if(maxXp == 0 ){
            slayer.setMaxXp((slayer.getLevel() * 150)+100);
        }
        if(slayer != null && maxXp != 0){

            slayer.setXP(Math.min(xpNew, maxXp));
        }
        if(livingBase instanceof EntityPlayerMP){
            if(slayer !=null) {
                PlayerDataManager.updateClientSlayer((EntityPlayerMP) livingBase, slayer);
            }
        }

}


    public static void increaseManaUpdater(EntityLivingBase lb, float amount) {
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
