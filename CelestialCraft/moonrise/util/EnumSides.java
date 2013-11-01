package moonrise.util;

public enum EnumSides {
	
	bottom, top, north, south, west, east;
	
	private EnumSides() {}
	
	public int num() {
		return this.ordinal();
	}
	
	public String str() {
		return this.toString();
	}

}
