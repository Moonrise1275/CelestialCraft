package moonrise.celestialcraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLaserPointer extends ItemCelestialCraft {
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemLaserPointer(int id, String name) {
		super(id, name);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		
	}

}
