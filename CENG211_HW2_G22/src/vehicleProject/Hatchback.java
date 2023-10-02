package vehicleProject;

public class Hatchback extends Automobile {
	private String cityMode;
    private double price;
    private double sct;
    
    protected Hatchback(String vehicle_ID, String monthOfSale, String cityOfSale, int productionYear, String cityMode, double engineVolume, double valueAddedTax) {
        super(vehicle_ID, monthOfSale,  cityOfSale,  productionYear, engineVolume, valueAddedTax ); // constructor
        this.cityMode = cityMode;
        sct = calculateSCT();
        price = super.calculatePrice(sct);
    }

    Hatchback(Hatchback hatchback) { // copy constructor
        super(hatchback);
        cityMode=hatchback.cityMode;
        sct=hatchback.sct;
        price=hatchback.price;
    }

    private double cityModeValue(String cityMode){ // to find SCT value of the city mode

        if(cityMode.equals("yes")) {
            return 0.15;
        
        }if(cityMode.equals("no")) {
            return 0.1;
        
        }else{ 
            throw new IllegalAccessError("The City Mode can't found or "
                    + "the City Mode is wrong check the values!!!!");
        }
    }
   
    @Override
    protected double calculateSCT() { // Overriden method for vehicle to calculate sct
        return (engineVolume*0.3*super.productionYear(productionYear)+ cityModeValue(cityMode));
    }

    public String getCityMode() {
        return cityMode;
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
