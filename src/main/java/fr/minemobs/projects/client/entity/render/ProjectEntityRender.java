package fr.minemobs.projects.client.entity.render;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.client.entity.model.ProjectEntityModel;
import fr.minemobs.projects.entities.ProjectEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ProjectEntityRender extends MobRenderer<ProjectEntity, ProjectEntityModel<ProjectEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ProjectMain.MOD_ID, "textures/entity/stonks_entity.png");
	
	public ProjectEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ProjectEntityModel<ProjectEntity>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(ProjectEntity entity) {
		return TEXTURE;
	}
	
}