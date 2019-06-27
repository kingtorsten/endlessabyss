package com.github.kingtorsten.endlessabyss;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import torsten.Endlessabyss.items.ItemCustomAxe;
import torsten.Endlessabyss.items.ItemCustomPickaxe;
import torsten.Endlessabyss.lists.BlockList;
import torsten.Endlessabyss.lists.ItemList;
import torsten.Endlessabyss.lists.ToolMaterialList;
import torsten.Endlessabyss.world.OreGeneration;
import torsten.Endlessabyss.lists.ArmorMaterialList;

@Mod("endlessabyss")
public class EndlessAbyss
{
    public static EndlessAbyss instance;
    public static final String modid = "endlessabyss";
    private static final Logger logger = LogManager.getLogger(modid);

	public static final ItemGroup endlessabyssitems = new EndlessabyssitemsItemGroup();
	public static final ItemGroup endlessabyssblocks = new EndlessabyssblocksItemGroup();
	public static final ItemGroup endlessabysstools = new EndlessabysstoolsItemGroup();
	public static final ItemGroup endlessabyssarmor = new EndlessabyssarmorItemGroup();
    
    public EndlessAbyss()
    {
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    	
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
    	OreGeneration.setupOreGeneration();
    	logger.info("Setup method registered.");
    }
    
    private void clientRegistries(final FMLClientSetupEvent event)
    {
    	logger.info("ClientRegistries method registered.");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
    	public static void registerItems(final RegistryEvent.Register<Item> event)  	
    	{
            event.getRegistry().registerAll
            (          
        	        ItemList.titanium_ingot = new Item(new Item.Properties().group(endlessabyssitems)).setRegistryName(location("titanium_ingot")),
        	        
        	        ItemList.redstone_crystal = new Item(new Item.Properties().group(endlessabyssitems)).setRegistryName(location("redstone_crystal")),
        	        
        	        ItemList.diving_leather = new Item(new Item.Properties().group(endlessabyssitems)).setRegistryName(location("diving_leather")),
        	        
        	        ItemList.copper_ingot = new Item(new Item.Properties().group(endlessabyssitems)).setRegistryName(location("copper_ingot")),
        	        
        	        ItemList.copper_wire = new Item(new Item.Properties().group(endlessabyssitems)).setRegistryName(location("copper_wire")),
        	        
        	        ItemList.electric_drill = new ItemCustomPickaxe(ToolMaterialList.electric, (int) 1.0f, 10.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("electric_drill")),
        	        ItemList.electric_axe = new ItemCustomAxe(ToolMaterialList.electric, (int) 1.0f, -3.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("electric_axe")),
        	        ItemList.electric_shovel = new ItemSpade(ToolMaterialList.electric, -2.0f, -3.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("electric_shovel")),
        	        ItemList.electric_hoe = new ItemHoe(ToolMaterialList.electric, 10.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("electric_hoe")),
        	        ItemList.electric_knife = new ItemSword(ToolMaterialList.electric, (int) 6.0f, 7.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("electric_knife")),
        	        
                	ItemList.copper_pickaxe = new ItemCustomPickaxe(ToolMaterialList.copper, (int) 1.0f, 3.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("copper_pickaxe")),
                    ItemList.copper_axe = new ItemCustomAxe(ToolMaterialList.copper, (int) 1.0f, -3.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("copper_axe")),
           	        ItemList.copper_shovel = new ItemSpade(ToolMaterialList.copper, -2.0f, -3.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("copper_shovel")),
         	        ItemList.copper_hoe = new ItemHoe(ToolMaterialList.copper, 10.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("copper_hoe")),
                    ItemList.copper_sword = new ItemSword(ToolMaterialList.copper, (int) 6.0f, 7.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("copper_sword")),
                    ItemList.copper_shortsword = new ItemSword(ToolMaterialList.copper, (int) -10.0f, -10.0f, new Item.Properties().group(endlessabysstools)).setRegistryName(location("copper_shortsword")),
                    
        	        ItemList.diving_goggles = new ItemArmor(ArmorMaterialList.divingtier1, EntityEquipmentSlot.HEAD, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("diving_goggles")),
        	        ItemList.wetsuit_chest = new ItemArmor(ArmorMaterialList.divingtier1, EntityEquipmentSlot.CHEST, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("wetsuit_chest")),
        	        ItemList.wetsuit_leggings = new ItemArmor(ArmorMaterialList.divingtier1, EntityEquipmentSlot.LEGS, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("wetsuit_leggings")),
        	        ItemList.flippers = new ItemArmor(ArmorMaterialList.divingtier1, EntityEquipmentSlot.FEET, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("flippers")),     
        	        
        	        ItemList.reinforced_diving_goggles = new ItemArmor(ArmorMaterialList.divingtier2, EntityEquipmentSlot.HEAD, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("reinforced_diving_goggles")),
                	ItemList.reinforced_wetsuit_chest = new ItemArmor(ArmorMaterialList.divingtier2, EntityEquipmentSlot.CHEST, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("reinforced_wetsuit_chest")),
                	ItemList.reinforced_wetsuit_leggings = new ItemArmor(ArmorMaterialList.divingtier2, EntityEquipmentSlot.LEGS, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("reinforced_wetsuit_leggings")),
                	ItemList.reinforced_flippers = new ItemArmor(ArmorMaterialList.divingtier2, EntityEquipmentSlot.FEET, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("reinforced_flippers")),     
        	        
                	ItemList.copper_helmet = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.HEAD, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("copper_boots")),
                    ItemList.copper_chestplate = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.CHEST, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("copper_chestplate")),
          	        ItemList.copper_leggings = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.LEGS, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("copper_leggings")),
           	        ItemList.copper_boots = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.FEET, new Item.Properties().group(endlessabyssarmor)).setRegistryName(location("copper_boots")),     
                	
        	        ItemList.titanium_ore = new ItemBlock(BlockList.titanium_ore, new Item.Properties().group(endlessabyssblocks)).setRegistryName(BlockList.titanium_ore.getRegistryName()),
        	       
        	        ItemList.copper_ore = new ItemBlock(BlockList.copper_ore, new Item.Properties().group(endlessabyssblocks)).setRegistryName(BlockList.copper_ore.getRegistryName()),
        	        
        	        ItemList.titanium_block = new ItemBlock(BlockList.titanium_block, new Item.Properties().group(endlessabyssblocks)).setRegistryName(BlockList.titanium_block.getRegistryName()),
        	        
        	        ItemList.copper_block = new ItemBlock(BlockList.copper_block, new Item.Properties().group(endlessabyssblocks)).setRegistryName(BlockList.copper_block.getRegistryName()),
        	        
        	        ItemList.redstone_crystal_ore = new ItemBlock(BlockList.redstone_crystal_ore, new Item.Properties().group(endlessabyssblocks)).setRegistryName(BlockList.redstone_crystal_ore.getRegistryName())
            );
        
            logger.info("Items registered.");
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
        	
            logger.info("Blocks registered.");
        }
        
        private static ResourceLocation location(String name)
        {
        	return new ResourceLocation(modid, name);
        }
    }
}