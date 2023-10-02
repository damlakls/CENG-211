package MarketShipment;

import RuleExceptions.BoxCapacityException;
import RuleExceptions.BoxLoadedException;
import RuleExceptions.BoxedItemException;
import RuleExceptions.ItemMismatchException;
/*
 * In this class we implement basic methods from interface like isEmpty , isFull etc.
 */
public class Box<T> implements IBox<T> {
	private T[] box;
	private String boxCode;
	private int massOrNumberOfItems;   
	private int volume;               
	private String serialNumber;
	
	private int totalMassOrNumberOfItems;                
	private double totalVolume; 
	private int entries;
	private boolean isLoaded;  
	private int loadCount = 0; //  we count to total loaded box but first its number is zero

	public Box() {
		this(null, 0, 0, null);
	}
	
	
	public Box(String boxCode, int massOrNumberOfItems, int volume, String serialNumber) {
		this.boxCode = boxCode;
		this.massOrNumberOfItems = massOrNumberOfItems;
		this.volume = volume;
		this.serialNumber = serialNumber;
		
		entries = 0;
		isLoaded = false;
		box = (T[]) new Item[massOrNumberOfItems]; 
	}

	
	public boolean isFull() { 
		return (massOrNumberOfItems == totalMassOrNumberOfItems) || ((int)totalVolume==volume);
	}


	public boolean isEmpty() {
		return massOrNumberOfItems != box.length && ((int)totalVolume!=volume);
	}

	
	public boolean add(Object item, int itemNumberOrMass, double itemVolume, String itemCode, String boxName) {
		boolean check = false;
		try{ 
			
			 if(contains(item)) {
				throw new BoxedItemException("Item "+itemCode+" is boxed. This item cannot be added again! (EX:2 Boxed Item Exception)");
			}
			 if(isLoaded) {
				
				throw new BoxLoadedException("Box is loaded. Item "+itemCode+" cannot placed! (EX:3 Box Loaded Exception)");
				}
			 else if(isFull()) {
				throw new BoxCapacityException("Box is full. "+itemCode+" cannot placed! (EX:1 Box Capacity Exception)");
			 }
			
			else if(item instanceof Box){
				throw new ItemMismatchException("Type of item "+itemCode+" does not match the type of box "+boxName+"! (EX:8 Item Mismatch Exception");
			}else {
				check = true;
				box[entries] = (T) item;
				entries++;
				totalVolume += itemVolume;
				totalMassOrNumberOfItems += itemNumberOrMass;
                System.out.println("Item "+itemCode+" has been placed to the box "+boxName);
			    }
		}catch(BoxCapacityException | ItemMismatchException | BoxLoadedException | BoxedItemException e){
			System.out.println(e.getMessage());
		}return check;
	}

	
	public boolean remove(Object item, int itemNumberOrMass, double itemVolume) {
		boolean found = false;
			
		for(int i=0; !found && (i<entries); i++) {
			if(item.equals(box[i])) {
				found = true;
				
				box[i] = box[entries-1];
				box[entries-1] = null;
				entries--;
				totalVolume -= itemVolume;
				totalMassOrNumberOfItems -= itemNumberOrMass;
			}
		}return found;
	}
	
	
	public T remove() {
		T lastItem = null;
		try {
			if(isLoaded)
				throw new BoxLoadedException();
			else if(!isEmpty()) {
				lastItem = box[entries-1];
				box[entries-1] = null;
				entries--;
		    }
		}catch (BoxLoadedException e) {
			e.getMessage();
		}return lastItem;
	}


	public void clear() {
		try{
			if(isLoaded)
				throw new BoxLoadedException();
			while(!isEmpty())
			    remove();
		}catch(BoxLoadedException e){
			e.getMessage();
		}
	}


	public boolean contains(Object item) {
		boolean found = false;
		int index = 0;
		while(!found && index<entries) {
			if(item.equals(box[index]))
				found = true;
			else
				index++;
		}return found;
	}
	

	public int getCurrentSize() {
		return entries;
	}
	
	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] tempBox = (T[]) new Object[massOrNumberOfItems];
		for(int i=0; i<massOrNumberOfItems; i++)
			tempBox[i] = box[i];
		return tempBox;
	}

	public boolean isLoaded(){
          return isLoaded;
	}

	public void setIsLoaded(){  
		if(loadCount==0){
			loadCount++; // we count to total loaded box 
		    isLoaded = true; 
	    }
	}


	public String getBoxCode() {
		return boxCode;
	}

	public int getMassOrNumberOfItems() {
		return massOrNumberOfItems;
	}

	public int getVolume() {
		return volume;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setBoxCode(String boxCode) {
		this.boxCode = boxCode;
	}

	public void setMassOrNumberOfItems(int massOrNumberOfItems) {
		this.massOrNumberOfItems = massOrNumberOfItems;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	  
	
	
		
		

}