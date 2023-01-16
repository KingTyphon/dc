package net.objects;

import net.DemonCraft;
import net.init.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.networking.Client.tech.TechMessage;
import net.networking.Networking;

public class DemonToken extends Item {

    public DemonToken(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DemonCraft.demoncrafttab);
        ItemInit.ITEMS.add(this);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        final ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            int min = 1;
            int max = 16;
            int range = max - min + 1;
            int number = (int) (Math.random() * range) + min;

            if (number == 1) {
                //get the demon style for the user
            }

            Networking.sendToServer(new TechMessage(playerIn));
            Networking.sendTo(new TechMessage((EntityPlayerMP) playerIn), (EntityPlayerMP) playerIn);

            stack.shrink(1);
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}