package moonrise.celestialcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCelestialMap extends ItemCelestialCraft {

	public ItemCelestialMap(int id, String name) {
		super(id, name);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		
		
		return item;
	}

}
