package com.github.kingtorsten.endlessabyss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.kingtorsten.endlessabyss.client.renders.RenderRegistry;
import com.github.kingtorsten.endlessabyss.config.Config;
import com.github.kingtorsten.endlessabyss.items.CustomAxeItem;
import com.github.kingtorsten.endlessabyss.items.CustomPickaxeItem;
import com.github.kingtorsten.endlessabyss.lists.ArmorMaterialList;
import com.github.kingtorsten.endlessabyss.lists.BiomeList;
import com.github.kingtorsten.endlessabyss.lists.BlockList;
import com.github.kingtorsten.endlessabyss.lists.EntityList;
import com.github.kingtorsten.endlessabyss.lists.ItemList;
import com.github.kingtorsten.endlessabyss.lists.ToolMaterialList;
import com.github.kingtorsten.endlessabyss.world.AbyssalWorldType;
import com.github.kingtorsten.endlessabyss.world.OreGeneration;
import com.github.kingtorsten.endlessabyss.world.biomes.AbyssalOceanBiome;
import com.github.kingtorsten.endlessabyss.world.biomes.AbyssalRuinsBiome;
import com.github.kingtorsten.endlessabyss.world.biomes.CoralForestBiome;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("endlessabyss")
public class EndlessAbyss
{
    public static EndlessAbyss instance;
    public static final String MODID = "endlessabyss";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup ENDLESSABYSSITEMS = new EndlessabyssitemsItemGroup();
	public static final ItemGroup ENDLESSABYSSBLOCKS = new EndlessabyssblocksItemGroup();
	public static final ItemGroup ENDLESSABYSSTOOLS = new EndlessabysstoolsItemGroup();
	public static final ItemGroup ENDLESSABYSSARMOR = new EndlessabyssarmorItemGroup();
	public static final ItemGroup ENDLESSABYSSSPAWNEGGS = new EndlessabyssspawneggsItemGroup();
	public static final WorldType ABYSSAL_WORLD = new AbyssalWorldType();
    
