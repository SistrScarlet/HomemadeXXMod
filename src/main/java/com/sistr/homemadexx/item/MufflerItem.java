package com.sistr.homemadexx.item;

import com.sistr.homemadexx.setup.ModSetup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class MufflerItem extends Item {

    public MufflerItem() {
        super(new Item.Properties()
                .maxDamage(0)
                .group(ModSetup.ITEM_GROUP));
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }

}
