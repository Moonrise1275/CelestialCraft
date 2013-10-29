package moonrise.celestialcraft.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import moonrise.celestialcraft.entity.EntityPointer;
import moonrise.util.Coord;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		//RenderingRegistry.registerEntityRenderingHandler(EntityPointer.class, renderer);
	}
	
	@Override
	public void renderRay(Coord from, Coord to) {
		
	}

}
