package fr.minemobs.projects.objects.items;

import java.util.List;

import fr.minemobs.projects.init.BlockInit;
import fr.minemobs.projects.init.OldBlockInit;
import fr.minemobs.projects.util.helpers.KeyboardHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SpecialItem extends Item {

	public SpecialItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("Info test"));
		}else {
			tooltip.add(new StringTextComponent("HOLD " + "\u00A7e" + "SHIFT" + "\u00A77" + " for more informations!"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerIn, Hand hand){
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 60, 255));
		Minecraft mc = Minecraft.getInstance();
		if(KeyboardHelper.isHoldingControl()) {
			mc.player.sendChatMessage("/time set day");
		}else if(KeyboardHelper.isHoldingShift()) {
			mc.player.sendChatMessage("/time set night");
		}
		return super.onItemRightClick(world, playerIn, hand);
	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.project_block.get().getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 100;
	}
	
}
