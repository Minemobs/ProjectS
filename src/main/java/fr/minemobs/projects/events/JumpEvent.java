package fr.minemobs.projects.events;

import fr.minemobs.projects.ProjectMain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Bus.FORGE)
public class JumpEvent {
	
	@SubscribeEvent
	public static void jumpEvent(LivingJumpEvent e) {
		LivingEntity livingEntity = e.getEntityLiving();
		World world = livingEntity.getEntityWorld();
	}
	
}
