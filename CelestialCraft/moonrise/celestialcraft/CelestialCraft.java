package moonrise.celestialcraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.ModLoader;
import moonrise.celestialcraft.block.ModBlocks;
import moonrise.celestialcraft.exception.InvalidFileException;
import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.celestialcraft.handler.EventHandler;
import moonrise.celestialcraft.handler.FuelHandler;
import moonrise.celestialcraft.handler.PacketHandler;
import moonrise.celestialcraft.item.ModItems;
import moonrise.celestialcraft.proxy.CommonProxy;
import moonrise.util.IModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION, dependencies = ModInfo.DEPEND)
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class CelestialCraft {
	
	public static boolean Tinker;
	
	public static CreativeTabs tabCeC;
	
	public static IModInfo info = new ModInfo();
	
	ConfigHandler config;
	FuelHandler fuel;
	
	String sep = File.separator;
	File playerData = new File("CelestialData" + sep + "CeCPlayerData.bin");
	
	@Mod.Instance(ModInfo.MOD_ID)
	public static CelestialCraft instance;
	
	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		
		this.tabCeC = new CreativeTabCeC(info.getModId());
		ConfigHandler.getInst(evt.getSuggestedConfigurationFile()).init();
		EventHandler.registerEvent();
		
		this.Tinker = ModLoader.isModLoaded("TConstruct");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent evt) {
		
		ModItems.init();
		ModBlocks.init();
		ModItems.registerRecipes();
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		
		GameRegistry.registerFuelHandler(fuel);
		
	}
	
	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent evt) {
		
		File invalidFile = new File("CelestialData" + sep + "invalidPlayerData.bin");
		
		if (!playerData.exists()) {
			playerData.getParentFile().mkdirs();
			PlayerCeC.addMasterPlayer();
			
		} else {
			try {
				PlayerCeC.loadListFromFile(playerData);
			} catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				if (e instanceof InvalidFileException)
					System.out.println(((InvalidFileException) e).checkInvalidFile().toPath());
				
				playerData.renameTo(invalidFile);
				serverStarting(evt);
			}
		}
	}
	
	@Mod.EventHandler
	public void serverStopping(FMLServerStoppingEvent evt) {
		try {
			File oldFile = new File("CelestialData" + sep + "oldPlayerData.bin");
			PlayerCeC.saveListIntoFile(playerData, oldFile);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
