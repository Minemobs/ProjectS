package fr.minemobs.projects.util.enums;

import java.util.function.Supplier;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.init.OldItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {

    OBSIDIAN(ProjectMain.MOD_ID + ":obsidian", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.BLOCK_BEEHIVE_EXIT, 6.9F, 0.1F, () -> {
        return Ingredient.fromItems(OldItemInit.project_item);
        });


    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float kbres;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterial(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float kb, Supplier<Ingredient> p_i231593_10_) {
       this.name = p_i231593_3_;
       this.maxDamageFactor = p_i231593_4_;
       this.damageReductionAmountArray = p_i231593_5_;
       this.enchantability = p_i231593_6_;
       this.soundEvent = p_i231593_7_;
       this.toughness = p_i231593_8_;
       this.kbres = kb;
       this.repairMaterial = new LazyValue<>(p_i231593_10_);
    }

    public int getDurability(EquipmentSlotType slotIn) {
       return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
       return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
       return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
       return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
       return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
       return this.name;
    }

    public float getToughness() {
       return this.toughness;
    }

    public float func_230304_f_() {
       return this.kbres;
    }
}
