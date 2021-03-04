package net.init;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.objects.*;

import java.util.ArrayList;
import java.util.List;

import static net.util.handlers.Reference.MODID;


public class ItemInit {
    public static final List<Item> ITEMS;
    public static final List<ToolSword> SWORDS;
    static {
        ITEMS = new ArrayList<>();
        SWORDS = new ArrayList<>();
    }
    //Material
    public static final Item.ToolMaterial TOOL_SCARLET_CRIMSON = EnumHelper.addToolMaterial("tool_scarlet_crimson",3, 0, 8.0F, 3.0F, 10);
    public static final Item.ToolMaterial DILDO = EnumHelper.addToolMaterial("dildo", 999, 0 , 10.0F, 1000000000.0F, 10);
    public static final ItemArmor.ArmorMaterial HAORI = EnumHelper.addArmorMaterial("haori", MODID + "haori", 0, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);

    //Craftables
    public static final Item scarlet_crimson_ingot = new ItemBase("ingot_scarlet_crimson");
    public static final Item katana_wood = new ToolSword("wood_katana", Item.ToolMaterial.WOOD);
    public static final Item katana_base = new ToolSword("base_katana", TOOL_SCARLET_CRIMSON);


    //Swords
    public static final Item mitsuri_sword = new ToolSword("mitsuri" , TOOL_SCARLET_CRIMSON);
    public static final Item zenitsu_katana = new LightningSwords("zenitsu_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item tokito_sword = new ToolSword("tokito" , TOOL_SCARLET_CRIMSON);
    public static final Item katana_poison = new ToolSword("poison_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item katana_blue = new ToolSword("blue_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item katana_ice = new ToolSword("ice_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_tengen = new ToolSword("tengen_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item dildo_sword = new CumBreathingSwords("sword_dildo", DILDO);
    public static final Item hashira_sword = new FireSwords("hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item tanjiro_sword = new ToolSword("tanjiro" , TOOL_SCARLET_CRIMSON);
    public static final Item katana_water = new ToolSword("water_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_mist = new ToolSword("mist_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item katana_lava = new ToolSword("lava_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_fire = new FireSwords("fire_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_kusanagi = new ToolSword("kusanagi" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_lightning = new LightningSwords("lighting_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_moon = new ToolSword("moon_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_sound = new ToolSword("sound_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item kaji_sword = new ToolSword("kajisword" , TOOL_SCARLET_CRIMSON);
    public static final Item inosuke_katana = new ToolSword("inosuke_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item insect_katana = new ToolSword("insect_hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item hashira_wind = new ToolSword("wind_hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_guts = new ToolSword("guts_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item hashira_snake = new ToolSword("snake_hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item hashira_water = new ToolSword("water_hashira", TOOL_SCARLET_CRIMSON);

    //Armor
    public static final Item TAIHUKU_CHEST = new Taihuku_chest(HAORI, 101, EntityEquipmentSlot.CHEST, "taihuku_chest");
    public static final Item TAIHUKU_LEGGINGS = new Taihuku_leggings(HAORI, 102, EntityEquipmentSlot.LEGS, "taihuku_leggings");
    public static final Item TAIHUKU_FEET = new Taihuku_feet(HAORI, 103, EntityEquipmentSlot.FEET, "taihuku_feet");

    //Tokens
    public static final Item slayer_token = new SlayerToken("token_slayer");
    public static final Item demon_token = new DemonToken("token_demon");


}