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

public class TileReceiver extends TileCeC {
	
	public static final int MAX_ENERGY = 64000;
	
	//Pivate EntityPlayer player;
	private HashSet<Coord> antennaList = new HashSet<Coord>();
	private int energy;
	
	public TileReceiver() {
		//this.player = player;
	}
	
	@Override
	@ForgeSubscribe
	public void someBlockPlaced(BlockPlaceEvent event) {
		if (event.id == ConfigHandler.getInst().idBlockAntenna) {
			double distance = event.coord.getDistance(xCoord, yCoord, zCoord);
			if (event.coord.getY() == this.yCoord && distance <= ConfigHandler.getInst().antennaDistance) {
				antennaList.add(event.coord);
			}
		} else if (event.id == ConfigHandler.getInst().idBlockReceiver) {
			double distance = event.coord.getDistance(xCoord, yCoord, zCoord);
			if (distance <= 2* ConfigHandler.getInst().antennaDistance) {
				this.worldObj.spawnEntityInWorld(new EntityBomb(this.worldObj, event.coord, 1, ConfigHandler.getInst().receiverExplosionStrength));
			}
		}
	}
	
	@Override
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
			energyProduce += this.worldObj.getBlockMetadata(antenna.getX(), antenna.getY(), antenna.getZ());
		}
		this.addEnergy(energyProduce);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTag) {
		//nbtTag.setString("Player", player.username);
		nbtTag.setInteger("Size", antennaList.size());
		int i=0;
		for (Coord antenna : antennaList) {
			nbtTag.setIntArray("Antenna" + i++, antenna.toArray());
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
