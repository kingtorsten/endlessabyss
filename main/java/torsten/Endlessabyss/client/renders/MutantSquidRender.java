package com.github.kingtorsten.endlessabyss.client.renders;

import com.github.kingtorsten.endlessabyss.EndlessAbyss;
import com.github.kingtorsten.endlessabyss.client.models.MutantSquidModel;
import com.github.kingtorsten.endlessabyss.entities.MutantSquid;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class MutantSquidRender extends LivingRenderer<MutantSquid, MutantSquidModel>
{
	public MutantSquidRender(EntityRendererManager manager)
	{
		super(manager, new MutantSquidModel(), 3f);
	}

	@Override
	protected ResourceLocation getEntityTexture(MutantSquid arg0)
	{
		return EndlessAbyss.RegistryEvents.location("textures/entity/mutant_squid.png");
	}

	public static class RenderFactory implements IRenderFactory<MutantSquid>
	{
	
		@Override
		public EntityRenderer<? super MutantSquid> createRenderFor(EntityRendererManager manager) {
			return new MutantSquidRender(manager);
		}
	}
}
