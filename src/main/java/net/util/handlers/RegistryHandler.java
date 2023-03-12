package net.util.handlers;

import net.DemonCraft;
import net.entity.Kyogai.KyogaiEntity;
import net.init.BlockInit;
import net.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.recipes.CraftingRecipes;

@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            DemonCraft.proxy.registerItemRenderer(item, 0, "inventory");
        }
        for(Block block : BlockInit.BLOCKS){
            DemonCraft.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }

    @Mod.EventHandler
    public static void preInitRegistries(){

    }

    @Mod.EventHandler
    public static void initRegistries()
    {
        SoundHandler.registerSounds();
        CraftingRecipes.init();
    }
}