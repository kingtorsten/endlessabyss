package com.github.kingtorsten.endlessabyss.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig 
{
    public static ForgeConfigSpec.IntValue endlessabyss_copper_chance;
    public static ForgeConfigSpec.BooleanValue generate_overworld;
    public static ForgeConfigSpec.IntValue endlessabyss_titanium_chance;
    public static ForgeConfigSpec.IntValue endlessabyss_redstone_crystal_chance;
    public static ForgeConfigSpec.BooleanValue generate_nether;
    
    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
    	server.comment("Oregen Config");
    	
    	endlessabyss_copper_chance = server
    			.comment("Maximum number of ore vein that can spawn in one chunk.")
    			.defineInRange("Oregen.endlessabyss_copper_chance", 30, 20, 50);
    	
    	endlessabyss_titanium_chance = server
    			.comment("Maximum number of ore vein that can spawn in one chunk.")
    			.defineInRange("Oregen.endlessabyss_titanium_chance", 20, 10, 35);
    	
    	endlessabyss_redstone_crystal_chance = server
    			.comment("Maximum number of ore vein that can spawn in one chunk.")
    			.defineInRange("Oregen.endlessabyss_redstone_crystal_chance", 10, 1, 30);
    	
    	generate_overworld = server
    			.comment("Decide if you want overworld ores from the endless abyss to spawn")
    			.define("Oregen.generate_overworld", true);
    	
    	generate_nether = server
    			.comment("Decide if you want nether ores from the endless abyss to spawn")
    			.define("Oregen.generate_nether", true);
    }
}
