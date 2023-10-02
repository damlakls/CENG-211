package MarketShipment;

//we have got abstract class Item because CountableItem and Uncountable item consist of this abstract class. 
public abstract class Item {
	private String itemCode;
	private String serialNumber;
	private double price;
	
	public Item() {
		this(null, null, 0);
	}	
	
	public Item(String itemCode, String serialNumber,double price) {
		this.itemCode = itemCode;
		this.serialNumber = serialNumber;
		this.price = price;
	}
	
	public Item(Item item) {
		itemCode=item.itemCode;
		serialNumber=item.serialNumber;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		if(price< 0)
			throw new IndexOutOfBoundsException("The price can't be less than zero.");  
		else
			this.price = price;
	}

	public String getItemCode() {
		return itemCode;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}