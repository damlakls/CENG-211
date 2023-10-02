package Materials;

public class WoodenBoard extends Material{

	public WoodenBoard() {
		super();
	}
	
	public WoodenBoard(String materialCode, int length, int width, int height, int cost, int quality) {
		super(materialCode, length, width, height, cost, quality);
		
	}public WoodenBoard(WoodenBoard woodenboard) {
		super(woodenboard);
		
	}

}
