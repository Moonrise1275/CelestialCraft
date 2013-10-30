package moonrise.celestialcraft.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moonrise.celestialcraft.CelestialCraft;
import moonrise.celestialcraft.ModInfo;
import moonrise.util.IModInfo;
import moonrise.util.SimpleBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockCelestialCraft extends SimpleBlock {
	
	public BlockCelestialCraft(int id, String name) {
		super(id, name, new ModInfo(), CelestialCraft.tabCeC);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i=0; i<1; i++)
			list.add(new ItemStack(id, 1, 0));
	}

}
