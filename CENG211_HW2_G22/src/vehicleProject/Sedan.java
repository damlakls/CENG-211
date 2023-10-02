package vehicleProject;

public class Sedan extends Automobile{
    private String roofType ;
    private double price;
    private double sct;
    
    protected Sedan(String vehicle_ID, String monthOfSale,String cityOfSale, int productionYear,  String roofType, double engineVolume, double valueAddedTax) {
        super(vehicle_ID, monthOfSale,  cityOfSale,  productionYear ,engineVolume, valueAddedTax);
        this.roofType = roofType ;
        sct = calculateSCT();
        price = super.calculatePrice(sct); // constructor
    }

    Sedan(Sedan sedan){     //Copy constructor
        super(sedan);
        roofType=sedan.roofType;
        sct=sedan.sct;
        price=sedan.price;
    }

    @Override
    protected double calculateSCT() { // overriden method to calculate sct 
        return ((engineVolume*0.2*valueRoofType(roofType))/super.productionYear(productionYear));
    }

    private double valueRoofType(String roofType){ // for find sct value of the roof type 

		if (roofType.equals("regular")) {
			return 0.5;

		}if (roofType.equals("moonroof")) {
			return 0.6;

		}if (roofType.equals("sunroof")) {
			return 0.8;

		}else {
			throw new IllegalAccessError("The roof Type can't found or "
					+ "the roof type is wrong check the values!!!!");
		}
    }
// immutable class
    public String getRoofType(){
        return roofType;
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
