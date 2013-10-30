package moonrise.celestialcraft.block;

import moonrise.celestialcraft.event.BlockPlaceEvent;
import moonrise.util.Coord;
import moonrise.util.SimpleBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

@Deprecated
public class BlockReceiver extends BlockCelestialCraft implements ITileEntityProvider {
	
	private EntityPlayer player;
	private int energy;
	public static final int MAX_ENERGY = 64000;

	public BlockReceiver(int id, String name) {
		super(id, name);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
		//BlockPlaceEvent evt = new BlockPlaceEvent(new Coord(x, y, z), item.itemID, item.getItemDamage());
		//MinecraftForge.EVENT_BUS.post(evt);
		
		if (entity instanceof EntityPlayer)
			this.player = (EntityPlayer) entity;
	}
	
	@Override
	public boolean hasTileEntity(int meta) {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		//System.out.println("Create TileReceiver");
		return new TileReceiver();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileReceiver tile;
		
		if (world.getBlockTileEntity(x, y, z) instanceof TileReceiver) {
			tile = (TileReceiver) world.getBlockTileEntity(x, y, z);
		} else return false;

		tile.showCoord();
		
		player.addChatMessage("Current stored star light : " + this.energy);
		
		player.addChatMessage("List of all linked antenna");
		
		for (Object antenna : tile.getAntennaList().toArray()) {
			//System.out.println("antenna is " + antenna.toString());
			player.addChatMessage("antenna is " + antenna.toString());
		}
		
		player.addChatMessage("this block has " + tile.getAntennaList().size() + " antennas");
		
		return true;
	}

	

}
