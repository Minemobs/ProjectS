package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.enchantments.ExplosionEnchant;
import fr.minemobs.projects.enchantments.ObsidianEnchant;
import fr.minemobs.projects.enchantments.UpstepEnchantment;
import net.minecraft.enchantment.*;
import net.minecraft.enchantment.Enchantment.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit {
	
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, ProjectMain.MOD_ID);
    
    public static final RegistryObject<Enchantment> UPSTEP = ENCHANTMENTS.register("upstep", () -> new UpstepEnchantment(Rarity.COMMON, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[] {
    		EquipmentSlotType.FEET
    }));
    
    public static final RegistryObject<Enchantment> OBSIDIAN = ENCHANTMENTS.register("obsidian", () -> new ObsidianEnchant(Rarity.RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[] {
    		EquipmentSlotType.FEET
    }));
    
    public static final RegistryObject<Enchantment> EXPLOSION = ENCHANTMENTS.register("explosion", () -> new ExplosionEnchant(Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[] {
    		EquipmentSlotType.MAINHAND
    }));

}
