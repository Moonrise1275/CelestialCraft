package moonrise.celestialcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockStarLightAlter extends ItemBlockWithMetadata {

	public ItemBlockStarLightAlter(int par1) {
		super(par1, ModBlocks.blockStarLightAlter);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		switch(item.getItemDamage()) {
		case 0:
			return "StarLightAlter";
		case 1:
			return "StarLightReflectorGlass";
		case 2:
			return "StarLightReflectorCopper";
		case 3:
			return "StarLightReflectorSilver";
		case 4:
			return "StarLightReflectorIridium";
		default :
			return "";
		}
	}

}
