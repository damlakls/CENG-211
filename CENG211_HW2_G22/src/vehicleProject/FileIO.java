package vehicleProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	protected ArrayList<Vehicles> vehicleArray = new ArrayList<Vehicles>();
    BufferedReader file;

	public FileIO() { // constructor
		file=null; 
	}
// In this class we want to return full vehicle array.
    public ArrayList<Vehicles> openTheFile(){
      
        try{ 
            BufferedReader file = new BufferedReader(new FileReader("HW2_SoldVehicles.csv"));
            String line = file.readLine();
            while(line!=null) {
           
            	String[] parts = line.split(","); // we split the file by parts cause it's csv file.
                String part[] = parts[0].split(""); // we get part[0] cause it's ID's part and we want to 
                String typeOfVehicle = part[0] ; // determine the type by ID
                switch(typeOfVehicle){
                /*
                 *  Cases to determine id
                 *  S to Sedan
                 *  H to Hatchback
                 *  M to Minivan
                 *  P to Truck 
                 *  B to Bicycle
                 */
                case "S":
                    
                    Sedan sedan = new Sedan(parts[0], parts[1], parts[2],Integer.parseInt(parts[3]), parts[4],Double.parseDouble(parts[5]),Double.parseDouble(parts[6]));                   
                    vehicleArray.add(sedan);
                    line = file.readLine();  
                    break;
                    
                case "H":
                         
                    Hatchback hatchback = new Hatchback(parts[0], parts[1], parts[2],Integer.parseInt(parts[3]), parts[4],Double.parseDouble(parts[5]),Double.parseDouble(parts[6]));
                    vehicleArray.add(hatchback);
                    line = file.readLine();
                    break;
                    
                case "M":
                    
                    Minivan minivan = new Minivan(parts[0], parts[1], parts[2],Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),Double.parseDouble(parts[5]),Double.parseDouble(parts[6])); 
                    vehicleArray.add(minivan);
                    line = file.readLine();
                    break;
                    
                case "P":
                    Truck truck = new Truck(parts[0], parts[1], parts[2],Integer.parseInt(parts[3]), parts[4],parts[5],Double.parseDouble(parts[6])); 
                    vehicleArray.add(truck);
                    line=file.readLine();
                    break;
                    
                case "B":
                    Bicycle bicycle = new Bicycle(parts[0], parts[1], parts[2],Integer.parseInt(parts[3]), parts[4],parts[5],Double.parseDouble(parts[6]));
                    vehicleArray.add(bicycle);
                    line = file.readLine();
                    break;
                    
                default:
                    throw new IllegalAccessError("Something is wrong!");
                }
                
            }file.close();
            
        }catch(FileNotFoundException a){
            System.out.println(a.getMessage() + " file not found");
            System.exit(-1);
        
        }catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            System.exit(-1);
        }
            
      return vehicleArray;       
	}    
}
