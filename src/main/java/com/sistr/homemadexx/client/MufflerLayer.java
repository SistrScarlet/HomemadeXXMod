package com.sistr.homemadexx.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sistr.homemadexx.HomemadeXXMod;
import com.sistr.homemadexx.setup.Registration;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MufflerLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private static final ResourceLocation MUFFLER_TEXTURE = new ResourceLocation(HomemadeXXMod.MODID, "textures/entity/muffler.png");
    private final MufflerModel<T> mufflerModel = new MufflerModel<>();

    public MufflerLayer(IEntityRenderer<T, M> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn,
                       float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (itemstack.getItem() == Registration.MUFFLER_ITEM.get()) {
            ResourceLocation resourcelocation;

            resourcelocation = MUFFLER_TEXTURE;

            matrixStackIn.push();
            if (entitylivingbaseIn.isSneaking()) {
                matrixStackIn.translate(0, 0.25, 0);
            }
            this.getEntityModel().copyModelAttributesTo(this.mufflerModel);
            this.mufflerModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder ivertexbuilder =
                    ItemRenderer.getBuffer(bufferIn, this.mufflerModel.getRenderType(resourcelocation), false, itemstack.hasEffect());
            this.mufflerModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY,
                    1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
    }
}
