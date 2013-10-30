package moonrise.celestialcraft.block;

import moonrise.celestialcraft.PlayerCeC;
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
@Deprecated
public class BlockAntenna extends BlockCelestialCraft {
	

	public BlockAntenna(int id, String name) {
		super(id, name);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase mayPlayer, ItemStack item) {
		
		if (!(mayPlayer instanceof EntityPlayer)) {
			world.destroyBlock(x, y, z, true);
			return;
		} 
		
		BlockPlaceEvent event = new BlockPlaceEvent(new Coord(x, y, z), this.blockID, item.getItemDamage());
		MinecraftForge.EVENT_BUS.post(event);
			
	}
	
}
