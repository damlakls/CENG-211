package vehicleProject;

public class Truck extends Vehicles {
	protected String cabType;
	protected String bedType; 
	private double price;
    private double sct;
	public static final double basePriceTruck = 250000.0; // Constant cause it won't change 

    public Truck(String vehicle_ID, String monthOfSale, String cityOfSale, int productionYear, String cabType, String bedType, double valueAddedTax ) {
		super(vehicle_ID, monthOfSale ,cityOfSale , productionYear ,valueAddedTax); //constructor
		this.cabType = cabType ; 
		this.bedType = bedType;
		sct = calculateSCT();
		price = calculatePrice(sct);
	}

	Truck(Truck truck){        //Copy constructor
		super(truck);
		cabType = truck.cabType;
		bedType = truck.bedType;
		sct = truck.sct;
		price = truck.price;
	}

	@Override // Overridden method to calculateSCT
	protected double calculateSCT(){
		return ((valueBedType()*super.productionYear(productionYear))/valueCabType());
	}

    @Override // Overridden method to calculate price 
	protected double calculatePrice(double sct) { 
		return ((basePriceTruck*(1.0 + (sct*0.6)) + (1.0 + valueAddedTax/100.0))); 
	}
	
	private double valueCabType(){ // to find sct value of the Cabtype

		if(cabType.equals("regular")) {
			return 2.5;
		
		}if(cabType.equals("extended")) {
			return 2.8;
		
		}if(cabType.equals("crew")) {
			return 3.0;
		
		}else {
			throw new IllegalAccessError("Check the type of the cab");
		}
	}

	private double valueBedType(){ // to find sct value of the bedtype 
			
		if(bedType.equals("regular")) {
	    	return 0.5;
	    
		}if(bedType.equals("tanker")) {
			return 0.8;
		
		}if(bedType.equals("trailer")) {
			return 1.0;
		
		}else { 
			throw new IllegalAccessError("Check the type of the truck bed type ");
		}
	}

	public String getCabType(){
		return cabType;
	}

	public String getBedType(){
		return bedType;
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
