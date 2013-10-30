package moonrise.celestialcraft.handler;

import moonrise.celestialcraft.block.TileCeC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public static void registerEvent() {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

}
