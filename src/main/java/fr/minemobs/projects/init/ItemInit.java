package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.ProjectMain.ProjectItemGroup;
import fr.minemobs.projects.objects.items.ModMusicDiscItem;
import fr.minemobs.projects.objects.items.SpecialItem;
import fr.minemobs.projects.util.enums.ModArmorMaterial;
import fr.minemobs.projects.util.enums.ProjectItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectMain.MOD_ID);
	
	public static final RegistryObject<Item> project_item = ITEMS.register("project_item",
			() -> new Item(new Item.Properties().group(ProjectItemGroup.instance)));

	public static final RegistryObject<Item> stonks_item = ITEMS.register("stonks_item",
			() -> new Item(new Item.Properties().group(ProjectItemGroup.instance)
					.food(new Food.Builder()
					.hunger(6)
					.saturation(1.2f)
					.setAlwaysEdible()
					.effect(new EffectInstance(Effects.GLOWING, 60, 5), 50f)
					.build())));

	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
			() -> new SpecialItem(new Item.Properties().group(ProjectItemGroup.instance)));
	
	public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal", () -> new Item(new Item.Properties()
			.group(ProjectItemGroup.instance)
			.maxStackSize(4)
			)
			);
	
	//tools
	//sword
	public static final RegistryObject<SwordItem> obsidian_sword = ITEMS.register("obsidian_sword",
			() -> new SwordItem(ProjectItemTier.OBSIDIAN, 7, 5.0f,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));
	
	//pickaxe
	public static final RegistryObject<PickaxeItem> obsidian_pickaxe = ITEMS.register("obsidian_pickaxe",
			() -> new PickaxeItem(ProjectItemTier.OBSIDIAN, 4, 5.0f,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));
	
	//shovel
	public static final RegistryObject<ShovelItem> obsidian_shovel = ITEMS.register("obsidian_shovel",
			() -> new ShovelItem(ProjectItemTier.OBSIDIAN, 2, 5.0f,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));
	
	//axe
	public static final RegistryObject<AxeItem> obsidian_axe = ITEMS.register("obsidian_axe",
			() -> new AxeItem(ProjectItemTier.OBSIDIAN, 11, 3.0f, new Item.Properties().rarity(Rarity.EPIC).group(ProjectItemGroup.instance)));

	//hoe
	public static final RegistryObject<HoeItem> emerald_hoe = ITEMS.register("emerald_hoe",
			() -> new HoeItem(ProjectItemTier.EMERALD, 5.0f, new Item.Properties().group(ProjectItemGroup.instance)));

	//armor
	//helmet
	public static final RegistryObject<ArmorItem> obsidian_helmet = ITEMS.register("obsidian_helmet",
			() -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));

	//chestplate
	public static final RegistryObject<ArmorItem> obsidian_chestplate = ITEMS.register("obsidian_chestplate",
			() -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));

	//leggings
	public static final RegistryObject<ArmorItem> obsidian_leggings = ITEMS.register("obsidian_leggings",
			() -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.LEGS,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));

	//boots
	public static final RegistryObject<ArmorItem> obsidian_boots = ITEMS.register("obsidian_boots",
			() -> new ArmorItem(ModArmorMaterial.OBSIDIAN, EquipmentSlotType.FEET,
					new Item.Properties().group(ProjectItemGroup.instance).rarity(Rarity.EPIC)));
	
	//seeds
	public static final RegistryObject<Item> STONKS_SEED = ITEMS.register("stonks_seed", () -> new BlockItem(BlockInit.STONKS_CROP.get(), new Item.Properties().group(ProjectItemGroup.instance)));
	
	//disc
	public static final RegistryObject<Item> SILHOUETTE = ITEMS.register("silhouette_disc",
			() -> new ModMusicDiscItem(5, SoundInit.SILHOUETTE_NARUTO_OP16.get(), new Item.Properties()
			.group(ProjectItemGroup.instance).maxStackSize(1).rarity(Rarity.EPIC)));
	
}
