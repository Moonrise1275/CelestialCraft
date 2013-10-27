package moonrise.celestialcraft.block;

import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.ModInfo;
import moonrise.util.IModInfo;
import moonrise.util.SimpleBlock;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCelestialCraft extends SimpleBlock {
	
	static IModInfo info = new ModInfo();

	public BlockCelestialCraft(int id, String name) {
		super(id, name, info, CelestialCraft.tabCeC);
	}

}
