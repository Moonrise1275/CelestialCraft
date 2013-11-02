package moonrise.celestialcraft.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileStarLightAlterRenderer extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation resource = new ResourceLocation("celestialcraft", "textures/tile/alter.png");
	private final ModelStarLightAlter mAlter = new ModelStarLightAlter();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		
		this.bindTexture(resource);
		GL11.glTranslated(x, y, z);
		this.mAlter.render(0.0625f);
		
		GL11.glPopMatrix();
	}

}
