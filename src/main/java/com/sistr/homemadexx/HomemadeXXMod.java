package com.sistr.homemadexx;

import com.sistr.homemadexx.setup.ClientSetup;
import com.sistr.homemadexx.setup.ModSetup;
import com.sistr.homemadexx.setup.Registration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("homemadexx")
public class HomemadeXXMod {

    public static final String MODID = "homemadexx";

    public HomemadeXXMod() {
        Registration.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }

}
