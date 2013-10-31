package moonrise.util;

import net.minecraftforge.common.ForgeDirection;

public class Vec {
	
	public static final Vec 
	//+Y
	UP    = new Vec(ForgeDirection.UP),
	//-Y
	DOWN  = new Vec(ForgeDirection.DOWN),
	//-Z
	NORTH = new Vec(ForgeDirection.NORTH),
	//+Z
	SOUTH = new Vec(ForgeDirection.SOUTH),
	//+X
	EAST  = new Vec(ForgeDirection.EAST),
	//-X
	WEST  = new Vec(ForgeDirection.WEST),
	
	UNKNOWN = new Vec(ForgeDirection.UNKNOWN);
	
	public static Vec fromSide(int side) {
		switch(side) {
		case 0:
			return Vec.UP;
		case 1:
			return Vec.DOWN;
		case 2:
			return Vec.SOUTH;
		case 3:
			return Vec.NORTH;
		case 4:
			return Vec.EAST;
		case 5:
			return Vec.WEST;
		default:
			return Vec.UNKNOWN;
		}
	}
	
	public double x, y, z;
	
	public Vec(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vec(ForgeDirection forge) {
		this.x = forge.offsetX;
		this.y = forge.offsetY;
		this.z = forge.offsetZ;
	}
		
	public Vec opposite() {
		return new Vec(-x, -y, -z);
	}
	
	public Vec copy() {
		return new Vec(x, y, z);
	}
	
	public double getScalar(Vec vec) {
		return (this.x * vec.x) + (this.y * vec.y) + (this.z * vec.z);
	}
	
	public Vec multiple(double i) {
		return new Vec(x*i, y*i, z*i);
	}
	
	public Vec add(Vec vec) {
		return new Vec(this.x + vec.x, this.y + vec.y, this.z + vec.z);
	}
	
	public double length() {
		return Math.sqrt((x*x)+(y*y)+(z*z));
	}
	
	public Vec getUnitVector() {
		double len = this.length();
		return new Vec(x/len, y/len, z/len);
	}
	
	public Vec getCrossVectorHorizontal() {
		double a = x, b = y, c = z;
		double p = -Math.sqrt((a*a)/(a*a + b*b));
		double q = Math.sqrt((b*b)/(a*a + b*b));
		return new Vec(p, q, 0);
	}
	
	public Vec getCrossVectorVertical() {
		double a = x, b = y, c = z;
		double p = this.getCrossVectorHorizontal().x, q = this.getCrossVectorHorizontal().y;
		double n = Math.sqrt((p*p*c*c)/((q*q*c*c)+(p*p*c*c)+((q*a)-(p*b))*((q*a)-(p*b))));
		return new Vec(-((q*n)/p), n, (((q*a)-(p*b))/(p*c))*n);
	}

}
