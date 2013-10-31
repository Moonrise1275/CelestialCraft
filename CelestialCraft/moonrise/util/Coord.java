package moonrise.util;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class Coord {
	
	private double x, y, z;
	private Vec direction;
	
	public Coord (double x, double y, double z, Vec direction) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.direction = direction;
	}
	public Coord (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.direction = Vec.UNKNOWN;
	}
	public Coord (Coord other) {
		this(other.getX(), other.getY(), other.getZ());
	}
	public Coord (double[] other) {
		this(other[0], other[1], other[2]);
	}
	public Coord (int[] other) {
		this(other[0], other[1], other[2]);
	}
	public Coord(Entity entity) {
		this(entity.posX, entity.posY, entity.posZ);
	}
	public Coord(TileEntity tile) {
		this(tile.xCoord, tile.yCoord, tile.zCoord);
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	public Vec getDir() {
		return direction;
	}
	
	public int intX() {
		return new Double(this.x).intValue();
	}
	public int intY() {
		return new Double(this.y).intValue();
	}
	public int intZ() {
		return new Double(this.z).intValue();
	}
	
	public Coord getCenter(Coord other) {
		Coord center = new Coord((this.x + other.getX())/2, (this.y + other.getY())/2, (this.z + other.getCenterZ())/2);
		return center;
	}
	
	public Coord getCenter() {
		return new Coord(getCenterX(), getCenterY(), getCenterZ());
	}
	public double getCenterX() {
		return x + 0.5;
	}
	public double getCenterY() {
		return y + 0.5;
	}
	public double getCenterZ() {
		return z + 0.5;
	}
	
	public Coord getCenterPoint(Coord other) {
		return new Coord((x+other.x)/2, (y+other.y)/2, (z+other.z)/2);
	}
	
	public double getDistance(Coord otherCoord) {
		return this.getDistance(otherCoord.x, otherCoord.y, otherCoord.z);
	}
	public double getDistance(double xCoord, double yCoord, double zCoord) {
		return Math.sqrt(x * xCoord + y * yCoord + z * zCoord);
	}
	
	public Coord getMax(Coord other) {
		return new Coord(Math.max(this.x, other.getX()), Math.max(this.y, other.getY()), Math.max(this.z, other.getZ()));
	}
	public Coord getMin(Coord other) {
		return new Coord(Math.min(this.x, other.getX()), Math.min(this.y, other.getY()), Math.min(this.z, other.getZ()));
	}
	
	public Coord add(double x, double y, double z) {
		return new Coord(this.x + x, this.y + y, this.z + z);
	}
	public Coord add(Vec vec) {
		return this.add(vec.x, vec.y, vec.z);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Coord) {
			Coord other = (Coord) obj;
			if (other.getX() == this.getX() &&
				other.getY() == this.getY() &&
				other.getZ() == this.getZ() &&
				other.getDir() == this.getDir()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Coord:(" + x + "," + y + "," + z + ")";
	}
	
	public int[] toIntArray() {
		int[] array = new int[3];
		array[0] = this.intX();
		array[1] = this.intY();
		array[2] = this.intZ();
		return array;
	}
	
	@Override
	public int hashCode() {
		return new Double(y).hashCode();
	}

}
