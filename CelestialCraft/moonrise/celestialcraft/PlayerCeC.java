package moonrise.celestialcraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.sound.sampled.LineUnavailableException;

import moonrise.celestialcraft.exception.InvalidFileException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import net.minecraftforge.common.FakePlayerFactory;

public class PlayerCeC implements Serializable {
	
	//----------------------------------statics-----------------------------------------------
	
	private static HashMap<String, PlayerCeC> playerList = new HashMap<String, PlayerCeC>();
	public static String MASTER_NAME = "Master_Astronomer";
	
	public static HashMap<String, PlayerCeC> getList() {
		return playerList;
	}
	
	public static PlayerCeC getPlayer(EntityPlayer player) {
		return getPlayer(player.username);
	}
	public static PlayerCeC getPlayer(String key) {
		return playerList.get(key);
	}
	
	public static PlayerCeC getMasterPlayer() {
		return getPlayer("Master_Astronomer");
	}
	
	public static boolean addPlayer(EntityPlayer player) {
		return addPlayer(player.username);
	}
	public static boolean addPlayer(String player) {
		if (playerList.containsKey(player))
			return false;
		PlayerCeC newPlayer = new PlayerCeC(player);
		playerList.put(player, newPlayer);
		return true;
	}
	
	public static void addMasterPlayer(World world) {
		if (!addPlayer(MASTER_NAME))
			return;
		
		PlayerCeC masterPlayer = getPlayer(MASTER_NAME);
		
		HashMap<String, ResearchInfo> researchList = masterPlayer.researchMap;
		HashMap<String, StellarInfo>  stellarList  = masterPlayer.stellarMap;
		
		for (StellarInfo stellar : stellarList.values()) {
			stellar.observe(masterPlayer, world);
		}
		
		for (ResearchInfo research : researchList.values()) {
			research.study(masterPlayer);
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void loadListFromFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException, InvalidFileException {
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object obj = in.readObject();
		if (obj instanceof HashMap<?, ?> && ((HashMap) obj).containsKey("Master_Astronomer")) {
			HashMap<String, PlayerCeC> playerMap = (HashMap<String, PlayerCeC>) obj;
			playerList.putAll(playerMap);
			
		} else {
			//throw new InvalidFileException(file);
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void saveListIntoFile(File file, File oldFile) throws IOException {
		File thisFile = new File(file.getPath());
		if (thisFile.exists()) {
			if (oldFile.exists())
				oldFile.delete();
			thisFile.renameTo(oldFile);
		}
		System.out.println("[CelestialCraft] Saving CelestialData");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(playerList);
		
	}
	
	//----------------------------- non-statics ----------------------------------------------
	
	private String player;
	private int researchPoint_Optics;
	private int researchPoint_Engineering;
	private int researchPoint_Material;
	
	private HashMap<String, ResearchInfo> researchMap = new HashMap<String, ResearchInfo>();
	private HashMap<String, StellarInfo> stellarMap   = new HashMap<String, StellarInfo>();
	
	
	private PlayerCeC(EntityPlayer player) {
		this(player.username);
	}
	private PlayerCeC(String name) {
		this.player = name;
		this.researchPoint_Optics = 0;
		this.researchPoint_Engineering = 0;
		this.researchPoint_Material = 0;
		
		initStellarMap();
		initResearchMap();
	}
	
	public ResearchInfo getResearch(String name) {
		return researchMap.get(name); }
	public boolean isResearchStudied(String name) {
		return researchMap.get(name).isStudied(); }
	
	public StellarInfo getStellar(String name) {
		return stellarMap.get(name); }
	public boolean isStellarObserved(String name) {
		return stellarMap.get(name).isObserved(); }
	
	public static String OPTICS = "Optics";
	public static String ENGINEERING = "Engineering";
	public static String MATERIAL = "Material";
	public int getPoint(String study) {
		     if (study.equals("Optics") || study.equals("optics"))
			return this.researchPoint_Optics;
		else if (study.equals("Engineering") || study.equals("engineering"))
			return this.researchPoint_Engineering;
		else if (study.equals("Material") || study.equals("material"))
			return this.researchPoint_Material;
		return 0;
	}
	
	
	@Override
	public int hashCode() {
		return player.hashCode();
	}
	
	@Override
	public String toString() {
		return this.player;
	}
	
	//---------------------------stellar info class----------------------------------------
	
	//someone should fill this method, hahaha
	private void initStellarMap() {
		
		add("Polaris", 5, 5, 5, "");
		
		
		
	}
	
	
	
	private void add(String name, int optics, int engineering, int material, String research) {
		stellarMap.put(name, new StellarInfo(name, optics, engineering, material, research));
	}
	
	private class StellarInfo implements Serializable {
		
		public final String name;
		public final int getResearchPoint_Optics;
		public final int getResearchPoint_Engineering;
		public final int getResearchPoint_Material;
		public final String research;
		
		private boolean isObserved;
		
		public StellarInfo(String name, int optics, int engineering, int material, String research) {
			this.name= name;
			this.getResearchPoint_Optics = optics;
			this.getResearchPoint_Engineering = engineering;
			this.getResearchPoint_Material = material;
			this.research = research;
			
			this.isObserved = false;
		}
		
		public void observe(PlayerCeC player, World world) {
			this.isObserved = true;
			player.researchPoint_Optics += this.getResearchPoint_Optics;
			player.researchPoint_Engineering += this.getResearchPoint_Engineering;
			player.researchPoint_Material += this.getResearchPoint_Material;
			EntityPlayer user = world.getPlayerEntityByName(player.player);
			
			for (ResearchInfo research : player.researchMap.values()) {
				if (!research.isStudied && research.study(player)) {
					System.out.println("[CelestialCraft] : " + player.toString() + " studied " + research.toString() + "!");
					if (user != null) {
						user.addChatMessage("You found a new research!! it's name is " + research.toString());
						user.addChatMessage("Check your Celestial Map!");
					}
				}
			}
		}
		
		public boolean isObserved() {
			return this.isObserved;
		}
	}
	
	//--------------------------------research info class--------------------------------------------
	
	//this method should be filled too hahahahahahahahaha
	private void initResearchMap() {
		
		add("Optics", "optics", 0, 0, 0);
		add("Engineering", "engineering", 1, 0, 0);
		add("Material", "material", 1, 1, 0);
		
		
		
		
	}
	private void add(String name, String icon, int optics, int engineering, int material) {
		researchMap.put(name, new ResearchInfo(name, icon, optics, engineering, material));
	}
	
	private class ResearchInfo implements Serializable {
		
		private String name;
		public String icon;
		
		public int reqPoint_Optics;
		public int reqPoint_Engineering;
		public int reqPoint_Material;
		
		private boolean isStudied;
		
		public ResearchInfo(String name, String icon, int optics, int engineering, int material) {
			this.name = name;
			this.icon = icon;
			
			this.reqPoint_Optics = optics;
			this.reqPoint_Engineering = engineering;
			this.reqPoint_Material = material;
			
			this.isStudied = false;
		}
		
		public boolean study(PlayerCeC player) {
			boolean canStudy = player.researchPoint_Optics      >= this.reqPoint_Optics &&
					           player.researchPoint_Engineering >= this.reqPoint_Engineering &&
					           player.researchPoint_Material    >= this.reqPoint_Material;
			if (canStudy)
				this.isStudied = true;
			return canStudy;
		}
		
		public boolean isStudied() {
			return this.isStudied;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}

}
