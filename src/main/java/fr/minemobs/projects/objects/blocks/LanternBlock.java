package fr.minemobs.projects.objects.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

	public class LanternBlock extends Block implements IWaterLoggable {
		   public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
		   public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
		   protected static final VoxelShape field_220279_b = VoxelShapes.or(Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D), Block.makeCuboidShape(6.0D, 7.0D, 6.0D, 10.0D, 9.0D, 10.0D));
		   protected static final VoxelShape HANGING_SHAPES = VoxelShapes.or(Block.makeCuboidShape(5.0D, 1.0D, 5.0D, 11.0D, 8.0D, 11.0D), Block.makeCuboidShape(6.0D, 8.0D, 6.0D, 10.0D, 10.0D, 10.0D));

		   public LanternBlock(Block.Properties properties) {
		      super(properties);
		      this.setDefaultState(this.stateContainer.getBaseState().with(HANGING, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.valueOf(false)));
		   }

		   @Nullable
		   public BlockState getStateForPlacement(BlockItemUseContext context) {
			      BlockPos blockpos = context.getPos();
			      BlockState blockstate = context.getWorld().getBlockState(blockpos);
		      for(Direction direction : context.getNearestLookingDirections()) {
		         if (direction.getAxis() == Direction.Axis.Y) {
		            if (blockstate.isValidPosition(context.getWorld(), context.getPos())) {
					      if (blockstate.getBlock() == this) {
						         return blockstate.with(WATERLOGGED, Boolean.valueOf(false));
						      } else {
						         IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
						         BlockState blockstate1 = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
						      }
		               return blockstate;
		            }
		         }
		      }

		      return null;
		   }
		   
		   public IFluidState getFluidState(BlockState state) {
			      return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
			   }

			   public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
			      return state.get(WATERLOGGED) != false ? IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn) : false;
			   }

			   public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
			      return state.get(WATERLOGGED) != false ? IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn) : false;
			   }

		   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		      return state.get(HANGING) ? HANGING_SHAPES : field_220279_b;
		   }

		   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		      builder.add(HANGING, WATERLOGGED);
		   }

		   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      Direction direction = getBlockConnected(state).getOpposite();
		      return Block.hasEnoughSolidSide(worldIn, pos.offset(direction), direction.getOpposite());
		   }

		   protected static Direction getBlockConnected(BlockState state) {
		      return state.get(HANGING) ? Direction.DOWN : Direction.UP;
		   }

		   /**
		    * @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible. Implementing/overriding is fine.
		    */
		   public PushReaction getPushReaction(BlockState state) {
		      return PushReaction.DESTROY;
		   }

		   /**
		    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
		    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
		    * returns its solidified counterpart.
		    * Note that this method should ideally consider only the specific face passed in.
		    */
		   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
			      if (stateIn.get(WATERLOGGED)) {
			          worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			       }
		      return getBlockConnected(stateIn).getOpposite() == facing && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		   }

		   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		      return false;
		   }
}
