package com.github.kingtorsten.endlessabyss.client.renders;

import com.github.kingtorsten.endlessabyss.entities.MutantSquid;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry 
{
	public static void registerEntityRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(MutantSquid.class, new MutantSquidRender.RenderFactory());
	}
}
