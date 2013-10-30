package moonrise.celestialcraft.item;

import java.util.List;

import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.celestialcraft.skyobject.SkyUtil;
import moonrise.util.PlayerUtil;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTelescope extends ItemCelestialCraft implements IToolStarLight {
	
	private int energy;
	public static final int[] MAX_ENERGY = { 400, 400, 400, 400, 400, 400, 400, 400, 400  };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons = new Icon[SCOPE_LENGTH];
	
	private float accuracy;
	
	public ItemTelescope(int id, String name) {
		super(id, name);
		this.setMaxStackSize(1);
		this.energy = 0;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		Vec3 vec = player.getLookVec();
		if (!world.isRaining() &&
			 world.canBlockSeeTheSky(player.chunkCoordX, player.chunkCoordY, player.chunkCoordZ) &&
			!world.isDaytime() &&
			 vec.yCoord > 0) {
			player.setItemInUse(item, this.getMaxItemUseDuration(item));
		}
		PlayerUtil.viewScope(player);
		return item;
	}
	
	
	@Override
	public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int useCount) {
		Vec3 vec = player.getLookVec();
		Object stellar = SkyUtil.getStellarFromVec3(world, vec);
		
	}
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz) {
		
		int thisBlockId = world.getBlockId(x, y, z);
		
		List droppedItemList = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(hitx - 0.5, hity - 0.5, hitz - 0.5, hitx + 0.5, hity + 0.5, hitz + 0.5));
		if (droppedItemList.size() == 1 &&  droppedItemList.get(0) instanceof EntityItem) {
			EntityItem entity = (EntityItem) droppedItemList.get(0);
			if (entity.getEntityItem().equals(new ItemStack(Item.map))) {
				entity.setEntityItemStack(new ItemStack(ModItems.itemMap));
			}
		}
		
		
		return false;
	}
	
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		icons[SCOPE_WOOD]       = register.registerIcon(info.getTexturePath() + "SCOPE_WOOD");
		icons[SCOPE_IRON]       = register.registerIcon(info.getTexturePath() + "SCOPE_IRON");
		icons[SCOPE_GOLD]       = register.registerIcon(info.getTexturePath() + "SCOPE_GOLD");
		icons[SCOPE_DIAMOND]    = register.registerIcon(info.getTexturePath() + "SCOPE_DIAMOND");
		icons[SCOPE_ALUMINIUM]  = register.registerIcon(info.getTexturePath() + "SCOPE_ALUMINIUM");
		icons[SCOPE_BRASS]      = register.registerIcon(info.getTexturePath() + "SCOPE_BRASS");
		icons[SCOPE_COPPER]     = register.registerIcon(info.getTexturePath() + "SCOPE_COPPER");
		icons[SCOPE_GREATWOOD]  = register.registerIcon(info.getTexturePath() + "SCOPE_GREATWOOD");
		icons[SCOPE_SILVERWOOD] = register.registerIcon(info.getTexturePath() + "SCOPE_SILVERWOOD");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack item, int par2) {
		return icons[item.getItemDamage()];
	}
	
	public static final int
	SCOPE_WOOD = 0,
	SCOPE_IRON = 1,
	SCOPE_GOLD = 2,
	SCOPE_DIAMOND = 3,
	SCOPE_ALUMINIUM = 4,
	SCOPE_BRASS = 5,
	SCOPE_COPPER = 6,
	SCOPE_GREATWOOD = 7,
	SCOPE_SILVERWOOD = 8,
	SCOPE_LENGTH = 9;

	//   IToolStarLight
	
	@Override
	public void charge(ItemStack item, int amount) {
		if ((this.energy + amount) >= this.MAX_ENERGY[item.getItemDamage()]) {
			this.energy = this.MAX_ENERGY[item.getItemDamage()];
		}
		this.energy += amount;
	}

	@Override
	public boolean isFull(ItemStack item) {
		return this.energy >= this.MAX_ENERGY[item.getItemDamage()]; 
	}

	@Override
	public int drain(ItemStack item, int amount) {
		if (this.energy <= amount) {
			Integer e = new Integer(energy);
			this.energy = 0;
			return e;
		}
		this.energy -= amount;
		return amount;
	}


}
