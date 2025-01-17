package org.example.test.untitled.client.block;

import com.jcraft.jorbis.Block;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.example.test.untitled.Untitled;
import org.example.test.untitled.client.item.ModItems;

public class ModBlocks {

    public static void registerModBlocks() {
        Untitled.LOGGER.info("Registering ModBlocks for " + Untitled.MOD_ID);
    }
}
