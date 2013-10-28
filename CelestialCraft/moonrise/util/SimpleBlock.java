package moonrise.util;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class SimpleBlock extends Block {
	
	IModInfo info;

	public SimpleBlock(int id, String name, IModInfo info, CreativeTabs tab) {
		super(id, Material.rock);
		
		setCreativeTab(tab);
		setUnlocalizedName(name);
		this.info = info;
		this.icons = new Icon[6];
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	@SideOnly(Side.CLIENT)
	public static interface Sides {
		int BOT = 0, TOP = 1;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		icons[Sides.TOP] = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName() + "_Top");
		icons[Sides.BOT] = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName() + "_Bot");
		for (int i=2; i < 6; i++) {
			icons[i] = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName() + "_Sides");
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return icons[side];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		
	}

}
