package fr.minemobs.projects.events;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.init.ItemInit;
import fr.minemobs.projects.tileentity.QuarryTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Bus.FORGE)
public class InteractEvent {
	
	@SubscribeEvent
	public static void interact(PlayerInteractEvent e) {
		PlayerEntity p = e.getPlayer();
		World world = e.getWorld();
	}

}
