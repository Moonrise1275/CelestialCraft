package moonrise.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingUtil {
	
	//support forge ore recipe
	public static void addRecipe(Item      output, Object... params) {addRecipe(new ItemStack(output), params);}
	public static void addRecipe(Block     output, Object... params) {addRecipe(new ItemStack(output), params);}
	public static void addRecipe(ItemStack output, Object... params) {
		if (params[0] instanceof String)
			GameRegistry.addRecipe(new ShapedOreRecipe(output, params));
		else
			GameRegistry.addRecipe(new ShapelessOreRecipe(output, params));
	}
	
	public static void addSmelting(     Item input, Item      output, int exp) {addSmelting(input, new ItemStack(output), exp);}
	public static void addSmelting(     Item input, Block     output, int exp) {addSmelting(input, new ItemStack(output), exp);}
	public static void addSmelting(     Item input, ItemStack output, int exp) {addSmelting(new ItemStack(input), output, exp);}
	public static void addSmelting(    Block input, Item      output, int exp) {addSmelting(input, new ItemStack(output), exp);}
	public static void addSmelting(    Block input, Block     output, int exp) {addSmelting(input, new ItemStack(output), exp);}
	public static void addSmelting(    Block input, ItemStack output, int exp) {addSmelting(new ItemStack(input), output, exp);}
	public static void addSmelting(ItemStack input, Item      output, int exp) {addSmelting(input, new ItemStack(output), exp);}
	public static void addSmelting(ItemStack input, Block     output, int exp) {addSmelting(input, new ItemStack(output), exp);}
	public static void addSmelting(ItemStack input, ItemStack output, int exp) {addSmelting(input.itemID, output, exp);}
	public static void addSmelting(      int input, ItemStack output, int exp) {
				
		GameRegistry.addSmelting(input, output, exp);
		
	}

}
