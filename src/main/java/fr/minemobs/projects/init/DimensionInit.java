package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.world.dimension.ProjectModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {

    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, ProjectMain.MOD_ID);

    public static final RegistryObject<ModDimension> EXAMPLE_DIM = MOD_DIMENSIONS.register("project_dim", () -> new ProjectModDimension());

}
