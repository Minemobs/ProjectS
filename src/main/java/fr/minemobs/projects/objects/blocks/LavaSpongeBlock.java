package fr.minemobs.projects.objects.blocks;

import java.util.Queue;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class LavaSpongeBlock extends Block {
	   public LavaSpongeBlock(Block.Properties properties) {
	      super(properties);
	   }

	   public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
	      if (oldState.getBlock() != state.getBlock()) {
	         this.tryAbsorb(worldIn, pos);
	      }
	   }
	   
	   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
	      this.tryAbsorb(worldIn, pos);
	      super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
	   }

	   protected void tryAbsorb(World worldIn, BlockPos pos) {
	      if (this.absorb(worldIn, pos)) {
	         //worldIn.setBlockState(pos, Blocks.WET_SPONGE.getDefaultState(), 2);
	         worldIn.playEvent(2001, pos, Block.getStateId(Blocks.LAVA.getDefaultState()));
	      }

	   }

	   private boolean absorb(World worldIn, BlockPos pos) {
	      Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
	      queue.add(new Tuple<>(pos, 0));
	      int i = 0;

	      while(!queue.isEmpty()) {
	         Tuple<BlockPos, Integer> tuple = queue.poll();
	         BlockPos blockpos = tuple.getA();
	         int j = tuple.getB();

	         for(Direction direction : Direction.values()) {
	            BlockPos blockpos1 = blockpos.offset(direction);
	            BlockState blockstate = worldIn.getBlockState(blockpos1);
	            IFluidState ifluidstate = worldIn.getFluidState(blockpos1);
	            Material material = blockstate.getMaterial();
	            if (ifluidstate.isTagged(FluidTags.LAVA)) {
	               if (blockstate.getBlock() instanceof IBucketPickupHandler && ((IBucketPickupHandler)blockstate.getBlock()).pickupFluid(worldIn, blockpos1, blockstate) != Fluids.EMPTY) {
	                  ++i;
	                  if (j < 6) {
	                     queue.add(new Tuple<>(blockpos1, j + 1));
	                  }
	               } else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
	                  worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
	                  ++i;
	                  if (j < 6) {
	                     queue.add(new Tuple<>(blockpos1, j + 1));
	                  }
	               }
	            }
	         }

	         if (i > 64) {
	            break;
	         }
	      }

	      return i > 0;
	   }

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Stream.of(
				Block.makeCuboidShape(1, 1, 1, 15, 15, 15),
				Block.makeCuboidShape(0, 1, 1, 1, 15, 15),
				Block.makeCuboidShape(1, 1, 15, 15, 15, 16),
				Block.makeCuboidShape(1, 1, 0, 15, 15, 1),
				Block.makeCuboidShape(15, 1, 1, 16, 15, 15),
				Block.makeCuboidShape(0, 0, 0, 1, 1, 1),
				Block.makeCuboidShape(15, 0, 15, 16, 1, 16),
				Block.makeCuboidShape(15, 0, 0, 16, 1, 1),
				Block.makeCuboidShape(0, 0, 15, 1, 1, 16),
				Block.makeCuboidShape(0, 0, 1, 1, 1, 15),
				Block.makeCuboidShape(15, 0, 1, 16, 1, 15),
				Block.makeCuboidShape(1, 0, 0, 15, 1, 1),
				Block.makeCuboidShape(1, 0, 15, 15, 1, 16),
				Block.makeCuboidShape(15, 15, 1, 16, 16, 15),
				Block.makeCuboidShape(0, 15, 1, 1, 16, 15),
				Block.makeCuboidShape(1, 15, 0, 15, 16, 1),
				Block.makeCuboidShape(1, 15, 15, 15, 16, 16),
				Block.makeCuboidShape(0, 15, 0, 1, 16, 1),
				Block.makeCuboidShape(15, 15, 15, 16, 16, 16),
				Block.makeCuboidShape(15, 15, 0, 16, 16, 1),
				Block.makeCuboidShape(0, 15, 15, 1, 16, 16),
				Block.makeCuboidShape(0, 1, 15, 1, 15, 16),
				Block.makeCuboidShape(15, 1, 15, 16, 15, 16),
				Block.makeCuboidShape(15, 1, 0, 16, 15, 1),
				Block.makeCuboidShape(0, 1, 0, 1, 15, 1)
		).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	}

	}