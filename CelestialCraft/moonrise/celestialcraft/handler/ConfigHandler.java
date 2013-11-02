package moonrise.celestialcraft.handler;

import java.io.File;

import moonrise.celestialcraft.ModInfo;
import moonrise.util.IModInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	private static ConfigHandler handler;
	Configuration config;
	IModInfo info = new ModInfo();
	
	private String general = "general";
	
	public static float 
	antennaDistance,
	receiverExplosionStrength,
	pointerSize;
	
	private static int block = ModInfo.BASIC_BLOCK_ID, 
			           item = ModInfo.BASIC_ITEM_ID;
	
	public static int 
	idLense,
	idTelescope,
	idMap,
	idReflectorUpgrade,
	idLaserPointer,
	
	idBlockMogi,
	idBlockAlter;
	
	private ConfigHandler(File file) {
		this.config = new Configuration(file);
	}
	
	public static ConfigHandler getInst(File file) {
		
		if (handler == null)
			handler = new ConfigHandler(file);
		
		return handler;
		
	}
	
	public static ConfigHandler getInst() {
		return handler;
	}
	
	public void init() {
		
		this.idLense = config.getItem("Lense", ++item).getInt();
		this.idTelescope = config.getItem("Telescope", ++item).getInt();
		this.idMap = config.getItem("CelestialMap", ++item).getInt();
		this.idReflectorUpgrade = config.getItem("ReflectorUpgrade", ++item).getInt();
		this.idLaserPointer = config.getItem("LaserPointer", ++item).getInt();
		
		this.idBlockMogi = config.getBlock("Mogi", ++block).getInt();
		this.idBlockAlter = config.getBlock("StarlightAlter", ++block).getInt();
		
		this.antennaDistance = (float) config.get(general, "Antenna_Distance", 800.0).getDouble(800.0);
		this.receiverExplosionStrength = (float) config.get(general, "Receiver_Explosion_Strength", 3.5).getDouble(3.5);
		this.pointerSize = (float) config.get(general, "Pointer_Size", 0.35).getDouble(0.35);
		
	}

}
