package moonrise.util;

import moonrise.celestialcraft.ModInfo;
import moonrise.celestialcraft.block.BlockCelestialCraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;

public class Test {

	public static void main(String[] args) {
		
		IModInfo info = new ModInfo();
		
		//Block block = new BlockCelestialCraft(1, "name");
		//block.registerIcons(new IconRegister());
		
		System.out.println(info.getTexturePath() + "Name" + "_Top");

	}

}
