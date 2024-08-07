package net.marius.item;

import net.marius.mariusmod.MariusMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    private ModItems(){

    }

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MariusMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = createItem("sapphire", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE = createItem("raw_sapphire", () -> new Item(new Item.Properties()));


    public static DeferredRegister<Item> items(){
        return ITEMS;
    }

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }

    private static RegistryObject<Item> createItem(String name, Supplier<? extends Item> itemSupplier){
        return ITEMS.register(name, itemSupplier);
    }

}
