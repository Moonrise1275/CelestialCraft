package moonrise.celestialcraft;

import moonrise.util.IModInfo;

public class ModInfo implements IModInfo {
	
	public static final String MOD_ID = "CelestialCraft_by_TeamCitizen";
	public static final String MOD_NAME = "CelestialCraft";
	public static final String VERSION = "0.1.2";
	public static final String DEPEND = "";
	
	public static final String CHANNEL = "CeC";
	
	public static final String COMMON_PROXY = "moonrise.celestialcraft.proxy.CommonProxy";
	public static final String CLIENT_PROXY = "moonrise.celestialcraft.proxy.ClientProxy";
	
	public static final int BASIC_BLOCK_ID = 3800;
	public static final int BASIC_ITEM_ID = 27800;
	
	public static final String TEXTURE_PATH = "CelestialCraft:";
	
	
	
	
	@Override
	public String getModId() {
		return this.MOD_ID;
	}

	@Override
	public String getModName() {
		return this.MOD_NAME;
	}

	@Override
	public String getVersion() {
		return this.VERSION;
	}

	@Override
	public String getDepend() {
		return this.DEPEND;
	}

	@Override
	public String getChannel() {
		return this.CHANNEL;
	}

	@Override
	public String getPathCommonProxy() {
		return this.COMMON_PROXY;
	}

	@Override
	public String getPathClientProxy() {
		return this.CLIENT_PROXY;
	}

	@Override
	public int getBasicBlockId() {
		return this.BASIC_BLOCK_ID;
	}

	@Override
	public int getBasicItemId() {
		return this.BASIC_ITEM_ID;
	}

	@Override
	public String getTexturePath() {
		return this.TEXTURE_PATH;
	}

}
