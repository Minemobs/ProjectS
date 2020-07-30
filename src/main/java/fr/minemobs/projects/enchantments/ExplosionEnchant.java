package fr.minemobs.projects.enchantments;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.init.EnchantmentInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class ExplosionEnchant extends Enchantment {

	public ExplosionEnchant(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
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
		return true;
	}
	
	@Mod.EventBusSubscriber(modid = ProjectMain.MOD_ID, bus = Bus.FORGE)
	public static class UpstepEquipped{
		
		@SubscribeEvent
		public static void onHit(AttackEntityEvent e) {
			PlayerEntity p = e.getPlayer();
			Entity entity = e.getEntity();
			World world = p.world;
			if (p.hasItemInSlot(EquipmentSlotType.MAINHAND)
					&& EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.EXPLOSION.get(),
							p.getItemStackFromSlot(EquipmentSlotType.MAINHAND)) > 0) {
				world.createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), 4, Explosion.Mode.NONE);
			}
		}
	}

}
