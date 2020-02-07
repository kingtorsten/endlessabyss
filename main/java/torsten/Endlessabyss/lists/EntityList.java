package com.github.kingtorsten.endlessabyss.lists;

import com.github.kingtorsten.endlessabyss.EndlessAbyss;
import com.github.kingtorsten.endlessabyss.entities.MutantSquid;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class EntityList 
{
	public static EntityType<?> MUTANT_SQUID = EntityType.Builder.create((p_220323_0_, p_220323_1_) -> {
        return null;
     }, EntityClassification.WATER_CREATURE).build(EndlessAbyss.MODID + ":mutant_squid").setRegistryName(EndlessAbyss.RegistryEvents.location("mutant_squid"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
				ItemList.mutant_squid_egg = registerEntitySpawnEgg(MUTANT_SQUID, 0x1c52c7, 0xf54242, "mutant_squid_egg")
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(MUTANT_SQUID, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_WARM_OCEAN);
	}
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(EndlessAbyss.ENDLESSABYSSSPAWNEGGS));
		item.setRegistryName(EndlessAbyss.RegistryEvents.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 1));
			}
		}
	}
}