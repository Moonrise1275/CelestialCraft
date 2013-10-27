 package moonrise.util;

public interface IModInfo {
	
	public String getModId();
	public String getModName();
	public String getVersion();
	public String getDepend();
	
	public String getChannel();
	
	public String getPathCommonProxy();
	public String getPathClientProxy();
	
	public int getBasicBlockId();
	public int getBasicItemId();
	
	public String getTexturePath();

}
