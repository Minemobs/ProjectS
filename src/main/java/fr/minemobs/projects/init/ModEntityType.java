package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.entities.ProjectEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            ProjectMain.MOD_ID);

    public static final RegistryObject<EntityType<ProjectEntity>> PROJECT_ENTITY = ENTITY_TYPES
            .register("project_entity",
                    () -> EntityType.Builder.<ProjectEntity>create(ProjectEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(ProjectMain.MOD_ID, "project_entity").toString()));

}
