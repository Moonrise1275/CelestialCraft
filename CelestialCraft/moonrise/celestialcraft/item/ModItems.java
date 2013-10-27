package moonrise.celestialcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
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
		LanguageRegistry.addName(itemLense, nameLense);
		
		itemTelescope = new ItemTelescope(config.idTelescope, nameScope);
		GameRegistry.registerItem(itemTelescope, nameScope);
		LanguageRegistry.addName(itemTelescope, nameScope);
		
		itemMap = new ItemCelestialMap(config.idMap, nameMap);
		GameRegistry.registerItem(itemMap, nameMap);
		LanguageRegistry.addName(itemMap, nameMap);
		
	}
	
	public static void registerRecipes() {
		CraftingUtil.addRecipe(ModItems.itemTelescope, "  L", " W ", "L  ", 'L', itemLense, 'W', Block.wood);
		
		CraftingUtil.addSmelting(Block.glass, itemLense, 5);
	}

}
