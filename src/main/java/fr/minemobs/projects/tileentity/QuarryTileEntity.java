package fr.minemobs.projects.tileentity;


import javax.annotation.Nullable;

import fr.minemobs.projects.init.BlockInit;
import fr.minemobs.projects.init.ModTileEntityTypes;
import fr.minemobs.projects.init.OldBlockInit;
import fr.minemobs.projects.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {

	public int x, y, z, tick;
	boolean initialized = false;

	public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public QuarryTileEntity() {
		this(ModTileEntityTypes.quarry.get());
	}

	@Override
	public void tick() {
		if (!initialized)
			init();
		tick++;
		if (tick == 40) {
			tick = 0;
			if (y > 2)
				execute();
		}
	}

	private void init() {
		initialized = true;
		x = this.pos.getX() - 1;
		y = this.pos.getY() - 1;
		z = this.pos.getZ() - 1;
		tick = 0;
	}

	private void execute() {
		int index = 0;
		Block[] blocksRemoved = new Block[9];
		for (int x = 0; x < 3; x++) {
			for (int z = 0; z < 3; z++) {
				BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
				blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
				destroyBlock(posToBreak, true, null);
				index++;
			}
		}
		this.y--;
	}

	private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
		BlockState blockstate = world.getBlockState(pos);
		if (blockstate.isAir(world, pos) || blockstate.getBlock().equals(Blocks.BARRIER) || blockstate.getBlock().equals(Blocks.BEDROCK) || blockstate.getBlock() == Blocks.COMMAND_BLOCK
				|| blockstate.getBlock() == Blocks.CHAIN_COMMAND_BLOCK || blockstate.getBlock() == Blocks.REPEATING_COMMAND_BLOCK || blockstate.getBlockState().equals(this.getBlockState()))
			return false;
		else {
			IFluidState fluidstate = world.getFluidState(pos);
			world.playEvent(2001, pos, Block.getStateId(blockstate));
			if (dropBlock) {
				TileEntity tileentity = blockstate.hasTileEntity() ? world.getTileEntity(pos) : null;
				Block.spawnDrops(blockstate, world, this.pos.add(-1, 1.5, 0), tileentity, entity, ItemStack.EMPTY);
			}
			return world.setBlockState(pos, fluidstate.getBlockState(), 3);
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.put("initvalues", NBTHelper.toNBT(this));
		return super.write(compound);
	}


	public void read(CompoundNBT compound) {
		CompoundNBT initValues = compound.getCompound("initvalues");
		if (initValues != null) {

			this.x = initValues.getInt("x");
			this.y = initValues.getInt("y");
			this.z = initValues.getInt("z");
			this.tick = 0;
			initialized = true;
			return;
		}
		init();
	}
}
