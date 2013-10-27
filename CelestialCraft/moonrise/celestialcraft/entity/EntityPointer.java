package moonrise.celestialcraft.entity;

import moonrise.util.Coord;
import moonrise.util.Cube;
import net.minecraft.world.World;

public class EntityPointer extends EntityCeC {

	public EntityPointer(World world, Coord coord, String color) {
		super(world, coord, new Cube(0.1F, 0.1F));
	}

}
