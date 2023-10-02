package MarketShipment;
public class UncountableItem extends Item {
	private int mass;
	private double volume;
	//Uncountable Item class. In this class we extend Item abstract class and we add mass and volume.
	
	public UncountableItem() {
		super(null, null, 0);
		volume=0;
	}
	
	public UncountableItem(String itemCode, int mass, double volume, String serialNumber, double price) {
		super(itemCode, serialNumber,price);
		this.mass = mass;
		this.volume = volume;
	}
	
	public UncountableItem(UncountableItem item){
		super(item);
		mass=item.mass;
		volume=item.volume;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	
}


