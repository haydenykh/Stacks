package com.haydenykh.stacks.block;

import com.haydenykh.stacks.Stacks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.haydenykh.stacks.Stacks.MOD_ID;
import static net.minecraft.block.AbstractBlock.Settings;

public class StacksBlocks {

    public static final Block EXAMPLE_BLOCK;

    private static Block register(String id, Function<Settings, Block> blockFactory, Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> key = keyOfBlock(id);
        Block block = blockFactory.apply(settings.registryKey(key));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(id);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static Block register(String id, Settings settings) {
        return register(id, Block::new, settings, true);
    }

    private static RegistryKey<Block> keyOfBlock(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
    }

    private static RegistryKey<Item> keyOfItem(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
    }

    public static void init() {
        Stacks.LOGGER.info("Registering Stacks blocks: " + MOD_ID);
    }

    static {
        EXAMPLE_BLOCK = register("example_block", Settings.create().sounds(BlockSoundGroup.WOOD));
    }

}
