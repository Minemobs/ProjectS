package fr.minemobs.projects.objects.blocks;

import java.util.UUID;
import java.util.stream.Stream;

import com.mojang.authlib.GameProfile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Specalblock extends Block {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(5, 3, 3, 11, 4, 13),
			Block.makeCuboidShape(5, 4, 11, 11, 11, 12), Block.makeCuboidShape(7, 0, 5, 9, 3, 11),
			Block.makeCuboidShape(11, 5, 5, 13, 6, 12), Block.makeCuboidShape(3, 5, 5, 5, 6, 12)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(3, 3, 5, 13, 4, 11),
			Block.makeCuboidShape(11, 4, 5, 12, 11, 11), Block.makeCuboidShape(5, 0, 7, 11, 3, 9),
			Block.makeCuboidShape(5, 5, 3, 12, 6, 5), Block.makeCuboidShape(5, 5, 11, 12, 6, 13)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(5, 3, 3, 11, 4, 13),
			Block.makeCuboidShape(5, 4, 4, 11, 11, 5), Block.makeCuboidShape(7, 0, 5, 9, 3, 11),
			Block.makeCuboidShape(3, 5, 4, 5, 6, 11), Block.makeCuboidShape(11, 5, 4, 13, 6, 11)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(3, 3, 5, 13, 4, 11),
			Block.makeCuboidShape(4, 4, 5, 5, 11, 11), Block.makeCuboidShape(5, 0, 7, 11, 3, 9),
			Block.makeCuboidShape(4, 5, 11, 11, 6, 13), Block.makeCuboidShape(4, 5, 3, 11, 6, 5)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public Specalblock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));
		
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
	
	Minecraft mc = Minecraft.getInstance();
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		String f = "f";
		if (!worldIn.isRemote()) {
			ServerWorld serverworld = (ServerWorld) worldIn;
			mc.player.sendChatMessage(f);
		}
		return ActionResultType.SUCCESS;
	}
	
	
}
