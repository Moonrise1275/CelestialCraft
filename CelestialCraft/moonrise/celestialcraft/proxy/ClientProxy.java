package moonrise.celestialcraft.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import moonrise.celestialcraft.block.TileStarLightAlter;
import moonrise.celestialcraft.render.TileStarLightAlterRenderer;
import moonrise.util.Coord;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		//RenderingRegistry.registerEntityRenderingHandler(EntityPointer.class, renderer);
	}
	
	@Override
	public void registerTESR() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileStarLightAlter.class, new TileStarLightAlterRenderer());
	}
	
	@Override
	public void renderRay(Coord from, Coord to) {
		
	}

}
