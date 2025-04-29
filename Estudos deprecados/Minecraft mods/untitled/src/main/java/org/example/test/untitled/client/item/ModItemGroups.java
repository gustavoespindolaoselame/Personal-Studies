package org.example.test.untitled.client.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.example.test.untitled.Untitled;

public class ModItemGroups {
    public static final ItemGroup MIUDA_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Untitled.MOD_ID, "miuda"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.miuda")).icon(() -> new ItemStack(ModItems.MIUDA)).
                    entries((displayContext, entries) -> {
                        entries.add(ModItems.MIUDA);
                    }).build());
    public static void registerModItemGroups(){
        Untitled.LOGGER.info("Registering ItemGroups for" + Untitled.MOD_ID);
    }
}
