package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			ProjectMain.MOD_ID);
	
	public static final Lazy<SoundEvent> SILHOUETTE_NARUTO_OP16 = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(ProjectMain.MOD_ID, "disc.silhouette")));
	
	public static final RegistryObject<SoundEvent> PROMISES_MUSIC = SOUNDS.register("promises_music",
			SILHOUETTE_NARUTO_OP16);
	
}
