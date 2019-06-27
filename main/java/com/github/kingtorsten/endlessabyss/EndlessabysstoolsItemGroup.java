package com.github.kingtorsten.endlessabyss;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import torsten.Endlessabyss.lists.ItemList;

public class EndlessabysstoolsItemGroup extends ItemGroup

{
	public EndlessabysstoolsItemGroup()
	{
		super("endlessabysstools");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemList.electric_drill);
	}

}
