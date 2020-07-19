package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.container.ProjectChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS,
			ProjectMain.MOD_ID);

	public static final RegistryObject<ContainerType<ProjectChestContainer>> EXAMPLE_CHEST = CONTAINER_TYPES
			.register("stonks_chest", () -> IForgeContainerType.create(ProjectChestContainer::new));
}
