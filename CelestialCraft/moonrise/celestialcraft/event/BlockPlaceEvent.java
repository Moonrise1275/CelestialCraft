package moonrise.celestialcraft.event;

import moonrise.util.Coord;

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
