package moonrise.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.ModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class SimpleItem extends Item {
	
	protected IModInfo info;
	
	String name;
	@SideOnly(Side.CLIENT)
	Icon icon;

	public SimpleItem(int id, String name, IModInfo info, CreativeTabs tab) {
		super(id);
		this.name = name;
		setCreativeTab(tab);
		setHasSubtypes(true);
		this.info = info;
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		return name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		register.registerIcon(info.getTexturePath() + name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(ItemStack item, int par2) {
		return icon;
	}

}
