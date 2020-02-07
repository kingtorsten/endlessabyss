package com.github.kingtorsten.endlessabyss;

import com.github.kingtorsten.endlessabyss.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EndlessabyssspawneggsItemGroup extends ItemGroup

{
	public EndlessabyssspawneggsItemGroup()
	{
		super("Endlessabyssspawneggs");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemList.mutant_squid_egg);
	}

}
