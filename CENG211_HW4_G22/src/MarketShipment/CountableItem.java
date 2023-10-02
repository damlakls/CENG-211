package MarketShipment;
//Countable Item class. In this class we extend Item abstract class and we add just volume.

public class CountableItem extends Item {
	private int volume;
	
	public CountableItem(){
		super();
	}
	
	public CountableItem(String itemCode, int volume, String serialNumber, double price) {
		super(itemCode, serialNumber, price);
		setVolume(volume);
	}
	
	public CountableItem(CountableItem item) {
		super(item);
		volume=item.volume;
	}
	
	public int getVolume() {
		return volume;
	}
	
	
	
	public void setVolume(int volume){
		if(volume< 0)
			throw new IllegalStateException("The volume can't be less than zero!!!");   
		else
			this.volume = volume;
	}
	
}
