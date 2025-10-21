package com.haydenykh.stacks.item;

import com.haydenykh.stacks.Stacks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.haydenykh.stacks.Stacks.MOD_ID;
import static net.minecraft.item.Item.Settings;

public class StacksItems {

    public static final Item EXAMPLE_ITEM;

    private static Item register(String id, Function<Settings, Item> itemFactory, Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        Item item = itemFactory.apply(settings.registryKey(key));
        Registry.register(Registries.ITEM, key, item);
        return item;
    }

    private static Item register(String id) {
        return register(id, Item::new, new Settings());
    }

    public static void init() {
        Stacks.LOGGER.info("Registering Stacks items: " + MOD_ID);
    }

    static {
        EXAMPLE_ITEM = register("example_item");
    }

}
