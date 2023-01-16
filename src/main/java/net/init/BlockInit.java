package net.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.objects.ToolSword;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS;
    static {
        BLOCKS = new ArrayList<>();

    }
    //public static final Block wood_building = new Wood("mitsuri" , TOOL_SCARLET_CRIMSON);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll((Block) BLOCKS);

    }
}
