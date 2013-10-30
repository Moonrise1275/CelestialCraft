package moonrise.celestialcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import moonrise.celestialcraft.handler.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModBlocks {
	
	private static ModBlocks instance;
	
	public static Block blockStarLightAlter;
	
	public static String
	nameStarLightAlter = "StarLightAlter";
	
	private static ConfigHandler config;
	
	private ModBlocks() {}
	
	public static ModBlocks getInst() {
		if (instance == null)
			instance = new ModBlocks();
		return instance;
	}
	
	public static void init() {
		
		config = ConfigHandler.getInst();
		
		blockStarLightAlter = new BlockStarLightAlter(config.idBlockAntenna, nameStarLightAlter);
		GameRegistry.registerBlock(blockStarLightAlter, nameStarLightAlter);
	}
	
	
	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileStarLightAlter.class, "TileStarLightAlter");
		GameRegistry.registerTileEntity(TileStarLightReflector.class, "TileStarLightReflector");
		
	}

}
