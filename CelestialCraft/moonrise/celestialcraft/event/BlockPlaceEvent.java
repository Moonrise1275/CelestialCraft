package moonrise.celestialcraft.event;

import net.minecraftforge.event.Cancelable;
import moonrise.util.Coord;

@Cancelable
public class BlockPlaceEvent extends CeCEvent {
	
	public Coord coord;
	public int id;
	public int meta;
	
	public BlockPlaceEvent(Coord coord, int id, int meta) {
		this.coord = coord;
		this.id = id;
		this.meta = meta;
		
	}

}
