package vehicleProject;

import java.util.ArrayList;
/*
 * In this class we split the vehicles which we read and send to the vehicle array in FileIO  class
 * and write method to ...getArray's of the read them separately.
 */
public class SalesRecordClass { // Arraylist's of the vehicles 
	private static ArrayList<Sedan> SedanArray = new ArrayList<Sedan>();
	private static ArrayList<Hatchback> HatchbackArray = new ArrayList<Hatchback>();
	private static ArrayList<Minivan> MinivanArray = new ArrayList<Minivan>();
	private static ArrayList<Truck> TruckArray = new ArrayList<Truck>();
	private static ArrayList<Bicycle> BicycleArray = new ArrayList<Bicycle>();
	
	public static void setArrayByType(ArrayList<Vehicles> arrayList) {
		
	    for(Vehicles elements: arrayList) {
	    	if(elements instanceof Sedan) { // instanceof operator to whether it's the determined object from vehicle array 
	    		SedanArray.add((Sedan) elements);
	        
			}if(elements instanceof Hatchback) { // and then we send it to the object to determine it's type and send it typeArray
	    		HatchbackArray.add((Hatchback) elements);
	    	
			}if(elements instanceof Minivan) {
	    		MinivanArray.add((Minivan) elements);
	    	
			}if(elements instanceof Truck) {
	    		TruckArray.add((Truck) elements);
	    	
			}if(elements instanceof Bicycle) {
	    		BicycleArray.add((Bicycle) elements);
	    	}
	    }
	}
	
	public void getArrayOfVehicle(){ // to get all vehicle's 
		getArraysOfSedan();
		getArraysOfHatchback();
		getArraysOfMinivan();
		getArraysOfTruck();
		getArraysOfBicycle();
	}

	public void getArraysOfSedan(){ // to get elements in Sedan Array
		for(Sedan element : SedanArray){
			Sedan sedan = new Sedan(element);
			element.toString(sedan, "Sedan");
		}
	} 
		
	public void getArraysOfHatchback(){  // to get elements in Hatchback Array
		for(Hatchback element : HatchbackArray){
			Hatchback hatchback = new Hatchback(element);
			element.toString(hatchback, "Hatchback");
		}
	}

	public void getArraysOfMinivan(){ // to get elements in Minivan Array
		for(Minivan element : MinivanArray){
			Minivan minivan = new Minivan(element);
			element.toString(minivan, "Minivan");
		}
	}

	public void getArraysOfTruck(){ // to get elements in Truck Array
		for(Truck element : TruckArray){
			Truck truck = new Truck(element);
			element.toString(truck, "Truck");
		}
	}

	public void getArraysOfBicycle(){ // to get elements in Bicycle Array
		for(Bicycle element: BicycleArray){
			Bicycle bicycle = new Bicycle(element);
			element.toString(bicycle, "Bicycle");
		}
	}
}
