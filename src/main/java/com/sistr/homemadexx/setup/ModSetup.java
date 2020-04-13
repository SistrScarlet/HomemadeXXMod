package com.sistr.homemadexx.setup;

import com.sistr.homemadexx.HomemadeXXMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = HomemadeXXMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("homemadexx") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.MUFFLER_ITEM.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {

    }

}
