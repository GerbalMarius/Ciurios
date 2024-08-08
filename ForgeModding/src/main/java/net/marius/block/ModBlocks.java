package net.marius.block;

import net.marius.item.ModItems;
import net.marius.mariusmod.MariusMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MariusMod.MOD_ID);


    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
                                                () -> createBlock(Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            () -> createBlock(Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        var returnableBlock = BLOCKS.register(name, block);
        registerItemBlock(name, returnableBlock);
        return returnableBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerItemBlock(String name, RegistryObject<T> block) {
        return ModItems.items().register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    private static Block createBlock(Properties properties) {
        return new Block(properties);
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
    public static DeferredRegister<Block> blocks() {
        return BLOCKS;
    }
}
