package org.example.test.untitled;

import net.fabricmc.api.ModInitializer;
import org.example.test.untitled.client.block.ModBlocks;
import org.example.test.untitled.client.item.ModItemGroups;
import org.example.test.untitled.client.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Untitled implements ModInitializer {

    public static final String MOD_ID = "untitled";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        ModItemGroups.registerModItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
