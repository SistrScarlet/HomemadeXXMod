package com.sistr.homemadexx.setup;

import com.sistr.homemadexx.HomemadeXXMod;
import com.sistr.homemadexx.client.MufflerLayer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HomemadeXXMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        //レイヤーの追加
        event.getMinecraftSupplier().get().getRenderManager().getSkinMap().forEach(((s, renderer) ->
                renderer.addLayer(new MufflerLayer<>((PlayerRenderer) renderer))));

    }

}
