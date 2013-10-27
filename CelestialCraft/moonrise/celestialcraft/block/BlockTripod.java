package moonrise.celestialcraft.block;

import moonrise.util.SimpleBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTripod extends BlockCelestialCraft implements ITileEntityProvider {

	public BlockTripod(int id, String name) {
		super(id, name);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileTripod();
	}
	
	

}
