package moonrise.celestialcraft.event;

import moonrise.util.Coord;

public class BlockBreakEvent extends CeCEvent {
	
	public Coord coord;
	public int id;
	public int meta;
	
	public void BlockBreakEvent(Coord coord, int id, int meta) {
		this.coord = coord;
		this.id = id;
		this.meta = meta;
	}

}
