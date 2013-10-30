package moonrise.celestialcraft.block;

import moonrise.celestialcraft.event.BlockBreakEvent;
import moonrise.celestialcraft.event.BlockPlaceEvent;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;

public class TileCeC extends TileEntity {
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass() == obj.getClass()) {
			if (obj instanceof TileCeC) {
				TileCeC tile = (TileCeC) obj;
				if (tile.xCoord == this.xCoord) {
					if (tile.yCoord == this.yCoord) {
						if (tile.zCoord == this.zCoord)
							return true;
					}
				}
			}
		}
		return false;
	}

}
