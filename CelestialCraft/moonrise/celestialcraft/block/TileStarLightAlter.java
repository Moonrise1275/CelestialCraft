package moonrise.celestialcraft.block;

import java.util.HashSet;

import moonrise.celestialcraft.interfaces.IToolStarLight;
import moonrise.util.Coord;
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
	
	public TileStarLightAlter() {
		this.item = null;
		this.energy = 0;
		this.reflectors = new HashSet<TileStarLightReflector>();
	}
	
	@Override
	public void updateEntity() {
		addEnergy();
		chargeTool();
		sendEnergy();
	}
	
	
	
	public void addReflector(TileStarLightReflector tile) {
		this.reflectors.add(tile);
	}
	
	private void addEnergy() {
		for (TileStarLightReflector tile : reflectors) {
			int amount = tile.getEnergy();
			if ((this.energy + amount) <=this.MAX_ENERGY)
				this.energy += amount;
			else this.energy = this.MAX_ENERGY;
		}
	}
	
	public void setItem(ItemStack item) {
		
	}
	
	public boolean isEmpty() {
		return this.item == null;
	}
	
	private void chargeTool() {
		
	}
	
	private void sendEnergy() {
		
	}
	
	public void removeAlter() {
		for (TileStarLightReflector tile : reflectors) {
			tile.removeAlter();
		}
	}
	public void removeReflector(TileStarLightReflector tile) {
		this.reflectors.remove(tile);
	}
	
	public void printReflectors() {
		System.out.println("Number of reflectors : " + reflectors.size());
		
		for (TileStarLightReflector tile : reflectors) {
			System.out.println(tile);
		}
	}
	
	//methodes of IInventory

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.item;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return this.item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.item = itemstack;
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
		return true;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if (itemstack.getItem() instanceof IToolStarLight)
			return true;
		return true;
	}
	
}
