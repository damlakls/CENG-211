package Helper1;


import java.util.List;
import MarketShipment.*;

import RuleExceptions.BoxLoadedException;
import RuleExceptions.ItemMismatchException;

public class Load implements ICommand {
    private static Produce produce = new Produce();
 
    private static List<Item> countableItems = produce.getCouncountableTEmList();  
    private static List<Item> uncountableItems = produce.getUncouncountableTEmList();
    private Box<UncountableItem> massBox = produce.getMassBox();
    private Box<CountableItem> numberBox = produce.getNumberBox();
    @SuppressWarnings("rawtypes")
	private  Container<Box> container = produce.getContainer();
    
    private static double totalPriceOfBoxedItems; // In add methods , when items added to the  box's,  the price will be added in there

    @Override
    public void execute(String[] attributes) {
        LoadedTo loadedTo = LoadedTo.valueOf(attributes[2]); 
        loadedTo.loading(attributes);
    }

    enum LoadedTo{
    	
        B101{    //countable
            @Override
            protected void loading(String[] attributes) {
            	try { 
            		if(command.findBySerialNumber(attributes[1]) instanceof CountableItem){ // if it's  instance of Countable's box . 
            			CountableItem foundCountableItem = (CountableItem) command.findBySerialNumber(attributes[1]); 
            			if(command.numberBox.add(foundCountableItem, 1, foundCountableItem.getVolume(),attributes[1],"B101")) { 
            				// if its added to box that's return true then we get the price
            			totalPriceOfBoxedItems += foundCountableItem.getPrice();   // then we  added to the total price
            		}
            			
            	}
            		else { // if the box is not match then we send exception that item is'nt mat
            			throw new ItemMismatchException("Item "+attributes[1]+" is not a Countable Item! This item cannot placed to the Number Box!");
            	}
            	}
            		catch(ItemMismatchException e){
            			System.out.println(e.getMessage());
        		}
            } 
        }, 
        B201{     //uncountable
            @Override
            protected void loading(String[] attributes) {
            	try {
            	if(command.findBySerialNumber(attributes[1]) instanceof UncountableItem){ // if it's  instance of Uncountable item we can check it from it's serial number. 
                UncountableItem foundUncountableItem = (UncountableItem)command.findBySerialNumber(attributes[1]); // Then we added to Uncountable item
				if(command.massBox.add(foundUncountableItem, foundUncountableItem.getMass(), foundUncountableItem.getVolume(),attributes[1],"B201")) {
					totalPriceOfBoxedItems += foundUncountableItem.getPrice(); // added to the total price
				}
            }
            	else {
            		throw new ItemMismatchException("Item "+attributes[1]+" is not a Uncountable Item! This item cannot placed to the Mass Box!");
            	}
            	}catch(ItemMismatchException e){
        			System.out.println(e.getMessage());
        		}
            	
            }
        }, 
        C001{  // We check the attribute and C001 is container so we add boxes to container            
            @Override
        	protected void loading(String[] attributes) { 
                try {
                    @SuppressWarnings("rawtypes") 
					Box box = (Box)command.findBySerialNumber(attributes[1]);
                    if(box.isLoaded()) {
                        throw new BoxLoadedException();}
                    command.container.add(box, box.getVolume()); // we add box with its volume
                    box.setIsLoaded(); //  Loads the box to the container
                    
                }catch (BoxLoadedException e) {
                    System.out.println(e.getMessage());
                }  
            }
        };
    	Load command = new Load();
        protected abstract void loading(String[] attributes);
        
    }

    @SuppressWarnings("unchecked")
	private <T> T findBySerialNumber(String serialNumber) {
        for(Item item: uncountableItems) {
			if(item.getSerialNumber().equals(serialNumber)) {;
				return (T)item;
		}
        }
		
		for(Item item: countableItems) {
			if(item.getSerialNumber().equals(serialNumber)) {;
				return (T)item;
		}
		}
		if(massBox.getSerialNumber().equals(serialNumber)) {
			return (T)massBox;
		}
		else if(numberBox.getSerialNumber().equals(serialNumber)) {
			return (T)numberBox;
		}
        return null;
    }

    
    public List<Item> getUncouncountableTEmList(){
        return uncountableItems;
    }

    public List<Item> getCouncountableTEmList(){
        return countableItems;
    }

    public Box<CountableItem> getNumberBox(){
        return numberBox;
    }

    public Box<UncountableItem> getMassBox(){
        return massBox;
    }

    @SuppressWarnings("rawtypes")
	public Container<Box> getContainer(){
        return container;
    }  
    
    public double getTotalPriceOfBoxedItems() {
	    return totalPriceOfBoxedItems;
	}
}