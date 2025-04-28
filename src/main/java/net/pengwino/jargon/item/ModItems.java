package net.pengwino.jargon.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pengwino.jargon.Jargon;

public class ModItems {
    public static final Item VOLCANIC_QUARTZ = registerItem("volcanic_quartz", new Item(new Item.Settings()));
    public static final Item OBSIDIANSTEEL_INGOT = registerItem("obsidiansteel_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Jargon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Jargon.LOGGER.info("Registering Mod Items for " + Jargon.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
           fabricItemGroupEntries.add(VOLCANIC_QUARTZ);
            fabricItemGroupEntries.add(OBSIDIANSTEEL_INGOT);
        });
    }
}
