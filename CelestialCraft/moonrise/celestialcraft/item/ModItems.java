package moonrise.celestialcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import moonrise.celestialcraft.block.ModBlocks;
import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.util.CraftingUtil;
import moonrise.util.SimpleItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
		
	private static ModItems instance;
	
	public static Item itemLense, itemTelescope, itemMap;
	
	public static String
	nameLense = "Lense",
	nameScope = "Telescope",
	nameMap = "CelestialMap";
	
	private static ConfigHandler config;
	
	
	private ModItems() {}
	
	public static ModItems getInst() {
		if (instance == null)
				instance = new ModItems();
		return instance;
	}
	
	public static void init() {
		
		config = ConfigHandler.getInst();
		
		itemLense = new ItemCelestialCraft(config.idLense, nameLense);
		GameRegistry.registerItem(itemLense, nameLense);
		
		itemTelescope = new ItemTelescope(config.idTelescope, nameScope);
		GameRegistry.registerItem(itemTelescope, nameScope);
		
		itemMap = new ItemCelestialMap(config.idMap, nameMap);
		GameRegistry.registerItem(itemMap, nameMap);
		
	}
	
	public static void registerRecipes() {
		CraftingUtil.addRecipe(ModItems.itemTelescope, "  L", " W ", "L  ", 'L', itemLense, 'W', Block.wood);
		CraftingUtil.addRecipe(new ItemStack(ModBlocks.blockStarLightAlter, 1, 0), "S", "T", 'S', itemTelescope, 'T', Block.enchantmentTable);
		CraftingUtil.addRecipe(new ItemStack(ModBlocks.blockStarLightAlter, 1, 1), "L", "T", 'L', itemLense, 'T', Block.enchantmentTable);
		
		CraftingUtil.addSmelting(Block.glass, itemLense, 5);
	}

}
