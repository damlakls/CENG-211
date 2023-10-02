package Helper1;

import java.util.ArrayList;
import java.util.List;

import MarketShipment.*;
import RuleExceptions.*;

public class Produce implements ICommand{
	

	private static List<Item> countableItems = new ArrayList<Item>();   
    private static List<Item> uncountableItems= new ArrayList<Item>();

	private static Box<CountableItem> numberBox;
	private static Box<UncountableItem> massBox;
	@SuppressWarnings("rawtypes")
	private static Container<Box> container;
	 
    private static double totalExpectedPrice ;
    private static double totalCost ;
	
    
    @Override
    public void execute(String[] attributes) { // executes from file through it's attributes
        ToProduce toBeProduced = ToProduce.valueOf(attributes[1]);
        toBeProduced.producing(attributes); // produce items with using this method
    }
// We use enum's instead of switch case statement
    enum ToProduce{
    	 
        M1{						
            @Override
            protected void producing(String[] attributes){
            	double price=11; double cost=5; // Milk's price

                if(command.createCountableItem(attributes[1], Integer.parseInt(attributes[2]), attributes[3], price*Double.parseDouble(attributes[2]))) {
                	totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[2]);
                	System.out.println(attributes[2]+" liter of box of milk has been produced with the serial number "+attributes[3]+". Revenue = "+totalCost );
                }
                else {
                	System.out.println("Revenue = "+totalCost);
                }
                }
            }, 
        W1{
            @Override
            protected void producing(String[] attributes){
            	double price=3; double cost=1; //Water's price
            	
                if(command.createCountableItem(attributes[1], Integer.parseInt(attributes[2]), attributes[3],price*Double.parseDouble(attributes[2]))) {
                	totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[2]);
                	System.out.println(attributes[2]+" liter of box of water has been produced with the serial number "+attributes[3]+". Revenue = "+totalCost );
                }else {
                	System.out.println("Revenue = "+totalCost);
                }
                
                }
            }, 
        O1{
            @Override
            protected void producing(String[] attributes){
            	double price=45; double cost=20; // Oil's price
            	
                if(command.createCountableItem(attributes[1], Integer.parseInt(attributes[2]), attributes[3],price*Double.parseDouble(attributes[2]))) {
                	totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[2]);
                	System.out.println(attributes[2]+" liter of box of oil has been produced with the serial number "+attributes[3]+". Revenue = "+totalCost );
                }else {
                	System.out.println("Revenue = "+totalCost);
                }
                }
            }, 
        S1{
            @Override
            protected void producing(String[] attributes){
            	double price=25; double cost=13; //Sugar's price
               if(command.createUncountableItem(attributes[1], Integer.parseInt(attributes[2]), Double.parseDouble(attributes[3]), attributes[4],price*Double.parseDouble(attributes[3]))) {
            	   totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[3]);
            	   System.out.println(attributes[2]+" kilograms of sugar has been produced with the serial number "+attributes[4]+". Revenue = "+totalCost);
            }else {
            	System.out.println("Revenue = "+totalCost);
            }
                }
            }, 
        F1{
            @Override
            protected void producing(String[] attributes){
            	double price=12; double cost=5; // Flour's price
                if(command.createUncountableItem(attributes[1], Integer.parseInt(attributes[2]), Double.parseDouble(attributes[3]), attributes[4],price*Double.parseDouble(attributes[3]))) {
                	totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[3]);
                	System.out.println(attributes[2]+" kilograms of flour has been produced with the serial number "+attributes[4]+". Revenue = "+totalCost);
                }else {
                	System.out.println("Revenue = "+totalCost);
                }
                }
            },
        P1{
            @Override
            protected void producing(String[] attributes){
            	double price=28; double cost=12; //Pasta's price
            	if(command.createUncountableItem(attributes[1], Integer.parseInt(attributes[2]), Double.parseDouble(attributes[3]), attributes[4],price*Double.parseDouble(attributes[3]))) {
            		totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[3]);
            		System.out.println(attributes[2]+" kilograms of pasta has been produced with the serial number "+attributes[4]+". Revenue = "+totalCost);
                }else {
                	System.out.println("Revenue = "+totalCost);
                }
                }
            }, 
        R1{
            @Override
            protected void producing(String[] attributes){
            	double price=32; double cost=16; // Rice's price
            	if(command.createUncountableItem(attributes[1], Integer.parseInt(attributes[2]), Double.parseDouble(attributes[3]), attributes[4],price*Double.parseDouble(attributes[3]))) {
            		totalCost-=cost*Double.parseDouble(attributes[2]); totalExpectedPrice+=price*Double.parseDouble(attributes[3]);
            		System.out.println(attributes[2]+" kilograms of rice has been produced with the serial number "+attributes[4]+". Revenue = "+totalCost);
                }else {
                	System.out.println("Revenue = "+totalCost);
                }
            }
            }, 
        B1{
            @Override
            protected void producing(String[] attributes){ //Countable box
                double cost = 2;
                numberBox = new Box<CountableItem>(attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), attributes[4]);
                totalCost-=cost*Double.parseDouble(attributes[3]);
                System.out.println(attributes[3]+" liters of number box has been produced with capacity of "+attributes[2]+" with the serial number "+attributes[4]+". Revenue: "+totalCost );
                command.checkBox(); 
                }
            }, 
        B2{
            @Override

            protected void producing(String[] attributes){ // Uncountable Box
                double cost = 3;
                massBox = new Box<UncountableItem>(attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), attributes[4]);
                totalCost-=cost*Double.parseDouble(attributes[3]);
                System.out.println(attributes[3]+" liters of mass box has been produced with capacity of "+attributes[2]+"kg with the serial number "+attributes[4]+". Revenue: "+totalCost );
                command.checkBox();
                }
            },
        C1{
            @SuppressWarnings("rawtypes")
			@Override
            protected void producing(String[] attributes){ //Container
                double cost = 1;
                container = new Container<Box>(attributes[1], Integer.parseInt(attributes[2]), attributes[3]);
                totalCost-=cost*Double.parseDouble(attributes[2]);
                System.out.println(attributes[2]+" liters of container has been produced with the serial number "+attributes[3]+". Revenue: "+totalCost);
            }
        };
        Produce command = new Produce();
        protected abstract void producing(String[] attributes); 
    }

   
    private boolean createCountableItem(String attr1, int attr2, String attr3, double price) { //Creating countable items
    	boolean control = true;
        Item countableItem = new CountableItem(attr1, attr2, attr3,price); 
        if(checkItem(countableItem, countableItems)) {
        	countableItems.add((CountableItem) countableItem);
        }
        else {
        	control=false;
        }
        return control;
        
    }


    private boolean createUncountableItem(String attr1, int attr2, double attr3, String attr4,double price) { //Creating uncountable items
    	boolean control = true; 
        Item uncountableItem = new UncountableItem(attr1, attr2, attr3, attr4,price);
        if(checkItem(uncountableItem, uncountableItems)){
        uncountableItems.add((UncountableItem) uncountableItem);
        }else {
        	control = false;
        }
        return control;
        
    }


    private Boolean checkItem(Item itemToCheck, List<Item> itemList) {    // Checking item whether it's exist
    	boolean control = true;
        try{
            int index=0; 
            while(itemList.size()>1 && index<itemList.size()) {
                if(itemToCheck.getSerialNumber().equals(itemList.get(index).getSerialNumber())) {
                control = false; 
                index++;
                throw new ExistingItemSerialNumberException("Item serial number "+itemToCheck.getSerialNumber()+" already exist!(EX:7 Existing Item Serial Number Exception).  ");
                   
                }
                index++;
            } 
        }catch(ExistingItemSerialNumberException e){
        	System.out.print(e.getMessage());
        }	
        return control;
         
    }

    private void checkBox() { // Checking box's whether it's exist 
        if(numberBox!=null && massBox!=null && massBox.getSerialNumber().equals(numberBox.getSerialNumber())){
            try {
                throw new ExistingBoxSerialNumberException("Box serial number "+numberBox.getSerialNumber()+" already exist!(EX:6 Existing Box Serial Number Exception");
            } catch (ExistingBoxSerialNumberException e) {
            	System.out.println(e.getMessage());
            }
        }
    }
    
    @SuppressWarnings("rawtypes")
	public  static Container<Box> getContainer1(){
    	return container;
    }

   
    public double getTotalCost() {
    	return totalCost;
    }
    public double getTotalExpectedPrice() {
    	return totalExpectedPrice;
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
    
    public List<Item> getUncouncountableTEmList(){
        return uncountableItems;
    }

    public List<Item> getCouncountableTEmList(){
        return countableItems;
    }
    
 

  
}