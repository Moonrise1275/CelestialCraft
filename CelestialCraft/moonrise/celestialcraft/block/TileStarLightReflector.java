package moonrise.celestialcraft.block;

import net.minecraft.tileentity.TileEntity;

public class TileStarLightReflector extends TileCeC {
	
	private TileStarLightAlter alter;
	public static final String[] types = { "Glass", "Copper", "Silver", "Iridium" };
	static final int[] outputs = { 10, 20, 50, 100 };
	
	public TileStarLightReflector() {
		this.alter = null;
	}
	
	@Override
	public void updateEntity() {
		if (this.alter == null) {
			this.alter = searchAlter();
			System.out.println("Searching alter");
			if (alter != null) {
				alter.addReflector(this);
				System.out.println("Add reflector");
			}
		}
	}
	
	public int getEnergy() {
		if (worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord) && !worldObj.isDaytime())
			return outputs[this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord)];
		return 10;
	}
	
	private TileStarLightAlter searchAlter() {
		for (int i=-2; i<3; i++) {
			for (int j=-2; j<3; j++) {
				 TileEntity tile = this.worldObj.getBlockTileEntity(this.xCoord + i, this.yCoord, this.zCoord + j);
				 if (tile instanceof TileStarLightAlter)
					 return (TileStarLightAlter) tile;
			}
		}
		return null;
	}
	
	public void removeAlter() {
		this.alter = null;
	}
	
	public void removeReflector() {
		this.alter.removeReflector(this);
	}

}
