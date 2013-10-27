package moonrise.util;

public class Coord {
	
	private int x, y, z;
	
	public Coord (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Coord (Coord other) {
		this(other.getX(), other.getY(), other.getZ());
	}
	public Coord (int[] other) {
		this(other[0], other[1], other[2]);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	
	public float getCenterX() {
		return x + 0.5F;
	}
	public float getCenterY() {
		return y + 0.5F;
	}
	public float getCenterZ() {
		return z + 0.5F;
	}
	
	public double getDistance(Coord otherCoord) {
		return Math.sqrt( (x*x) + (y*y) + (z*z) );
	}
	public double getDistance(int xCoord, int yCoord, int zCoord) {
		return this.getDistance(new Coord(xCoord, yCoord, zCoord));
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Coord) {
			Coord other = (Coord) obj;
			if (other.getX() == this.getX() &&
				other.getY() == this.getY() &&
				other.getZ() == this.getZ()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Coord:(" + x + "," + y + "," + z + ")";
	}
	
	public int[] toArray() {
		int[] array = new int[3];
		array[0] = x;
		array[1] = y;
		array[2] = z;
		return array;
	}
	
	@Override
	public int hashCode() {
		return y;
	}

}
