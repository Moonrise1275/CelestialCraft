package moonrise.celestialcraft.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.celestialcraft.item.ModItems;
import moonrise.util.EntityUtil;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStarLightAlter extends BlockTileCeC {
	
	public BlockStarLightAlter(int id, String name) {
		super(id, name);
		this.setBlockBounds(0f, 0f, 0f, 1f, 0.125f, 1f);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		ItemStack hand = player.getHeldItem();
		
		if (meta == 0) {
			if (tile instanceof TileStarLightAlter) {
				TileStarLightAlter alter = (TileStarLightAlter)tile;
				if(hand ==null && player.isSneaking()){
					player.addChatMessage("Number of linked reflectors is " + alter.getReflectors().size());
					player.addChatMessage("Amount of currently stored starlight is " + alter.getEnergy());
				}
				else
				if (!(alter.getStackInSlot(0) == null)) {
					EntityUtil.dropItem(alter.getStackInSlot(0), tile);
					alter.decrStackSize(0, alter.getStackInSlot(0).stackSize);
				}
				else
				if (hand != null && alter.isItemValidForSlot(0, hand)) {
					ItemStack newItem = player.getCurrentEquippedItem().copy();
					newItem.stackSize = 1;
					alter.setInventorySlotContents(0, newItem);
					player.setCurrentItemOrArmor(0, player.getCurrentEquippedItem().splitStack(1));
				}
				System.out.println(alter.printItem());
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
		
	@SideOnly(Side.CLIENT)
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
		if (tile instanceof TileStarLightAlter) {
			EntityUtil.dropItem(((TileStarLightAlter) tile).getStackInSlot(0), tile);
			((TileStarLightAlter) tile).removeAlter();
		}
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
		case 2:
		case 3:
		case 4:
			System.out.println("Reflector is created");
			return new TileStarLightReflector();
			
		default :
			System.out.println("Nothing!!");
			return null;
		
		}
		
	}
	
}
