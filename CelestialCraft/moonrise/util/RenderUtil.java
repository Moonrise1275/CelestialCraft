package moonrise.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderUtil {
	
	public static void draw(Icon icon, World world, Coord center, Vec vec, double size) {
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
		draw(icon, world, LU, RU, LD, RD);
	}
	
	public static void draw(Icon icon, World world, Coord LU, Coord RU, Coord LD, Coord RD) {
		
		if (!world.isRemote)
			return;
		
		GL11.glPushMatrix();
		
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		
		tess.setTranslation(LD.getX(), LD.getY(), LD.getZ());
		tess.setTranslation(RD.getX(), RD.getY(), RD.getZ());
		tess.setTranslation(LU.getX(), LU.getY(), LU.getZ());
		tess.setTranslation(RU.getX(), RU.getY(), RU.getZ());
		
		tess.addVertexWithUV(LD.getX(), LD.getY(), LD.getZ(), icon.getMinU(), icon.getMinV());
		tess.addVertexWithUV(RD.getX(), RD.getY(), RD.getZ(), icon.getMaxU(), icon.getMinV());
		tess.addVertexWithUV(RU.getX(), RU.getY(), RU.getZ(), icon.getMaxU(), icon.getMaxV());
		tess.addVertexWithUV(LU.getX(), LU.getY(), LU.getZ(), icon.getMinU(), icon.getMaxV());
		
		tess.draw();
		
		GL11.glPopMatrix();
	}
	
}
