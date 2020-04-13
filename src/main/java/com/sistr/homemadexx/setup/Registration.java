package com.sistr.homemadexx.setup;

import com.sistr.homemadexx.item.MufflerItem;
import com.sistr.homemadexx.item.ParasolItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sistr.homemadexx.HomemadeXXMod.MODID;

public class Registration {
    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //アイテムレジストリ
    public static final RegistryObject<MufflerItem> MUFFLER_ITEM = ITEMS.register("muffler", MufflerItem::new);
    public static final RegistryObject<ParasolItem> PARASOL_ITEM = ITEMS.register("flower_parasol", ParasolItem::new);

}