package org.example.test.untitled.client.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.example.test.untitled.Untitled;

public class ModItems {
    public static final Item MIUDA =  registerItem("miuda", new Item(new Item.Settings()));

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(MIUDA);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Untitled.MOD_ID, name),item);
    }

    public static void registerModItems() {
        Untitled.LOGGER.info("Registering Mod Items for " + Untitled.MOD_ID);
        Untitled.LOGGER.info("Registered " + MIUDA.getName());
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
