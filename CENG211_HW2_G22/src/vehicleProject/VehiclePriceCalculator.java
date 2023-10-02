package vehicleProject;

import java.io.FileNotFoundException;

public class VehiclePriceCalculator {
    public static void main(String[] args) throws FileNotFoundException {
// This our main class
        FileIO open = new FileIO(); // open object from FileIO
        SalesRecordClass.setArrayByType(open.openTheFile()); // we made array operations
        Initialize.MenuOFVehicles();	// from initialize class we set the menu   
    }      
}
