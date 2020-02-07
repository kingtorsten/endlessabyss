package com.github.kingtorsten.endlessabyss.lists;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeList 
{
	public static Biome abyssal_ocean;
	public static Biome abyssal_ruins;
	public static Biome coral_forest;
	
	public static void registerBiomes()
	{
		registerBiome(abyssal_ocean, Type.OCEAN, Type.HOT);
		registerBiome(abyssal_ruins, Type.OCEAN, Type.HOT);
		registerBiome(coral_forest, Type.OCEAN, Type.HOT);
	}
	
	public static void registerBiome(Biome biome, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
