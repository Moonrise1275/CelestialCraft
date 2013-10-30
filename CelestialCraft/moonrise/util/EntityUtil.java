package moonrise.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EntityUtil {
	
	public static void dropItem(ItemStack item, Entity entity)                {dropItem(entity.worldObj, item, new Coord(entity));}
	public static void dropItem(ItemStack item, TileEntity tile) {dropItem(tile.worldObj, item, new Coord(tile).getCenter());}
	public static void dropItem(World world, ItemStack item, Coord coord) {
		if (!(item == null))
			world.spawnEntityInWorld(new EntityItem(world, coord.getX(), coord.getY(), coord.getZ(), item));
	}

}
