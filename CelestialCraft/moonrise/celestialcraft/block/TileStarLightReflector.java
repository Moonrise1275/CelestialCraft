package moonrise.celestialcraft.block;

import net.minecraft.tileentity.TileEntity;

public class TileStarLightReflector extends TileCeC {
	
	private TileStarLightAlter alter;
	public static final String[] types = { "glass", "copper", "silver", "iridium" };
	static final int[] outputs = { 10, 20, 50, 100 };
	
	public TileStarLightReflector() {
		this.alter = null;
	}
	
	@Override
	public void updateEntity() {
		if (this.alter == null)
			this.alter = searchAlter();
		
	}
	
	public int getEnergy() {
		return outputs[this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord)];
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
