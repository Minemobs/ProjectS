package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.tileentity.ProjectChestTileEntity;
import fr.minemobs.projects.tileentity.QuarryTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ProjectMain.MOD_ID);
	
	public static final RegistryObject<TileEntityType<QuarryTileEntity>> quarry = TILE_ENTITY_TYPES.register("quarry",
			() -> TileEntityType.Builder.create(QuarryTileEntity::new, OldBlockInit.quarry).build(null));
	
	public static final RegistryObject<TileEntityType<ProjectChestTileEntity>> PROJECT_CHEST = TILE_ENTITY_TYPES
			.register("stonks_chest", () -> TileEntityType.Builder
					.create(ProjectChestTileEntity::new, BlockInit.STONKS_CHEST.get()).build(null));
	
}
