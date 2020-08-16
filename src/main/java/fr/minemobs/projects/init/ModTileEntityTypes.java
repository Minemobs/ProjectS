package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.tileentity.ItemPedestalTileEntity;
import fr.minemobs.projects.tileentity.ProjectChestTileEntity;
import fr.minemobs.projects.tileentity.QuarryTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, ProjectMain.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry",
			() -> TileEntityType.Builder.create(QuarryTileEntity::new, BlockInit.QUARRY.get()).build(null));

	public static final RegistryObject<TileEntityType<ProjectChestTileEntity>> EXAMPLE_CHEST = TILE_ENTITY_TYPES
			.register("stonks_chest", () -> TileEntityType.Builder
					.create(ProjectChestTileEntity::new, BlockInit.STONKS_CHEST.get()).build(null));
	
	public static final RegistryObject<TileEntityType<ItemPedestalTileEntity>> ITEM_PEDESTAL = TILE_ENTITY_TYPES
			.register("item_pedestal", () -> TileEntityType.Builder
					.create(ItemPedestalTileEntity::new, BlockInit.ITEM_PEDESTAL.get()).build(null));
}
