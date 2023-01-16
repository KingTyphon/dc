package net.init;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.objects.*;
import net.objects.foods.Ramen;
import net.objects.foods.Sushi;
import net.objects.swords.CumBreathingSwords;
import net.objects.swords.FireSwords;
import net.objects.swords.LightningSwords;
import net.objects.swords.ShadowSwords;
import net.util.handlers.Reference;

import java.util.ArrayList;
import java.util.List;


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
    public static final ItemArmor.ArmorMaterial HAORI = EnumHelper.addArmorMaterial("haori", Reference.MODID + "haori", 0, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);

    //Craftables
    public static final Item scarlet_crimson_ingot = new ItemBase("ingot_scarlet_crimson");
    public static final Item katana_wood = new ToolSword("wood_katana", Item.ToolMaterial.WOOD);
    public static final Item katana_base = new ToolSword("base_katana", TOOL_SCARLET_CRIMSON);


    //Swords
    public static final Item mitsuri_sword = new ToolSword("mitsuri" , TOOL_SCARLET_CRIMSON);
    public static final Item zenitsu_katana = new LightningSwords("zenitsu_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item tokito_sword = new ToolSword("tokito" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_tengen = new ToolSword("tengen_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item dildo_sword = new CumBreathingSwords("sword_dildo", DILDO);
    public static final Item hashira_sword = new FireSwords("hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item tanjiro_sword = new ToolSword("tanjiro" , TOOL_SCARLET_CRIMSON);
    public static final Item katana_water = new ToolSword("water_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_mist = new ToolSword("mist_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_fire = new FireSwords("fire_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_kusanagi = new ToolSword("kusanagi" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_lightning = new LightningSwords("lighting_blade" , TOOL_SCARLET_CRIMSON);
    public static final Item blade_moon = new ToolSword("moon_katana" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_sound = new ToolSword("sound_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item kaji_sword = new ShadowSwords("kajisword" , TOOL_SCARLET_CRIMSON);
    public static final Item inosuke_katana = new ToolSword("inosuke_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item insect_katana = new ToolSword("insect_hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item hashira_wind = new ToolSword("wind_hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item sword_guts = new ToolSword("guts_sword" , TOOL_SCARLET_CRIMSON);
    public static final Item hashira_snake = new ToolSword("snake_hashira" , TOOL_SCARLET_CRIMSON);
    public static final Item hashira_water = new ToolSword("water_hashira", TOOL_SCARLET_CRIMSON);
    public static final Item love_sword = new ToolSword("generic_love", TOOL_SCARLET_CRIMSON);
    public static final Item sword2_flame = new FireSwords("flame_sword2", TOOL_SCARLET_CRIMSON);
    public static final Item sword_flower = new ToolSword("flower_sword", TOOL_SCARLET_CRIMSON);
    public static final Item water_generic = new ToolSword("generic_water2", TOOL_SCARLET_CRIMSON);
    public static final Item wind_generic2 = new ToolSword("generic_wind2", TOOL_SCARLET_CRIMSON);
    public static final Item generic_insect = new ToolSword("insect_generic", TOOL_SCARLET_CRIMSON);
    public static final Item generic2_love = new ToolSword("love_generic2", TOOL_SCARLET_CRIMSON);
    public static final Item love_sword3 = new ToolSword("love_sword3", TOOL_SCARLET_CRIMSON);
    public static final Item mist_sword2 = new ToolSword("mist_sword2", TOOL_SCARLET_CRIMSON);
    public static final Item serpent_generic = new ToolSword("serpent_generic", TOOL_SCARLET_CRIMSON);
    public static final Item snake_sword = new ToolSword("snake_sword", TOOL_SCARLET_CRIMSON);
    public static final Item stone_hashira = new ToolSword("stone_hashira", TOOL_SCARLET_CRIMSON);
    public static final Item sun_generic = new ToolSword("sun_generic", TOOL_SCARLET_CRIMSON);
    public static final Item thunder_generic = new LightningSwords("thunder_generic", TOOL_SCARLET_CRIMSON);
    public static final Item wind_generic = new ToolSword("wind_generic", TOOL_SCARLET_CRIMSON);
    public static final Item zk_sword = new ToolSword("zk_sword", TOOL_SCARLET_CRIMSON);
    public static final Item gold_coin = new ItemBase("gold_coin");
    public static final Item silver_coin = new ItemBase("silver_coin");
    public static final Item bronze_coin = new ItemBase("bronze_coin");

    //Food
    public static final Item raw_sushi = new Sushi("sushi", 2, true);
    public static final Item ramen = new Ramen("ramen", 4, false);

    //Drinks
    //public static final Item beer = new Beer("beer");

    //Armor(Temp Not Registered)
    public static final Item TANJIRO_EARRING = new Tanjuro_earring(HAORI, 104, EntityEquipmentSlot.HEAD, "earring");
    public static final Item TAIHUKU_CHEST = new Taihuku_chest(HAORI, 101, EntityEquipmentSlot.CHEST, "slayer_chest");
    public static final Item TAIHUKU_LEGGINGS = new Taihuku_leggings(HAORI, 102, EntityEquipmentSlot.LEGS, "slayer_pants");
    public static final Item TAIHUKU_FEET = new Taihuku_feet(HAORI, 103, EntityEquipmentSlot.FEET, "slayer_feet");

    //Tokens
    public static final Item slayer_token = new SlayerToken("token_slayer");
    public static final Item demon_token = new DemonToken("token_demon");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll((Item) ITEMS);
        event.getRegistry().registerAll((Item) SWORDS);
    }
}