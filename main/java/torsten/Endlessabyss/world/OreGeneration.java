package torsten.Endlessabyss.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import torsten.Endlessabyss.lists.BlockList;

public class OreGeneration 
{
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			CountRangeConfig titanium_ore_placement = new CountRangeConfig(40, 3, 3, 200);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.titanium_ore.getDefaultState(), 5), new CountRange(), titanium_ore_placement));
		
			CountRangeConfig copper_ore_placement = new CountRangeConfig(60, 3, 3, 200);
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.copper_ore.getDefaultState(), 5), new CountRange(), copper_ore_placement));
		 
		}
	}
}
