package net.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.objects.blocks.BlockWoodenBuilding;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block WOOD_BUILDING = new BlockWoodenBuilding("wood_building", Material.WOOD);

}
