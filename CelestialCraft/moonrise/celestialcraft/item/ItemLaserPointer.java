package moonrise.celestialcraft.item;

import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.util.Coord;
import moonrise.util.RenderUtil;
import moonrise.util.Vec;
import net.minecraft.client.renderer.texture.IconRegister;
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
	public static final int MAX_ENERGY = 1000;
	private int charge;
	private static double pointerSize;
	private static String[] pointerTexture = { 
			
	};
	
	private Coord pointer;
	private Vec side;
	private int color;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemLaserPointer(int id, String name) {
		super(id, name);
		this.setMaxStackSize(1);
		this.energy = 0;
		this.charge = 0;
		this.pointerSize = ConfigHandler.idLense;
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!this.canOn())
			return false;
		
		this.pointer = new Coord(hitX, hitY, hitZ);
		this.side = Vec.fromSide(side);
		this.color = item.getItemDamage();
		
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		
		if (this.canOn()) {
			if (this.charge <= 1){
				this.energy--;
				this.charge = 100;
			}
			this.charge--;
			
			renderPointer(world, pointer, side, color);
		}
		
		return item;
	}
	
	private boolean canOn() {
		return !(this.energy <= 0 && this.charge <= 0);
	}
	
	@SideOnly(Side.CLIENT)
	private void renderPointer(World world, Coord coord, Vec side, int color) {
		RenderUtil.draw(new ResourceLocation(pointerTexture[color]), world, coord, side, pointerSize);
	}
	
	//    IToolStarLight
	
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

	@Override
	public void charge(ItemStack item, int amount) {
		if (this.energy + amount >= this.MAX_ENERGY) {
			this.energy = this.MAX_ENERGY;
			return;
		}
		this.energy += amount;
	}

	@Override
	public boolean isFull(ItemStack item) {
		return this.energy >= this.MAX_ENERGY;
	}

	@Override
	public int drain(ItemStack item, int amount) {
		if (this.energy <= amount)
			return energy;
		this.energy -= amount;
		return amount;
	}

}
