package moonrise.celestialcraft.item;

import moonrise.celestialcraft.ModInfo;
import moonrise.celestialcraft.block.TileStarLightReflector;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemReflectorUpgrade extends ItemCelestialCraft {
	
	ModInfo info = new ModInfo();
	private Icon[] icons;
	String[] types = TileStarLightReflector.types;

	public ItemReflectorUpgrade(int id, String name) {
		super(id, name);
		this.icons = new Icon[types.length];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		for (int i=0;i<types.length - 1;i++) {
			icons[i] = register.registerIcon(info.TEXTURE_PATH + "Reflector_Upgrade_" + types[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(ItemStack item, int par2) {
		return icons[item.getItemDamage()];
	}

}
