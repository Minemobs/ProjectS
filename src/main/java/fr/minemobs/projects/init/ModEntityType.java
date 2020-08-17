package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.entities.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
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
    
    public static final RegistryObject<EntityType<CrystalEntity>> CRYSTAL_ENTITY = ENTITY_TYPES
            .register("crystal_entity",
                    () -> EntityType.Builder.<CrystalEntity>create(CrystalEntity::new, EntityClassification.MISC)
                    .size(0.25F, 0.25F)
                    .build(new ResourceLocation(ProjectMain.MOD_ID, "crystal").toString()));

    
}
