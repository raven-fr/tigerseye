package com.mondecitronne.tigerseye.item;

import com.mondecitronne.tigerseye.TigersEye;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemTigersEyeArmor extends ItemArmor {
	public static final ArmorMaterial TIGERS_EYE = EnumHelper.addArmorMaterial(TigersEye.resource("tigers_eye").toString(), TigersEye.resource("tigers_eye").toString(), 2, new int[]{4, 8, 12, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

	public ItemTigersEyeArmor(EntityEquipmentSlot equipmentSlotIn) {
		super(TIGERS_EYE, 0, equipmentSlotIn);
	}
}
