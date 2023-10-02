package FileIO;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import MyDeque.*;
import Materials.*;

public class File{
    private static ArrayList<String> rawMaterials = new ArrayList<String>();
    private static Deque<Material> materials = new Deque<Material>();
    private static Deque<String> m1Materials = new Deque<String>();
    private static Deque<String> m2Materials = new Deque<String>();
    private static Deque<String> m1Furnitures = new Deque<String>();
    private static Deque<String> m2Furnitures = new Deque<String>();
	private static ArrayList<String> requireFurnitureParts = new ArrayList<String>();
    
    
    public File(){
        openRawMaterialProperties();
        openVendorPossessions();
        openManufacturerMaterials("Manufacturer1Materials.csv", m1Materials);
        openManufacturerMaterials("Manufacturer2Materials.csv", m2Materials);
        openManufacturerFurnitures("Manufacturer1Furnitures.csv", m1Furnitures);
        openManufacturerFurnitures("Manufacturer2Furnitures.csv", m2Furnitures);
    }
    @SuppressWarnings("resource")    
	public ArrayList<String> openRawMaterialProperties(){
		try {
			BufferedReader file = new BufferedReader(new FileReader("RawMaterialProperties.csv"));
			String line = file.readLine();
			while(line != null) {	
				rawMaterials.add(line);
				line = file.readLine();
			}file.close();
					
		}catch(FileNotFoundException a){
            System.out.println(a.getMessage() + " file not found.");
            System.exit(-1);
            
		}catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            System.exit(-1);
		
		}return rawMaterials;
	}

		public ArrayList<String> openFurnitureParts(){
		try {
			BufferedReader file = new BufferedReader(new FileReader("FurnitureParts.csv"));
			String line = file.readLine();
			while(line != null) {	
				requireFurnitureParts.add(line);
				
				line = file.readLine();
			}file.close();
					
		}catch(FileNotFoundException a){
            System.out.println(a.getMessage() + " file not found.");
            System.exit(-1);
            
		}catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            System.exit(-1);
		
		}return requireFurnitureParts;
	}
	
	
	public Deque<Material> openVendorPossessions() {
		try {
			BufferedReader file = new BufferedReader(new FileReader("VendorPossessions.csv"));
			String line = file.readLine();
			
			while(line != null) {	
				String[] attr = line.split(","); //vendor file's attributes
				
				switch(attr[0].substring(0,2)) {
				case "PL":
					for(String properties : rawMaterials) {
						String[] attr1 = properties.split(",");   //material file's attributes
						if(attr[0].equals(attr1[0])){
							Plank plank = new Plank(attr1[0],Integer.parseInt(attr1[1]), Integer.parseInt(attr1[2]), Integer.parseInt(attr1[3]), Integer.parseInt(attr1[4]), Integer.parseInt(attr[1]));
							materials.addFront(plank);
							line=file.readLine();
						}
					}break;
					
				case "WB":
					for(String properties : rawMaterials) {
						String[] attr1 = properties.split(",");
						if(attr[0].equals(attr1[0])){
							WoodenBoard woodenBoard = new WoodenBoard(attr1[0],Integer.parseInt(attr1[1]), Integer.parseInt(attr1[2]), Integer.parseInt(attr1[3]), Integer.parseInt(attr1[4]), Integer.parseInt(attr[1]));
							materials.addFront(woodenBoard);
							line=file.readLine();
						}
					}
					break;
					
				case "WP":
					for(String properties : rawMaterials) {
						String[] attr1 = properties.split(",");
						if(attr[0].equals(attr1[0])){
							WoodenPlank woodenPlank = new WoodenPlank(attr1[0],Integer.parseInt(attr1[1]), Integer.parseInt(attr1[2]), Integer.parseInt(attr1[3]), Integer.parseInt(attr1[4]), Integer.parseInt(attr[1]));
							materials.addFront(woodenPlank);
							line=file.readLine();
						}
					}break;
					
				case "HD":
					for(String properties : rawMaterials) {
						String[] attr1 = properties.split(",");
						if(attr[0].equals(attr1[0])){
							Handle handle = new Handle(attr1[0],Integer.parseInt(attr1[1]), Integer.parseInt(attr1[2]), Integer.parseInt(attr1[3]), Integer.parseInt(attr1[4]), Integer.parseInt(attr[1]));
							materials.addFront(handle);
							line=file.readLine();
						}
					}break;
					
				default:
					throw new IllegalAccessError("invalid material type!");
				}
					
			}
			
		}catch(FileNotFoundException a){
            System.out.println(a.getMessage() + " file not found.");
            System.exit(-1);
            
		}catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            System.exit(-1);
		}
	return materials;
	}
	
    public Deque<String> openManufacturerMaterials(String fileName, Deque<String> manufacturerMaterials){
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			String line = file.readLine();
			while(line != null) {	
				manufacturerMaterials.addFront(line);
				line = file.readLine();
			}file.close();
					
		}catch(FileNotFoundException a){
            System.out.println(a.getMessage() + " file not found.");
            System.exit(-1);
            
		}catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            System.exit(-1);
		
		}return manufacturerMaterials;
	}

    public Deque<String> openManufacturerFurnitures(String fileName, Deque<String> manufacturerFurnitures){
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			String line = file.readLine();
			while(line != null) {	
				manufacturerFurnitures.addFront(line);
				line = file.readLine();
			}file.close();
					
		}catch(FileNotFoundException a){
            System.out.println(a.getMessage() + " file not found.");
            System.exit(-1);
            
		}catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            System.exit(-1);
		
		}return manufacturerFurnitures;
	}

	public static Deque<String> getm1Furnitures(){
		return m1Furnitures;
	}
	public static Deque<String> getm2Furnitures(){
		return m2Furnitures;
	}

	public static Deque<String> getm1Materials(){
		return m1Materials;
	}

    public static Deque<String> getm2Materials(){
		return m2Materials;
	}

	public static Deque<Material> getMaterials(){
		return materials;
	}

	public static ArrayList<String> getRequireFurnitureParts(){
		return requireFurnitureParts;
	}
}
