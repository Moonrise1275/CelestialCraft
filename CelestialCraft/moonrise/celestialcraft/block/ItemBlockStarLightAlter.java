package moonrise.celestialcraft.block;

import moonrise.celestialcraft.CelestialCraft;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;

public class ItemBlockStarLightAlter extends ItemBlockWithMetadata {

	public ItemBlockStarLightAlter(int par1) {
		super(par1, ModBlocks.blockStarLightAlter);
		this.setCreativeTab(CelestialCraft.tabCeC);
		this.setHasSubtypes(true);
	}
	
	

}
