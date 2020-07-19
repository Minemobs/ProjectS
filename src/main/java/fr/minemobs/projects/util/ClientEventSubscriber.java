package fr.minemobs.projects.util;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.client.gui.StonksChestScreen;
import fr.minemobs.projects.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){
        ScreenManager.registerFactory(ModContainerTypes.EXEMPLE_CHEST.get(), StonksChestScreen::new);
    }
}
