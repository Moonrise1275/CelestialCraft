package moonrise.celestialcraft.render;

import org.lwjgl.opengl.GL11;

import moonrise.celestialcraft.ModInfo;
import moonrise.celestialcraft.block.TileStarLightAlter;
import moonrise.celestialcraft.model.ModelAlter;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileStarLightAlterRenderer extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation resource = new ResourceLocation("celestialcraft", "textures/tile/alter.png");
	private final ModelAlter mAlter = new ModelAlter();
	
	private int cubeTick, coreTick;

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		TileStarLightAlter alter = (TileStarLightAlter) tileentity;
		this.cubeTick = alter.cubeTick;
		this.coreTick = alter.coreTick;
		float cubeRot = (float)(this.cubeTick / 150) * ModInfo.PI;
		float coreRot = (float)(this.coreTick / 120) * ModInfo.PI;
		
		GL11.glPushMatrix();
		
		this.bindTexture(resource);
		GL11.glTranslated(x, y, z);
		this.mAlter.render(cubeRot, coreRot, 0.0625f);
		
		GL11.glPopMatrix();
	}

}
