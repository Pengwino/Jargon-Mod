package net.pengwino.jargon.block;

import net.minecraft.block.Block;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.pengwino.jargon.Jargon;


public class ModBlocks {

    public static final Block PUMICE = registerBlock("pumice",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.2f,4f).sounds(BlockSoundGroup.BASALT)));

    public static final Block PUMICE_IRON_ORE = registerBlock("pumice_iron_ore",
            new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.5F, 3.0F)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Jargon.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Jargon.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Jargon.LOGGER.info("Registering Mod Blocks for " + Jargon.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PUMICE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PUMICE_IRON_ORE);
        });
    }
}
