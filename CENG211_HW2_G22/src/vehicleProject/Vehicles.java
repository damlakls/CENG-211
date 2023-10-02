package vehicleProject;

public class Vehicles {
	protected String vehicle_ID ; // we make this code protected to make it secured while inherited it 
	protected int productionYear;
	protected double valueAddedTax ;
	protected String cityOfSale ;
	protected String monthOfSale ;

	protected Vehicles(String vehicle_ID, String monthOfSale, String cityOfSale, int productionYear, double valueAddedTax ) {
		this.vehicle_ID = vehicle_ID;
		this.productionYear = productionYear;
		this.valueAddedTax = valueAddedTax;
		this.cityOfSale = cityOfSale;
		this.monthOfSale = monthOfSale;
	}

	Vehicles(Vehicles vehicle) {
		vehicle_ID = vehicle.vehicle_ID;
		productionYear = vehicle.productionYear;
		valueAddedTax = vehicle.valueAddedTax;
		cityOfSale = vehicle.cityOfSale;
		monthOfSale = vehicle.monthOfSale;	
	}		

	protected double calculateSCT() { // we write a method to override it 
		return 0.0 ;
	}

	protected double calculatePrice(double stc) { // we write a method to override it 
		return 0.0 ;
	}

	protected double getPrice(){ //We write to override it
		return 0.0;
	}

    protected double getSCT(){ //We write to override it
		return 0.0;
	}

	protected double monthOfSale(String monthOfSale){ // method for find the sct value of the month of sales

		if (monthOfSale.equals("January")) {
			return 0.3;
		
		}if (monthOfSale.equals("May")) {
			return 0.4;
		
		}if (monthOfSale.equals("August")) {
			return 0.5;
		
		}if (monthOfSale.equals("October")) {
			return 0.6;
		
		}if (monthOfSale.equals("December")) {
			return 0.7;
		
		}else {
			throw new IllegalAccessError("The month's value can't found or "
					+ "the month is wrong check the values!!!!");
		}		
	}
		
	protected double cityOfSale(String cityOfSale){ //  method for find the sct values of the cities
		
		if(cityOfSale.equals("Ýzmir")) {
			return 0.1;
		
		}if (cityOfSale.equals("Ankara")) {
			return 0.2 ;
		
		}if (cityOfSale.equals("Ýstanbul")){
			return 0.3;
		
		}else{
			throw new IllegalAccessError("The city's value can't found or "
					+ "the city is wrong check the values!!!!");
		}
	}
		

	protected double productionYear(int productionYear){ // method for the find sct value of the production year 

		if(2001<= productionYear && productionYear<=2008) {
			return 1.0;	
		
		}if(2012<= productionYear && productionYear<=2017) {
			return 1.2;	
	
		}if(2018<= productionYear && productionYear<=2022) {
			return 1.6;
		
		}else{
			throw new IllegalAccessError("The year's value can't found or "
					+ "the year is wrong check the values!!!!");
		}
	}

	protected void setVehicleId(String _param) { // we protect our project with setter method with to get true value of the Vehicle ID
		if(_param == null) {
			System.out.println("Wrong value");
			System.exit(0);
		}
	}

	protected String getVehicle_ID() {
		return vehicle_ID;
	}

	protected int getProductionYear() {
		return productionYear;
	}

	protected double getValueAddedTavehicle() {
		return valueAddedTax;
	}

	protected String getCityOfSale() {
		return cityOfSale;
	}

	protected String getMonthOfSale() {
		return monthOfSale;
	}

	public void toString(Vehicles vehicle, String title){ // Our toString Method
		System.out.println("Vehicle: "+title+
		", Vehicle ID: "+vehicle.getVehicle_ID()+
		", Month: "+vehicle.getMonthOfSale()+
		", City: "+vehicle.cityOfSale+
		", Production Year: "+vehicle.productionYear+
		", Total Price: "+vehicle.getPrice()+" TL"+
		", SCT: "+vehicle.getSCT());
	}

}
