package com.sistr.homemadexx.item;

import com.sistr.homemadexx.setup.ModSetup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ParasolItem extends ShieldItem {

    public ParasolItem() {
        super(new Item.Properties()
                .maxDamage(336)
                .group(ModSetup.ITEM_GROUP));
        this.addPropertyOverride(new ResourceLocation("folding"), (stack, world, entity) ->
                entity != null && entity.isShiftKeyDown() && !(entity.isHandActive() && entity.getActiveItemStack() == stack) ? 1.0F : 0.0F);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn != null) {
            if (entityIn.isShiftKeyDown()) {
                return;
            }
            if (entityIn instanceof LivingEntity) {
                if ((((LivingEntity) entityIn).isHandActive() && ((LivingEntity) entityIn).getActiveItemStack() == stack)) {
                    return;
                }
                if (!(((LivingEntity) entityIn).getHeldItemMainhand() == stack || ((LivingEntity) entityIn).getHeldItemOffhand() == stack)) {
                    return;
                }
            }
            entityIn.fallDistance = 0;
            Vec3d vec = entityIn.getMotion();
            if (vec.y < -0.1) {
                double y = vec.y;
                vec = vec.mul(1, 0, 1).add(0, Math.min(y * 0.5, -0.1), 0);
                entityIn.setMotion(vec);
            }
        }
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }
}
