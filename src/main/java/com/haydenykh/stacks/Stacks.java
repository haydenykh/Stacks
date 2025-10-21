package com.haydenykh.stacks;

import com.haydenykh.stacks.block.StacksBlocks;
import com.haydenykh.stacks.item.StacksItems;
import com.haydenykh.stacks.itemgroup.StacksItemGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stacks implements ModInitializer {
	public static final String MOD_ID = "stacks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		StacksItems.init();
		StacksBlocks.init();
		StacksItemGroups.init();
		LOGGER.info("Registering Stacks mod!");
	}
}