package moonrise.celestialcraft.item;

import java.util.List;

import moonrise.celestialcraft.ModInfo;
import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.util.Coord;
import moonrise.util.EnumColors;
import moonrise.util.RenderUtil;
import moonrise.util.Vec;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLaserPointer extends ItemCelestialCraft implements IToolStarLight {
	
	private int energy;
	public static final int MAX_ENERGY = 500;
	private int charge;
	private static double pointerSize;
	private static String[] pointerTextures = { 
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.black.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.red.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.green.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.brown.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.blue.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.purple.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.cyan.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.silver.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.gray.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.pink.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.lime.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.yellow.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.lightBlue.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.magenta.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.orange.str() + ".png",
		"textures/misc/" + "laser_pointer/pointer_" + EnumColors.white.str() + ".png"
	};
	
	private Coord pointer;
	private Vec side;
	private int color;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	@SideOnly(Side.CLIENT)
	private Icon[] pointers;

	public ItemLaserPointer(int id, String name) {
		super(id, name);
		this.setMaxStackSize(1);
		this.icons = new Icon[16];
		this.pointers = new Icon[16];
		this.energy = 0;
		this.charge = 0;
		this.pointerSize = ConfigHandler.pointerSize;
		this.setMaxDamage(this.MAX_ENERGY);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (player.isSneaking()) {
			int i = this.getDamage(item);
			if (++i > 16)
				i = 1;
			this.setDamage(item, i);
			return true;
		}
		if (!this.canOn())
			return false;
		
		this.pointer = new Coord(hitX, hitY, hitZ);
		this.side = Vec.fromSide(side);
		this.color = item.getItemDamage()%16;
		
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		
		if (this.canOn()) {
			if (this.charge <= 1){
				this.setDamage(item, item.getItemDamage() -16);
				this.charge = 1;
			}
			this.charge--;
			
			renderPointer(world, pointer, side, color);
		}
		
		return item;
	}
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int par4, boolean par5) {
		this.energy = item.getItemDamage()/16;
		this.color = item.getItemDamage()%16;
	}
	
	private boolean canOn() {
		return !(this.energy <= 0 && this.charge <= 0);
	}
	
	public boolean isDamageable() {
		return true;
	}
	
	public boolean isRepairable() {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getDisplayDamage(ItemStack item) {
		return item.getItemDamage() / this.pointerTextures.length;
	}
	
	
	@SideOnly(Side.CLIENT)
	private void renderPointer(World world, Coord coord, Vec side, int color) {
		RenderUtil.draw(this.pointers[color], world, coord, side, pointerSize);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
		list.add(new ItemStack(id, 1, 8000));
	}
	
	//    IToolStarLight
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		for (int i=0; i<icons.length; i++) {
			icons[i] = register.registerIcon(ModInfo.TEXTURE_PATH + getUnlocalizedName() + "_" + EnumColors.values()[i]);
			pointers[i] = register.registerIcon(ModInfo.TEXTURE_PATH + "Pointer_" + EnumColors.values()[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack item, int meta) {
		return icons[meta%this.pointerTextures.length];
	}

	@Override
	public void charge(ItemStack item, int amount) {
		if (this.energy + amount >= this.MAX_ENERGY) {
			this.energy = this.MAX_ENERGY;
			return;
		}
		this.setDamage(item, item.getItemDamage() + (amount*16));
	}

	@Override
	public boolean isFull(ItemStack item) {
		return this.energy >= this.MAX_ENERGY;
	}

	@Override
	public int drain(ItemStack item, int amount) {
		if (this.energy <= amount) {
			this.setDamage(item, color);
			return energy;
		}
		this.setDamage(item, item.getItemDamage() - (amount*16));
		return amount;
	}

}
