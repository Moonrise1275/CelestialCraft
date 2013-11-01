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

public abstract class SimpleBlock extends Block {
	
	IModInfo info;
	Boolean isSimpleTexture;

	public SimpleBlock(int id, String name, IModInfo info, CreativeTabs tab) {
		super(id, Material.rock);
		
		setCreativeTab(tab);
		setUnlocalizedName(name);
		this.info = info;
		this.icons = new Icon[6];
		this.isSimpleTexture = false;
	}
	
	protected void setSimpleTexture() {
		this.isSimpleTexture = true;
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	@SideOnly(Side.CLIENT)
	private Icon simple;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		if (this.isSimpleTexture) {
			this.simple = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName());
			return;
		}
		
		for (EnumSides side : EnumSides.values()) {
			Icon i;
			switch(side) {
			case top:
				i = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName() + "_Top");
				break;
			case bottom:
				i = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName() + "_Bottom");
				break;
			default:
				i = register.registerIcon(info.getTexturePath() + this.getUnlocalizedName() + "_Side");
				break;
			}
			this.icons[side.num()] = i;
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if (this.isSimpleTexture)
			return simple;
		else return icons[side];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public abstract void getSubBlocks(int id, CreativeTabs tab, List list);

}
