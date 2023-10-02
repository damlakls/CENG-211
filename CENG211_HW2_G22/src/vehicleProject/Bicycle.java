package vehicleProject;

public class Bicycle extends Vehicles{
	private String chainType; 
	private String seatPost; 
	private double valueAddedTax;
	private double price;
    private double sct;
	private static final double basePriceBicycle = 10000.0; // constant because it won't change in the future and we can use it most places.
	
	protected Bicycle(String vehicle_ID, String monthOfSale,  String cityOfSale, int productionYear, String chainType ,String seatPost, double valueAddedTax ) { // constructor
		super(vehicle_ID, monthOfSale ,cityOfSale , productionYear ,valueAddedTax);
		this.chainType = chainType;
		this.seatPost = seatPost;
		sct = calculateSCT();
		price=calculatePrice(sct);
	}

	Bicycle(Bicycle bicycle){        //Copy constructor
		super(bicycle);
		chainType = bicycle.chainType;
		seatPost = bicycle.seatPost;
		sct=bicycle.sct;
		price=bicycle.price;
	}
    
	@Override
    protected double calculateSCT() {   // method to calculate sct
        return ((chainType()*seatPost()*0.1) + super.monthOfSale(monthOfSale));
    }

	@Override
	protected double calculatePrice(double sct) { // method to calculate price
		return ((basePriceBicycle*0.9*(1.0 + sct)) + (1.0+ valueAddedTax/100.0)) ; 
	}
	

	private double chainType() { // method to find sct value of the chain type
	
		if(chainType.equals("derailleur")) {
			return 1.1;

		}if(chainType.equals("onechain")) {
			return 1.2 ;
		
		}if(chainType.equals("doublechain")) {
			return 1.3 ; 
		
		}else {
			throw new IllegalAccessError("Chain type is invalid. Check the chain type! ");
		}
	}

	private double seatPost(){ // method to find sct value of the seat post 

		if(seatPost.equals("carbonfiber")) {
			return 0.8;
		
		}if(seatPost.equals("steel")) {
			return 0.7;
		
		}if(seatPost.equals("aluminum")) {
			return 0.9;
		
		}if(seatPost.equals("titanium")) {
			return 0.6 ;
		
		}else {
			throw new IllegalAccessError("Check the Seat Post!");
		}
		
	}
// this is just a immutable class because we dont't need to change the values.
	public String getChainType() {
		return chainType;
	}

	public String getSeatPost() {
		return seatPost;
	}

	@Override
    protected double getPrice(){
        return price;
    }

    @Override
    protected double getSCT(){
		return sct;
	}
}
