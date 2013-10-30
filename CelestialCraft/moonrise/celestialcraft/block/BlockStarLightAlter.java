package moonrise.celestialcraft.block;

import java.util.List;

import moonrise.celestialcraft.CelestialCraft;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStarLightAlter extends BlockTileCeC {
	
	public BlockStarLightAlter(int id, String name) {
		super(id, name);
		this.setCreativeTab(CelestialCraft.tabCeC);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		System.out.println(tile);
		System.out.println("metadata : " + world.getBlockMetadata(x, y, z));
		
		return true;
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if (tile instanceof TileStarLightAlter)
			((TileStarLightAlter) tile).removeAlter();
		world.removeBlockTileEntity(x, y, z);
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		System.out.println("meta is " + meta);
		switch(meta) {
		
		case 0:
			System.out.println("Alter is created");
			return new TileStarLightAlter();
			
		case 1:
			System.out.println("Reflector is created");
			return new TileStarLightReflector();
			
		default :
			System.out.println("Nothing!!");
			return null;
		
		}
		
	}
	
}
