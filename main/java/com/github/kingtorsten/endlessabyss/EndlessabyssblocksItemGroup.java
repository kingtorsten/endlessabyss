package com.github.kingtorsten.endlessabyss;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import torsten.Endlessabyss.lists.BlockList;

public class EndlessabyssblocksItemGroup extends ItemGroup
{
	public EndlessabyssblocksItemGroup()
	{
		super("endlessabyssblocks");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(BlockList.titanium_block);
	}

}
