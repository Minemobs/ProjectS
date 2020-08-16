package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.objects.blocks.BlockQuarry;
import fr.minemobs.projects.objects.blocks.ItemPedestalBlock;
import fr.minemobs.projects.objects.blocks.LanternBlock;
import fr.minemobs.projects.objects.blocks.LavaSpongeBlock;
import fr.minemobs.projects.objects.blocks.ModPressurePlateBlock;
import fr.minemobs.projects.objects.blocks.ModWoodButtonBlock;
import fr.minemobs.projects.objects.blocks.OakDoor;
import fr.minemobs.projects.objects.blocks.ProjectChestBlock;
import fr.minemobs.projects.objects.blocks.Specalblock;
import fr.minemobs.projects.objects.blocks.StonksCrop;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	// Blocks
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ProjectMain.MOD_ID);
	
	public static final RegistryObject<Block> project_block = BLOCKS.register("project_block", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.METAL).slipperiness(4)));
	
	public static final RegistryObject<Block> lava_sponge = BLOCKS.register("lava_sponge", () -> new LavaSpongeBlock(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.METAL)));

	/*/public static final RegistryObject<Block> SPECAL_BLOCK = BLOCKS.register("specal_block",
			() -> new Specalblock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).slipperiness(1.2f).speedFactor(0.7f).noDrops()));/*/

	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry",
			() -> new BlockQuarry(Block.Properties.create(Material.IRON)));

	public static final RegistryObject<Block> STONKS_CHEST = BLOCKS.register("stonks_chest",
			() -> new ProjectChestBlock(Block.Properties.from(BlockInit.project_block.get())));

	/*/public static final RegistryObject<Block> stonks_stairs = BLOCKS.register("stonks_stairs",
			() -> new StairsBlock(() -> BlockInit.project_block.get().getDefaultState(),
					Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	
	public static final RegistryObject<Block> STONKS_FENCE = BLOCKS.register("stonks_fence", () -> new FenceBlock(Block.Properties.
			create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(5f, 20f)
			.sound(SoundType.METAL)
			));/*/
	
	public static final RegistryObject<Block> ITEM_PEDESTAL = BLOCKS.register("item_pedestal", () -> new ItemPedestalBlock(
			Block.Properties.from(Blocks.COBBLESTONE)));
	
	
	//todo models / blockstates / textures
	
	/*/public static final RegistryObject<Block> STONKS_FENCE_GATE = BLOCKS.register("stonks_fence_gate", () -> new FenceGateBlock(Block.Properties.
			create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(5f, 20f)
			.sound(SoundType.METAL)
			));
	
	public static final RegistryObject<Block> STONKS_SLAB = BLOCKS.register("stonks_slab", () -> new SlabBlock(Block.Properties.
			create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(5f, 20f)
			.sound(SoundType.METAL)
			));/*/
	
	//todo models / blockstates / textures
	
	/*/public static final RegistryObject<Block> STONKS_BUTTON = BLOCKS.register("stonks_button", () -> new ModWoodButtonBlock(Block.Properties.
			create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(5f, 20f)
			));
	
	public static final RegistryObject<Block> STONKS_PRESSURE_PLATE = BLOCKS.register("stonks_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.
			create(Material.IRON, MaterialColor.GOLD)
			.hardnessAndResistance(5f, 20f)
			));
	
	public static final RegistryObject<Block> STONKS_CROP = BLOCKS.register("stonks_crop", () -> new StonksCrop(Block.Properties.
			from(Blocks.CARROTS)
			));/*/
	
}
