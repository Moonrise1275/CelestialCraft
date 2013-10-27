package moonrise.celestialcraft.handler;

import moonrise.celestialcraft.block.TileCeC;
import moonrise.celestialcraft.block.TileReceiver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public static void registerEvent() {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new TileCeC());
	}

}
