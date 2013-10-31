package moonrise.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderUtil {
	
	public static void draw(ResourceLocation resource, World world, Coord center, Vec vec, double size) {
		Coord LU, RU, LD, RD;
		if (vec == Vec.UP || vec == Vec.DOWN) {
			LU = new Coord(center.getX() - (size/2), center.getY(), center.getZ() - (size/2) * vec.y);
			RU = new Coord(center.getX() + (size/2), center.getY(), center.getZ() - (size/2) * vec.y);
			LD = new Coord(center.getX() - (size/2), center.getY(), center.getZ() + (size/2) * vec.y);
			RD = new Coord(center.getX() + (size/2), center.getY(), center.getZ() + (size/2) * vec.y);
		}
		else {
			Vec hor = vec.getCrossVectorHorizontal().getUnitVector().multiple(size/2);
			Vec ver = vec.getCrossVectorVertical().getUnitVector().multiple(size/2);
			LU = center.add(hor).add(ver);
			RU = center.add(hor.opposite()).add(ver);
			LD = center.add(hor).add(ver.opposite());
			RD = center.add(hor.opposite()).add(ver.opposite());
		}
		draw(resource, world, LU, RU, LD, RD, 0, 1, 0, 1);
	}
	
	public static void draw(ResourceLocation resource, World world, Coord LU, Coord RU, Coord LD, Coord RD, double minU, double maxU, double minV, double maxV) {
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(resource);
		GL11.glDepthMask(false);
		
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		
		tess.addVertexWithUV(LD.getX(), LD.getY(), LD.getZ(), minU, minV);
		tess.addVertexWithUV(RD.getX(), RD.getY(), RD.getZ(), maxU, minV);
		tess.addVertexWithUV(RU.getX(), RU.getY(), RU.getZ(), maxU, maxV);
		tess.addVertexWithUV(LU.getX(), LU.getY(), LU.getZ(), minU, maxV);
		
		tess.draw();
		
		GL11.glDepthMask(true);
	}
	
}
