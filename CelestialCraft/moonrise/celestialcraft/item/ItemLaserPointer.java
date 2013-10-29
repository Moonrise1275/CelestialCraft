package moonrise.celestialcraft.item;

import moonrise.celestialcraft.entity.EntityPointer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLaserPointer extends ItemCelestialCraft {
	
	private EntityPointer pointer;
	private int charge;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemLaserPointer(int id, String name) {
		super(id, name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		
		
		
		return item;
	}
	
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		for (int i=0; i<icons.length; i++) {
			icons[i] = register.registerIcon(getUnlocalizedName() + "_" + ItemDye.dyeItemNames[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack item, int meta) {
		return icons[meta];
	}

}
