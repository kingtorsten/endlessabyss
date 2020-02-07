package com.github.kingtorsten.endlessabyss.world;

import com.github.kingtorsten.endlessabyss.lists.BiomeList;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class AbyssalWorldType extends WorldType
{
	public AbyssalWorldType() {

		super("abyssal_world");

	}


	@Override
	public ChunkGenerator<?> createChunkGenerator(World world)
	{
		OverworldGenSettings settings = new OverworldGenSettings();
		SingleBiomeProviderSettings single = new SingleBiomeProviderSettings();
		single.setBiome(BiomeList.abyssal_ocean);
		return new OverworldChunkGenerator(world, new SingleBiomeProvider(single), settings);
	}
}