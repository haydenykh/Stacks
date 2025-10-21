package com.haydenykh.stacks.itemgroup;

import com.haydenykh.stacks.Stacks;
import com.haydenykh.stacks.block.StacksBlocks;
import com.haydenykh.stacks.item.StacksItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.haydenykh.stacks.Stacks.MOD_ID;

public class StacksItemGroups {

    public static final RegistryKey<ItemGroup> STACKS_GROUP_KEY;
    public static final ItemGroup STACKS;

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, STACKS_GROUP_KEY, STACKS);

        ItemGroupEvents.modifyEntriesEvent(STACKS_GROUP_KEY).register(ig -> {
            ig.add(StacksItems.EXAMPLE_ITEM);
            ig.add(StacksBlocks.EXAMPLE_BLOCK.asItem());
        });

        Stacks.LOGGER.info("Registering Stacks item groups: " + MOD_ID);
    }

    static {
        STACKS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "stacks"));
        STACKS = FabricItemGroup.builder().icon(() -> new ItemStack(Items.OXIDIZED_LIGHTNING_ROD)).displayName(Text.translatable("itemgroup.stacks")).build();
    }

}