    public EndlessAbyss()
    {
    	instance = this;
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);  
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);  
    	
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    	
    	Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("EndlessAbyss-client.toml").toString());
    	Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("EndlessAbyss-server.toml").toString());
    	
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
    	OreGeneration.setupOreGeneration();
    	LOGGER.info("Setup method registered.");
    }
    
    private void clientRegistries(final FMLClientSetupEvent event)
    {
    	RenderRegistry.registerEntityRenderers();
    	LOGGER.info("ClientRegistries method registered.");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
    	public static void registerItems(final RegistryEvent.Register<Item> event)  	
    	{
            event.getRegistry().registerAll
            (          
        	        ItemList.titanium_ingot = new Item(new Item.Properties().group(ENDLESSABYSSITEMS)).setRegistryName(location("titanium_ingot")),       	        
        	        ItemList.redstone_crystal = new Item(new Item.Properties().group(ENDLESSABYSSITEMS)).setRegistryName(location("redstone_crystal")),        	        
        	        ItemList.diving_leather = new Item(new Item.Properties().group(ENDLESSABYSSITEMS)).setRegistryName(location("diving_leather")),        	        
        	        ItemList.copper_ingot = new Item(new Item.Properties().group(ENDLESSABYSSITEMS)).setRegistryName(location("copper_ingot")),        	        
        	        ItemList.copper_wire = new Item(new Item.Properties().group(ENDLESSABYSSITEMS)).setRegistryName(location("copper_wire")),
        	        
        	        ItemList.electric_drill = new CustomPickaxeItem(ToolMaterialList.electric, (int) 1.0f, 10.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("electric_drill")),
        	        ItemList.electric_axe = new CustomAxeItem(ToolMaterialList.electric, (int) 1.0f, -3.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("electric_axe")),
        	        ItemList.electric_shovel = new ShovelItem(ToolMaterialList.electric, -2.0f, -3.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("electric_shovel")),
        	        ItemList.electric_hoe = new HoeItem(ToolMaterialList.electric, 10.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("electric_hoe")),
        	        ItemList.electric_knife = new SwordItem(ToolMaterialList.electric, (int) 6.0f, 7.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("electric_knife")),
        	        
                	ItemList.copper_pickaxe = new CustomPickaxeItem(ToolMaterialList.copper, (int) 1.0f, 3.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("copper_pickaxe")),
                    ItemList.copper_axe = new CustomAxeItem(ToolMaterialList.copper, (int) 1.0f, -3.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("copper_axe")),
           	        ItemList.copper_shovel = new ShovelItem(ToolMaterialList.copper, -2.0f, -3.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("copper_shovel")),
         	        ItemList.copper_hoe = new HoeItem(ToolMaterialList.copper, 10.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("copper_hoe")),
                    ItemList.copper_sword = new SwordItem(ToolMaterialList.copper, (int) 6.0f, 7.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("copper_sword")),
                    ItemList.copper_shortsword = new SwordItem(ToolMaterialList.copper, (int) -3.0f, 100.0f, new Item.Properties().group(ENDLESSABYSSTOOLS)).setRegistryName(location("copper_shortsword")),
                    
        	        ItemList.diving_goggles = new ArmorItem(ArmorMaterialList.divingtier1, EquipmentSlotType.HEAD, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("diving_goggles")),
        	        ItemList.wetsuit_chest = new ArmorItem(ArmorMaterialList.divingtier1, EquipmentSlotType.CHEST, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("wetsuit_chest")),
        	        ItemList.wetsuit_leggings = new ArmorItem(ArmorMaterialList.divingtier1, EquipmentSlotType.LEGS, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("wetsuit_leggings")),
        	        ItemList.flippers = new ArmorItem(ArmorMaterialList.divingtier1, EquipmentSlotType.FEET, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("flippers")),     
        	        
        	        ItemList.reinforced_diving_goggles = new ArmorItem(ArmorMaterialList.divingtier2, EquipmentSlotType.HEAD, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("reinforced_diving_goggles")),
                	ItemList.reinforced_wetsuit_chest = new ArmorItem(ArmorMaterialList.divingtier2, EquipmentSlotType.CHEST, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("reinforced_wetsuit_chest")),
                	ItemList.reinforced_wetsuit_leggings = new ArmorItem(ArmorMaterialList.divingtier2, EquipmentSlotType.LEGS, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("reinforced_wetsuit_leggings")),
                	ItemList.reinforced_flippers = new ArmorItem(ArmorMaterialList.divingtier2, EquipmentSlotType.FEET, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("reinforced_flippers")),     
        	        
                	ItemList.copper_helmet = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.HEAD, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("copper_helmet")),
                    ItemList.copper_chestplate = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.CHEST, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("copper_chestplate")),
          	        ItemList.copper_leggings = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.LEGS, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("copper_leggings")),
           	        ItemList.copper_boots = new ArmorItem(ArmorMaterialList.copper, EquipmentSlotType.FEET, new Item.Properties().group(ENDLESSABYSSARMOR)).setRegistryName(location("copper_boots")),     
                	
        	        ItemList.titanium_ore = new BlockItem(BlockList.titanium_ore, new Item.Properties().group(ENDLESSABYSSBLOCKS)).setRegistryName(BlockList.titanium_ore.getRegistryName()),        	       
        	        ItemList.copper_ore = new BlockItem(BlockList.copper_ore, new Item.Properties().group(ENDLESSABYSSBLOCKS)).setRegistryName(BlockList.copper_ore.getRegistryName()),
           	        ItemList.titanium_block = new BlockItem(BlockList.titanium_block, new Item.Properties().group(ENDLESSABYSSBLOCKS)).setRegistryName(BlockList.titanium_block.getRegistryName()),
          	        ItemList.copper_block = new BlockItem(BlockList.copper_block, new Item.Properties().group(ENDLESSABYSSBLOCKS)).setRegistryName(BlockList.copper_block.getRegistryName()),        	        
        	        ItemList.redstone_crystal_ore = new BlockItem(BlockList.redstone_crystal_ore, new Item.Properties().group(ENDLESSABYSSBLOCKS)).setRegistryName(BlockList.redstone_crystal_ore.getRegistryName())
            );
        
            EntityList.registerEntitySpawnEggs(event);
            
            LOGGER.info("Items registered.");
        }
        
        @SubscribeEvent
    	public static void registerBlocks(final RegistryEvent.Register<Block> event)  	
    	{
            event.getRegistry().registerAll
            (          
        	        BlockList.titanium_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("titanium_ore")),	        
        	        BlockList.copper_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("copper_ore")),
        	        BlockList.redstone_crystal_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 3.0f).lightValue(3).sound(SoundType.STONE)).setRegistryName(location("redstone_crystal_ore")),        	
        	        BlockList.titanium_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("titanium_block")),
        	        BlockList.copper_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("copper_block"))   
            		);
        	
            LOGGER.info("Blocks registered.");
        }
        
        @SubscribeEvent
    	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)  	
    	{
        	event.getRegistry().registerAll
        	(
        			EntityList.MUTANT_SQUID
        	);
        	
        	EntityList.registerEntityWorldSpawns();
    	}
        
       // @SubscribeEvent
    	//public static void registerBiomes(final RegistryEvent.Register<Biome> event)  	
    	//{
        	//event.getRegistry().registerAll
        //	(
        		//BiomeList.abyssal_ocean = new AbyssalOceanBiome(),
            //    BiomeList.coral_forest = new CoralForestBiome(),
          //      BiomeList.abyssal_ruins = new AbyssalRuinsBiome()
        //	);
        	
        	//BiomeList.registerBiomes();
   		//}
        
        public static ResourceLocation location(String name)
        {
        	return new ResourceLocation(MODID, name);
        }
    }
}