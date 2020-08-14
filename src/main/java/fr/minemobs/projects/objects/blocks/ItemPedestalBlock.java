package fr.minemobs.projects.objects.blocks;

import java.util.List;
import java.util.stream.Stream;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.init.ModTileEntityTypes;
import fr.minemobs.projects.tileentity.ItemPedestalTileEntity;
import fr.minemobs.projects.util.helpers.KeyboardHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ItemPedestalBlock extends Block {

	public ItemPedestalBlock(Block.Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.ITEM_PEDESTAL.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			final TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof ItemPedestalTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (ItemPedestalTileEntity) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof ItemPedestalTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((ItemPedestalTileEntity) tile).getItems());
			}
		}
	}

	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Stream.of(
				Block.makeCuboidShape(3, 1, 3, 13, 2, 13),
				Block.makeCuboidShape(5, 13, 5, 11, 14, 11),
				Block.makeCuboidShape(5, 14, 5, 6, 16, 6),
				Block.makeCuboidShape(10, 14, 5, 11, 16, 6),
				Block.makeCuboidShape(5, 14, 10, 6, 16, 11),
				Block.makeCuboidShape(10, 14, 10, 11, 16, 11),
				Block.makeCuboidShape(6, 2, 6, 10, 13, 10),
				Block.makeCuboidShape(3, 0, 12, 4, 1, 13),
				Block.makeCuboidShape(12, 0, 3, 13, 1, 4),
				Block.makeCuboidShape(12, 0, 12, 13, 1, 13),
				Block.makeCuboidShape(3, 0, 3, 4, 1, 4)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	}
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			//tooltip.add(new StringTextComponent("An item pedestal"));
			tooltip.add(new TranslationTextComponent("tooltip." + ProjectMain.MOD_ID + ".itempedestal"));
		}else {
			//tooltip.add(new StringTextComponent("HOLD " + "\u00A7e" + "SHIFT" + "\u00A77" + " for more informations!"));
			tooltip.add(new TranslationTextComponent("tooltip."+ ProjectMain.MOD_ID +".holdshift"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
