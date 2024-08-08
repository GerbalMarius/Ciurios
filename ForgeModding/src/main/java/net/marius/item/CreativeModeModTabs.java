package net.marius.item;

import net.marius.block.ModBlocks;
import net.marius.mariusmod.MariusMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.NoSuchElementException;

public class CreativeModeModTabs {

    private CreativeModeModTabs(){

    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MariusMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MARIUS_TAB = TABS.register("marius_tab",
            () -> createTab(new ItemStack(ModItems.SAPPHIRE.get()), Component.translatable("creativetab.marius_tab"),
                    ((itemParameters, output) -> {
                        for (var item : ModItems.items().getEntries()) {
                            Item rawValue = item.orElseThrow(NoSuchElementException::new);
                            output.accept(rawValue);
                        }

                        for (var blockWrap : ModBlocks.blocks().getEntries()){
                            Block rawValue = blockWrap.orElseThrow(NoSuchElementException::new);
                            output.accept(rawValue);
                        }
                    })));

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }

    private static CreativeModeTab createTab(ItemStack icon, Component titleComponent, CreativeModeTab.DisplayItemsGenerator itemsGenerator) {
        return CreativeModeTab.builder()
                .icon(() -> icon)
                .title(titleComponent)
                .displayItems(itemsGenerator)
                .build();
    }
}
