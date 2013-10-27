package moonrise.celestialcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.ModInfo;
import moonrise.util.IModInfo;
import moonrise.util.SimpleItem;

public class ItemCelestialCraft extends SimpleItem {

	public ItemCelestialCraft(int id, String name) {
		super(id, name, new ModInfo(), CelestialCraft.tabCeC);
	}

}
