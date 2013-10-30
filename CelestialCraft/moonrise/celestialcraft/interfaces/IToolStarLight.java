package moonrise.celestialcraft.interfaces;

import net.minecraft.item.ItemStack;

public interface IToolStarLight {
	
	public void charge(ItemStack item, int amount);
	
	public boolean isFull(ItemStack item);
	
	int drain(ItemStack item, int amount);
	
	

}
