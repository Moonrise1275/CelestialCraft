package moonrise.celestialcraft.entity;

import moonrise.celestialcraft.handler.ConfigHandler;
import moonrise.util.Coord;
import moonrise.util.Cube;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBomb extends EntityCeC {
	
	private int time;
	private int tick;
	private float explodeStrength;
	
	public EntityBomb(World par1World, Coord coord, int time, float explodeStrength) {
		super(par1World, coord, new Cube(0.01F, 0.01F));
		
		this.time = time;
		this.explodeStrength = explodeStrength;
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbtTag) {
				
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbtTag) {
		
	}
	
	@Override
	public void onUpdate() {
		tick++;
		if (tick < time)
			return;
		if (!this.worldObj.isRemote)
			explode();
	}
	
	private void explode()
    {
        float f = this.explodeStrength;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
    }

}
