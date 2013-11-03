package moonrise.celestialcraft.block;

import java.util.HashSet;

import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.util.Coord;
import moonrise.util.EntityUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileStarLightAlter extends TileCeC implements IInventory {
	
	private ItemStack item;
	private int energy;
	public static final int MAX_ENERGY = 2560000;
	public ItemStack tool;
	private HashSet<TileStarLightReflector> reflectors;
	public int cubeTick, coreTick;
	
	public TileStarLightAlter() {
		this.item = null;
		this.energy = 0;
		this.reflectors = new HashSet<TileStarLightReflector>();
		this.cubeTick = this.coreTick = 0;
	}
	
	@Override
	public void updateEntity() {
		addEnergy();
		chargeTool(10);
		sendEnergy(10);
		
		if (this.cubeTick >= 150)
			this.cubeTick -= 150;
		if (this.coreTick >= 120)
			this.coreTick -= 120;
		cubeTick++; coreTick++ ;
		
	}
	
	
	
	public void addReflector(TileStarLightReflector tile) {
		this.reflectors.add(tile);
		System.out.println("Reflector is added");
	}
	
	private void addEnergy() {
		for (TileStarLightReflector tile : reflectors) {
			int amount = tile.getEnergy();
			if ((this.energy + amount) <=this.MAX_ENERGY)
				this.energy += amount;
			else this.energy = this.MAX_ENERGY;
		}
	}
	
	public String printItem() {
		if (this.item == null)
			return "nothing here";
		return this.item.toString();
	}
	
	private void chargeTool(int i) {
		if (this.item != null && item.getItem() instanceof IToolStarLight) {
			IToolStarLight tool = (IToolStarLight) item.getItem();
			if (!tool.isFull(item))
				tool.charge(item, i);
		}
	}
	
	private void sendEnergy(int i) {
		
	}
	
	public void removeAlter() {
		for (TileStarLightReflector tile : reflectors) {
			tile.removeAlter();
		}
	}
	public void removeReflector(TileStarLightReflector tile) {
		this.reflectors.remove(tile);
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public HashSet<TileStarLightReflector> getReflectors() {
		return this.reflectors;
	}
	
	public void printReflectors() {
		System.out.println("Number of reflectors : " + reflectors.size());
		
		for (TileStarLightReflector tile : reflectors) {
			System.out.println(tile);
		}
	}
	
	//   IInventory

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.item;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack result = this.getStackInSlot(slot).copy();
		if (result != null) {
			if (result.stackSize <= amount) {
				setInventorySlotContents(slot, null);
			} else {
				result = result.splitStack(amount);
			}
			this.onInventoryChanged();
		}
		return result;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack result = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return result;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.item = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			EntityUtil.dropItem(itemstack.splitStack(this.getInventoryStackLimit()), this);
			itemstack.stackSize = getInventoryStackLimit();
		}
		this.onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "Starlight Alter";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return new Coord(entityplayer).getDistance(new Coord(this.xCoord, this.yCoord, this.zCoord).getCenter()) <= 32;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
}
