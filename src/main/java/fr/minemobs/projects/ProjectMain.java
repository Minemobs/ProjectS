package fr.minemobs.projects;

import fr.minemobs.projects.init.*;
import fr.minemobs.projects.objects.blocks.StonksCrop;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("projects")
@Mod.EventBusSubscriber(modid = "projects", bus = Bus.MOD)
public class ProjectMain {
	
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "projects";
    public static ProjectMain instance;

	public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(MOD_ID, "project");
    
    public ProjectMain() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	
    	ItemInit.ITEMS.register(modEventBus);
    	BlockInit.BLOCKS.register(modEventBus);
    	ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
    	ModEntityType.ENTITY_TYPES.register(modEventBus);
    	EnchantmentInit.ENCHANTMENTS.register(modEventBus);
    	FluidInit.FLUIDS.register(modEventBus);
    	SoundInit.SOUNDS.register(modEventBus);
    	
		BiomeInit.BIOMES.register(modEventBus);
		DimensionInit.MOD_DIMENSIONS.register(modEventBus);
    	
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        
    }
    
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof StonksCrop) && !(block.get() instanceof FlowingFluidBlock)).map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(ProjectItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		LOGGER.debug("Registered BlockItems!");
	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> e) {
		BiomeInit.registerBiomes();
	}
    
    private void setup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    	
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
	public void onClientSetup(FMLClientSetupEvent e){

	}
        
    public static class ProjectItemGroup extends ItemGroup {

    	public static final ProjectItemGroup instance = new ProjectItemGroup(ItemGroup.GROUPS.length, "Project S");
		private ProjectItemGroup(int index, String label) {
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ItemInit.stonks_item.get());
		}
    	
    }
    
}
