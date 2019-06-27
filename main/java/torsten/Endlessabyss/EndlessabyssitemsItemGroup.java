package torsten.Endlessabyss;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import torsten.Endlessabyss.lists.ItemList;

public class EndlessabyssitemsItemGroup extends ItemGroup
{
	public EndlessabyssitemsItemGroup()
	{
		super("endlessabyssitems");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemList.titanium_ingot);
	}

}
