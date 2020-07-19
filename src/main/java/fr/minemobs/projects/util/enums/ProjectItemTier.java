package fr.minemobs.projects.util.enums;

import java.util.function.Supplier;

import fr.minemobs.projects.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ProjectItemTier implements IItemTier{
	OBSIDIAN(6, 8124, 11.0F, 6.0F, 40, () -> {
		return Ingredient.fromItems(ItemInit.project_item.get());
	}),
	
	EMERALD(5, 4062, 10.0F, 5.0F, 31, () -> {
		return Ingredient.fromItems(ItemInit.stonks_item.get());
	});
	
	   private final int harvestLevel;
	   private final int maxUses;
	   private final float efficiency;
	   private final float attackDamage;
	   private final int enchantability;
	   private final LazyValue<Ingredient> repairMaterial;

	ProjectItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
	      this.harvestLevel = harvestLevelIn;
	      this.maxUses = maxUsesIn;
	      this.efficiency = efficiencyIn;
	      this.attackDamage = attackDamageIn;
	      this.enchantability = enchantabilityIn;
	      this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}
	
	   public int getMaxUses() {
		      return this.maxUses;
		   }

		   public float getEfficiency() {
		      return this.efficiency;
		   }

		   public float getAttackDamage() {
		      return this.attackDamage;
		   }

		   public int getHarvestLevel() {
		      return this.harvestLevel;
		   }

		   public int getEnchantability() {
		      return this.enchantability;
		   }

		   public Ingredient getRepairMaterial() {
		      return this.repairMaterial.getValue();
		   }
}