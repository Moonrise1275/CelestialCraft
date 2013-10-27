package moonrise.celestialcraft.block;

import moonrise.celestialcraft.event.BlockBreakEvent;
import moonrise.celestialcraft.event.BlockPlaceEvent;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;

public class TileCeC extends TileEntity {
	
	@ForgeSubscribe
	public void someBlockPlaced(BlockPlaceEvent event) {}
	
	@ForgeSubscribe
	public void someBlockBroken(BlockBreakEvent event) {}

}
