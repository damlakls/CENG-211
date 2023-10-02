package Materials;

public class WoodenPlank extends Material{
	
	public WoodenPlank() {
		super();
	
	}
	public WoodenPlank(String materialCode, int length, int width, int height, int cost, int quality) {
		super(materialCode, length, width, height, cost, quality);
	
	}public WoodenPlank(WoodenPlank woodenplank) {
		super(woodenplank);
	
	}

}
