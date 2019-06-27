package torsten.Endlessabyss.lists;

import com.github.kingtorsten.endlessabyss.EndlessAbyss;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	divingtier1("divingtier1", 50, new int[] {1, 2, 2, 1}, 10, ItemList.diving_leather, "entity.tropical_fish.flop", 0.0f),
	
	divingtier2("divingtier2", 50, new int[] {22, 30, 26, 20}, 10, ItemList.titanium_ingot, "entity.tropical_fish.flop", 0.0f),
	
	copper("copper", 50, new int[] {11, 15, 13, 10}, 30, ItemList.copper_ingot, "entity.tropical_fish.flop", 0.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, EquipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmount;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipSound, float toughness)
	{
		this.name = name;
		this.EquipSound = EquipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmount = damageReductionAmount;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EntityEquipmentSlot slot) 
	{
		return this.damageReductionAmount[slot.getIndex()];
	}

	@Override
	public int getDurability(EntityEquipmentSlot slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return EndlessAbyss.modid + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(EquipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}
