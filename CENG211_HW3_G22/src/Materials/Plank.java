package Materials;

public class Plank extends Material{
	
	public Plank() {
		super();
	}
	
	public Plank(String materialCode, int length, int width, int height, int cost, int quality) {
		super(materialCode, length, width, height, cost, quality);
	}
	
	public Plank(Plank plank) {
		super(plank);
	}

}

