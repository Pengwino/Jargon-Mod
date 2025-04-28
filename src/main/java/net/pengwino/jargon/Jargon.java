package net.pengwino.jargon;

import net.fabricmc.api.ModInitializer;
// Sweet test
import net.pengwino.jargon.block.ModBlocks;
import net.pengwino.jargon.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jargon implements ModInitializer {
	public static final String MOD_ID = "jargonmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}