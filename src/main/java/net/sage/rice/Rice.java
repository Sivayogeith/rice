package net.sage.rice;

import net.sage.rice.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.sage.rice.entity.ModEntities;
import net.sage.rice.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rice implements ModInitializer {
	public static final String MOD_ID = "rice";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModItems.registerModItems();
	}
}