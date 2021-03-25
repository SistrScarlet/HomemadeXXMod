package com.sistr.homemadexx.setup;

import com.sistr.homemadexx.item.MufflerItem;
import com.sistr.homemadexx.item.ParasolItem;
import com.sistr.homemadexx.item.SpearItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
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

    private static final Item.Properties proper = new Item.Properties().group(ModSetup.ITEM_GROUP);

    //todo 長柄の○○、エンチャントであってもいいかも、もしくはRSHUDの時みたいに改造作業台用意するとか
    //アイテムレジストリ
    public static final RegistryObject<MufflerItem> MUFFLER_ITEM = ITEMS.register("muffler", MufflerItem::new);
    public static final RegistryObject<ParasolItem> PARASOL_ITEM = ITEMS.register("flower_parasol", ParasolItem::new);
    public static final RegistryObject<SpearItem> WOOD_SPEAR_ITEM = ITEMS.register("wood_spear", () -> new SpearItem(ItemTier.WOOD, 4, -3, 5, proper));
    public static final RegistryObject<SpearItem> STONE_SPEAR_ITEM = ITEMS.register("stone_spear", () -> new SpearItem(ItemTier.STONE, 4, -3, 5, proper));
    public static final RegistryObject<SpearItem> IRON_SPEAR_ITEM = ITEMS.register("iron_spear", () -> new SpearItem(ItemTier.IRON, 4, -3, 5, proper));
    public static final RegistryObject<SpearItem> DIAMOND_SPEAR_ITEM = ITEMS.register("diamond_spear", () -> new SpearItem(ItemTier.DIAMOND, 4, -3, 5, proper));
    public static final RegistryObject<SpearItem> GOLD_SPEAR_ITEM = ITEMS.register("gold_spear", () -> new SpearItem(ItemTier.GOLD, 4, -3, 5, proper));

}