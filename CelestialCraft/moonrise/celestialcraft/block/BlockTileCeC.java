package moonrise.celestialcraft.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockTileCeC extends BlockCelestialCraft implements ITileEntityProvider {
		
	/*
	 * superclass of all my tile blocks
	 * args :
	 * @id , name : don't touch it
	 * @classTile : it's tileentity's class
	 *  ex) TileStarLightAlter.class
	 */
	public BlockTileCeC(int id, String name) {
		super(id, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@Override
	public abstract TileEntity createTileEntity(World world, int meta);
	
}
