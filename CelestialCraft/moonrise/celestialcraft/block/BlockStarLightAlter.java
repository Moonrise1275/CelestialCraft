package moonrise.celestialcraft.block;

import java.util.List;

import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.celestialcraft.item.ModItems;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStarLightAlter extends BlockTileCeC {
	
	public BlockStarLightAlter(int id, String name) {
		super(id, name);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		ItemStack hand = player.getHeldItem();
		
		if (meta == 0) {
			if (tile instanceof TileStarLightAlter) {
				if (!((TileStarLightAlter) tile).isEmpty()) {
					player.dropPlayerItem(((TileStarLightAlter) tile).getStackInSlot(0));
				}
				else
				if (hand != null){// && hand.getItem() instanceof IToolStarLight) {
					ItemStack newItem = player.getCurrentEquippedItem().copy();
					newItem.stackSize = 1;
					((TileStarLightAlter) tile).setInventorySlotContents(0, newItem);
					newItem.stackSize = player.getCurrentEquippedItem().stackSize -1;
					player.setCurrentItemOrArmor(0, newItem);
				}
			}			
			return true;
		}else if (meta == 1 || meta == 2 || meta == 3) {
			if (hand != null) {
				if (hand.itemID == ModItems.itemUpgrade.itemID && hand.getItemDamage() == meta - 1) {
					meta++;
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 1));
		list.add(new ItemStack(id, 1, 2));
		list.add(new ItemStack(id, 1, 3));
		list.add(new ItemStack(id, 1, 4));
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
		//System.out.println("meta is " + meta);
		switch(meta) {
		
		case 0:
			//System.out.println("Alter is created");
			return new TileStarLightAlter();
			
		case 1:
			//ystem.out.println("Reflector is created");
			return new TileStarLightReflector();
			
		default :
			//System.out.println("Nothing!!");
			return null;
		
		}
		
	}
	
}
