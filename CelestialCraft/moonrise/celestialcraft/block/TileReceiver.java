package moonrise.celestialcraft.block;

import java.util.HashSet;

import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.entity.EntityBomb;
import moonrise.celestialcraft.event.BlockBreakEvent;
import moonrise.celestialcraft.event.BlockPlaceEvent;
import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.util.Coord;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.ForgeSubscribe;
@Deprecated
public class TileReceiver extends TileCeC {
	
	public static final int MAX_ENERGY = 64000;
	
	//Pivate EntityPlayer player;
	private HashSet<Coord> antennaList = new HashSet<Coord>();
	private int energy;
	
	public TileReceiver() {
		//this.player = player;
		this.showCoord();
		
	}
	
	public void showCoord() {
		System.out.println(this.worldObj != null);
		System.out.println(this.xCoord);
		System.out.println(this.yCoord);
		System.out.println(this.zCoord);
	}
	
	@ForgeSubscribe
	public void someBlockPlaced(BlockPlaceEvent event) {
		System.out.println("[CelestialCraft] BlockPlaceEvent is occured!");
		System.out.println(event.id + " , " + event.meta);
		if (event.id == ConfigHandler.getInst().idBlockAntenna) {
			System.out.println("[CelestialCraft] Placed block is Antenna");
			double distance = event.coord.getDistance(xCoord, yCoord, zCoord);
			showCoord();
			System.out.println(event.coord.intY() + " != " + this.yCoord);
			if (event.coord.getY() == this.yCoord && distance <= (double) ConfigHandler.getInst().antennaDistance) {
				System.out.println("[CelestialCraft] Add antenna to receiver");
				antennaList.add(event.coord);
				System.out.println("[CelestialCraft] " + antennaList.size());
			}
		} else if (event.id == ConfigHandler.getInst().idBlockReceiver) {
			System.out.println("Placed block is Receiver");
			double distance = event.coord.getDistance(xCoord, yCoord, zCoord);
			if (distance <= 2* ConfigHandler.getInst().antennaDistance && event.coord != new Coord(this.xCoord, this.yCoord, this.zCoord)) {
				//this.worldObj.spawnEntityInWorld(new EntityBomb(this.worldObj, event.coord, 1, ConfigHandler.getInst().receiverExplosionStrength));
				//System.out.println("BOOOOOOOOOOOOOM");
			}
		} else System.out.println("Notthing is occured!");
		
		//event.setCanceled(true);
	}
	
	@ForgeSubscribe
	public void someBlockBroken(BlockBreakEvent event) {
		if (event.id ==  ConfigHandler.getInst().idBlockAntenna && antennaList.contains(event.coord)) {
			antennaList.remove(event.coord);
		}
	}
	
	@Override
	public void updateEntity() {
		
		int energyProduce = 0;
		
		for (Coord antenna : antennaList) {
			CelestialCraft.proxy.renderRay(new Coord(xCoord, yCoord, zCoord), antenna);
			energyProduce += this.worldObj.getBlockMetadata(antenna.intX(), antenna.intY(), antenna.intZ());
		}
		this.addEnergy(energyProduce);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTag) {
		//nbtTag.setString("Player", player.username);
		nbtTag.setInteger("Size", antennaList.size());
		int i=0;
		for (Coord antenna : antennaList) {
			nbtTag.setIntArray("Antenna" + i++, antenna.toIntArray());
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTag) {
		//this.player = this.worldObj.getPlayerEntityByName(nbtTag.getString("Player"));
		for (int i=0; i<nbtTag.getInteger("Size"); i++) {
			antennaList.add(new Coord(nbtTag.getIntArray("Antenna" + i)));
		}
	}
	
	public HashSet<Coord> getAntennaList() {
		return this.antennaList;
	}
	
	private boolean addEnergy(int amount) {
		if (this.energy >= this.MAX_ENERGY) {
			this.energy = this.MAX_ENERGY;
			return false;
		} else if ((this.energy + amount) >= this.MAX_ENERGY) {
			this.energy = this.MAX_ENERGY;
			return true;
		} else {
			this.energy += amount;
			return true;
		}
	}
}
