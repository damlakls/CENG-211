package Materials;

public abstract class Material extends Vendor {
	private int width;
	private int height;
	private int cost;
	private int volume;
	private int length;
	private int quality ; 
	private String materialCode ;
	

	public Material() {
		super();
		length = 0;
		width = 0;
		height = 0;
		cost = 0;
	}
	
	public Material(String materialCode, int length, int width, int height, int cost, int quality) {
		super(materialCode, quality);
		this.length = length;
		this.width = width;
		this.height = height;
		this.cost = cost;
		this.setVolume( length,  width , height); 
	}
	
	public Material(Material material) {
		
		length = material.length;
		width = material.width;
		height = material.height;
		cost = material.cost;
	}
	public double calculateVolume(int length , int width , int height  ) {
		int volume=length* width*height;
		return volume;
	}

	private void setVolume(int length, int width , int height) {
		if(volume < 0 ) {
			throw new IllegalStateException("Volume can't be lesser than zero.");
		}
		else {
			calculateVolume( length , width ,  height);
		}
	}
	
	
	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if(length<0 ) {
			System.out.println("Length can't be lesser than zero");
			System.exit(-1);
		}
		this.length =length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width<0 ) {
			System.out.println("Width can't be lesser than zero");
			System.exit(-1);
		}
		this.width =width;
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if(height <0 ) {
			System.out.println("Heigth can't be lesser than zero");
			System.exit(-1);
		}
		this.height =height;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		if(cost <0 ) {
			System.out.println("Cost can't be lesser than zero");
			System.exit(-1);
		}
		this.cost =cost;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getVolume() {
		return volume;
	}


	}

