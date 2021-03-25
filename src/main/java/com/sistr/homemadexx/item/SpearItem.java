package com.sistr.homemadexx.item;

import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

import java.util.UUID;

public class SpearItem extends SwordItem {
    protected static final UUID REACH_DISTANCE_MODIFIER = UUID.fromString("CB3EE5D3-645C-EE38-ADD7-9C13A33AA5CF");
    private final float attackReach;

    public SpearItem(ItemTier tier, int attackDamage, float attackSpeed, float attackReach, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
        this.attackReach = attackReach;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<String, AttributeModifier> attributeMap = super.getAttributeModifiers(slot, stack);
        if (slot == EquipmentSlotType.MAINHAND) {
            attributeMap.put(PlayerEntity.REACH_DISTANCE.getName(), new AttributeModifier(REACH_DISTANCE_MODIFIER, "Weapon modifier", this.attackReach, AttributeModifier.Operation.ADDITION));
        }

        return attributeMap;
    }
}
