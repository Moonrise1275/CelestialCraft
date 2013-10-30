package moonrise.celestialcraft.block;

import java.util.HashSet;

import moonrise.util.Coord;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileStarLightAlter extends TileCeC {
	
	private int energy;
	public static final int MAX_ENERGY = 2560000;
	public ItemStack tool;
	private HashSet<TileStarLightReflector> reflectors;
	
	public TileStarLightAlter() {
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
	
	
	
}
