package fr.minemobs.projects.init;


import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.ProjectMain.ProjectItemGroup;
import fr.minemobs.projects.objects.blocks.BlockQuarry;
import fr.minemobs.projects.objects.blocks.Specalblock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Bus.MOD)
@ObjectHolder(ProjectMain.MOD_ID)
public class OldBlockInit {
	
	public static final Block project_block = null;
	public static final Block specal_block = null;
	public static final Block quarry = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		/*/event.getRegistry()
		.register(new Block(
				Block.Properties
				.create(Material.IRON)
				.harvestTool(ToolType.PICKAXE)
				.hardnessAndResistance(0.5f, 15.0f)
				.sound(SoundType.METAL))
				.setRegistryName("project_block")
				);
		
		event.getRegistry().
		register(new Specalblock(Block.Properties
				.create(Material.IRON)
				.hardnessAndResistance(2.0F, 10.0F)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.GLASS)
				.slipperiness(1.2F)
				.speedFactor(0.7f)
				.noDrops()
				)
				.setRegistryName("specal_block")
				);
		
		event.getRegistry().register(new BlockQuarry(Block.Properties.create(Material.IRON))
				.setRegistryName("quarry"));/*/
	}
	
	@SubscribeEvent
	public static void registerItemsBlocks(final RegistryEvent.Register<Item> e) {
	/*/	e.getRegistry().register(new BlockItem(project_block, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.maxStackSize(64)).setRegistryName("project_block"));
		
		e.getRegistry().register(new BlockItem(specal_block, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.maxStackSize(64)).setRegistryName("specal_block"));
		
		e.getRegistry().register(new BlockItem(quarry, new Item.Properties()
				.group(ProjectItemGroup.instance)
				.maxStackSize(64)).setRegistryName("quarry"));/*/
		
	}
	
}
