package moonrise.celestialcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import moonrise.celestialcraft.handler.ConfigHandler;
import net.minecraft.block.Block;

public class ModBlocks {
	
	private static ModBlocks instance;
	
	public static Block blockAntenna, blockReceiver;
	
	public static String
	nameAntenna = "Antenna",
	nameReceiver = "Receiver";
	
	private static ConfigHandler config;
	
	private ModBlocks() {}
	
	public static ModBlocks getInst() {
		if (instance == null)
			instance = new ModBlocks();
		return instance;
	}
	
	public static void init() {
		
		config = ConfigHandler.getInst();
		
		blockAntenna = new BlockAntenna(config.idBlockAntenna, nameAntenna);
		register(blockAntenna);
		blockReceiver = new BlockReceiver(config.idBlockReceiver, nameReceiver);
		register(blockReceiver);
	}
	
	private static void register(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		LanguageRegistry.addName(block, block.getUnlocalizedName());
	}
	
	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileReceiver.class, "TileReceiver");
		
	}

}
