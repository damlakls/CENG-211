package Materials;

public class Handle extends Material{
	
	public Handle() {
		super();
	}
	
	public Handle(String materialCode, int length, int width, int height, int cost, int quality) {
		super(materialCode, length, width, height, cost, quality);
	}
	
	public Handle(Handle handle) {
		super(handle);	
	}
}
