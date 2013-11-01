package moonrise.util;

public enum EnumColors {
	
	black, red, green, brown, blue, purple, cyan, silver, gray, pink, lime, yellow, lightBlue, magenta, orange, white;
	
	private EnumColors() {}
	
	public int num() {
		return this.ordinal();
	}
	
	public String str() {
		return this.toString();
	}

}
