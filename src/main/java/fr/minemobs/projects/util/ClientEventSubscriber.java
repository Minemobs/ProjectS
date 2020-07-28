package fr.minemobs.projects.util;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.client.entity.render.ProjectEntityRender;
import fr.minemobs.projects.client.gui.StonksChestScreen;
import fr.minemobs.projects.init.BlockInit;
import fr.minemobs.projects.init.ModContainerTypes;
import fr.minemobs.projects.init.ModEntityType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){
        ScreenManager.registerFactory(ModContainerTypes.EXAMPLE_CHEST.get(), StonksChestScreen::new);
        RenderTypeLookup.setRenderLayer(BlockInit.STONKS_CROP.get(), RenderType.getCutoutMipped());
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.PROJECT_ENTITY.get(), ProjectEntityRender::new);
    }
}
