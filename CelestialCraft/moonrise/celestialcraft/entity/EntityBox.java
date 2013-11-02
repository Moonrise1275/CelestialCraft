package moonrise.celestialcraft.entity;

import moonrise.util.Coord;
import moonrise.util.Cube;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBox extends EntityCeC {

	public EntityBox(World world, Coord coord) {
		super(world, coord, new Cube(1, 1));
	}
	
	
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTag) {
		super.readFromNBT(nbtTag);
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTag) {
		super.writeToNBT(nbtTag);
	}

}
