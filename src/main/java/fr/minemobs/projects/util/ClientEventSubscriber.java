package fr.minemobs.projects.util;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.client.entity.render.ProjectEntityRender;
import fr.minemobs.projects.client.gui.ItemPedestalScreen;
import fr.minemobs.projects.client.gui.StonksChestScreen;
import fr.minemobs.projects.client.tileentity.renderer.ItemPedestalRenderer;
import fr.minemobs.projects.init.ItemInit;
import fr.minemobs.projects.init.ModContainerTypes;
import fr.minemobs.projects.init.ModEntityType;
import fr.minemobs.projects.init.ModTileEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){
        ScreenManager.registerFactory(ModContainerTypes.EXAMPLE_CHEST.get(), StonksChestScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.ITEM_PEDESTAL.get(), ItemPedestalScreen::new);
		/*/RenderTypeLookup.setRenderLayer(BlockInit.STONKS_CROP.get(), RenderType.getCutoutMipped());/*/
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ITEM_PEDESTAL.get(), ItemPedestalRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.PROJECT_ENTITY.get(), ProjectEntityRender::new);
        
        ItemInit.CRYSTAL.get().addPropertyOverride(new ResourceLocation(ProjectMain.MOD_ID, "count"), new IItemPropertyGetter() {
			
			@Override
			public float call(ItemStack stack, World worldIn, LivingEntity entityIn) {
				switch (stack.getCount()) {
				case 1:
					return 0.25f;
					
				case 2:
					return 0.5f;
					
				case 3:
					return 0.75f;
					
				case 4:
					return 1.0f;

				default:
					return 0.0f;
				}
			}
		});
    }
}
