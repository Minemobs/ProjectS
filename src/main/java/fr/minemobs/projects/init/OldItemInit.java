package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.ProjectMain.ProjectItemGroup;
import fr.minemobs.projects.objects.items.SpecialItem;
import fr.minemobs.projects.util.enums.ModArmorMaterial;
import fr.minemobs.projects.util.enums.ProjectItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Bus.MOD)
@ObjectHolder(ProjectMain.MOD_ID)
public class OldItemInit {
	
	public static final Item project_item = null;
	public static final Item stonks_item = null;
	
	//Tools
	public static final Item obsidian_sword = null;
	public static final Item obsidian_pickaxe = null;
	public static final Item emerald_hoe = null;
	public static final Item obsidian_axe = null;
	public static final Item obsidian_shovel = null;
	
	//armor
	public static final Item obsidian_helmet = null;
	public static final Item obsidian_chestplate = null;
	public static final Item obsidian_leggings = null;
	public static final Item obsidian_boots = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> e) {
		/*/e.getRegistry().register(new Item(new Item.Properties()
				.group(ProjectItemGroup.instance))
				.setRegistryName("project_item"));
		e.getRegistry().register(new Item(new Item.Properties()
				.group(ProjectItemGroup.instance)
				.food(new Food.Builder()
						.fastToEat()
						.hunger(5)
						.saturation(6)
						.setAlwaysEdible()
						.meat()
						.effect(new EffectInstance(Effects.GLOWING, 600, 5), 100f)
						.build()
						))
				.setRegistryName("stonks_item"));
		
		e.getRegistry().register(new SpecialItem(new Item.Properties()
				.group(ProjectItemGroup.instance))
				.setRegistryName("special_item"));
		
		//tools
		//sword
		e.getRegistry().register(new SwordItem(ProjectItemTier.OBSIDIAN, 7, 9.0F, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.rarity(Rarity.EPIC)
				.maxStackSize(1)
				.food(new Food.Builder()
						.fastToEat()
						.hunger(5)
						.saturation(6)
						.setAlwaysEdible()
						.meat()
						.build()
						)
				)
				.setRegistryName("obsidian_sword"));
		
		//pickaxe
		e.getRegistry().register(new PickaxeItem(ProjectItemTier.OBSIDIAN, 4, 5.0F, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.rarity(Rarity.EPIC)
				.maxStackSize(1)
				)
				.setRegistryName("obsidian_pickaxe"));
		
		//axe
		e.getRegistry().register(new AxeItem(ProjectItemTier.OBSIDIAN, 11, 3.0F, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.rarity(Rarity.EPIC)
				.maxStackSize(1)
				)
				.setRegistryName("obsidian_axe"));
		
		//shovel
		e.getRegistry().register(new ShovelItem(ProjectItemTier.OBSIDIAN, 2, 5.0F, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.rarity(Rarity.EPIC)
				.maxStackSize(1)
				)
				.setRegistryName("obsidian_shovel"));
		
		//hoe
		e.getRegistry().register(new HoeItem(ProjectItemTier.EMERALD, 1, 5.0F, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.maxStackSize(1)
				)
				.setRegistryName("emerald_hoe"));
		
		//armor
		//helmet
		e.getRegistry().register(new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD, new Item.Properties()
				.group(ProjectItemGroup.instance))
				.setRegistryName("obsidian_helmet"));
		//chestplate
		e.getRegistry().register(new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST, new Item.Properties()
				.group(ProjectItemGroup.instance))
				.setRegistryName("obsidian_chestplate"));
		//leggings
		e.getRegistry().register(new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS, new Item.Properties()
				.group(ProjectItemGroup.instance))
				.setRegistryName("obsidian_leggings"));
		//boots
		e.getRegistry().register(new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET, new Item.Properties()
				.group(ProjectItemGroup.instance))
				.setRegistryName("obsidian_boots"));/*/
	}
		
}
