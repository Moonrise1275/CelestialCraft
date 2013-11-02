package moonrise.celestialcraft.entity;

import moonrise.util.Coord;
import moonrise.util.Cube;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityCeC extends Entity {
	
	public EntityCeC(World world, Coord coord, Cube cube) {
		super(world);
		this.setPosition(coord.getCenterX(), coord.getCenterY(), coord.getCenterZ());
		this.setSize(cube.getWidth(), cube.getHeigh());
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbtTag) {
		super.readFromNBT(nbtTag);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbtTag) {
		super.writeToNBT(nbtTag);
	}

}
