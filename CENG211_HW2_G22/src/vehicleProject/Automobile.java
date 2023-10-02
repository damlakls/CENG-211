package vehicleProject;

/*
 * We write this Automobile class to be superclass to Minivan, Sedan and Hatchback subclasses. 
 * 
 */
public class Automobile extends Vehicles {
	protected double engineVolume;
	private static final double basePriceAuto = 200000.0 ; // constant cause won't change
	
	public Automobile(String vehicle_ID, String monthOfSale, String cityOfSale, int productionYear, double engineVolume, double valueAddedTax ) {
		super(vehicle_ID, monthOfSale ,cityOfSale , productionYear ,valueAddedTax  );
		this.engineVolume = engineVolume;   // Inherited instance variables and constructor
	}

	Automobile(Automobile automobile) {         //Copy constructor
		super(automobile);
		engineVolume = automobile.engineVolume;
	}

	@Override
	protected double calculatePrice(double sct) { //Overridden methods from Vehicles class
		return (basePriceAuto* (1.0 + sct*0.8 )+ (1.0+ valueAddedTax/100.0)) ;   
	}
}
