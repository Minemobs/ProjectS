package fr.minemobs.projects.util;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.init.*;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(ProjectMain.EXAMPLE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(ProjectMain.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null,
                    true);
        }
        ProjectMain.LOGGER.info("Dimensions Registered!");
    }

}
