package fr.minemobs.projects.enchantments;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.init.BlockInit;
import fr.minemobs.projects.init.EnchantmentInit;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class UpstepEnchantment extends Enchantment {

	public UpstepEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		super(rarityIn, typeIn, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	public int getMinLevel() {
		return 1;
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		// TODO Auto-generated method stub
		return ench.equals(Enchantments.DEPTH_STRIDER) ? false : true;
	}
	
	@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Bus.FORGE)
	public static class UpstepEquipped{
		
		@SubscribeEvent
		public static void doSomthing(PlayerTickEvent e) {
			PlayerEntity p = e.player;
			World world = p.world;
			if (p.hasItemInSlot(EquipmentSlotType.FEET)
					&& EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.UPSTEP.get(),
							p.getItemStackFromSlot(EquipmentSlotType.FEET)) > 0) {
			if(p.isSprinting()) {
					world.setBlockState(p.getPosition().down(), BlockInit.project_block.get().getDefaultState());
				}else {
					if(world.getBlockState(p.getPosition().down()).getBlock() == Blocks.BARRIER || world.getBlockState(p.getPosition().down()).getBlock() == BlockInit.project_block.get()) {
						world.setBlockState(p.getPosition().down(), Blocks.AIR.getDefaultState());
					}
				}
			}
		}
	}
}
