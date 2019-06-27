package com.github.kingtorsten.endlessabyss;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import torsten.Endlessabyss.lists.ItemList;

public class EndlessabyssarmorItemGroup extends ItemGroup
{
	public EndlessabyssarmorItemGroup()
	{
		super("endlessabyssarmor");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemList.diving_goggles);
	}

}

