package vehicleProject;

public class Minivan extends Automobile{ //Subclass of the Automobile
    private int numOfSeat ; 
    private double price;
    private double sct;

    protected Minivan(String vehicle_ID,String monthOfSale,String cityOfSale, int productionYear,int numOfSeat, double engineVolume, double valueAddedTax) {
        super(vehicle_ID, monthOfSale,  cityOfSale,  productionYear,engineVolume, valueAddedTax );
        this.numOfSeat = numOfSeat;
        sct = calculateSCT();
        price = super.calculatePrice(sct);
    }
    
    Minivan(Minivan minivan){ // copy constructor
        super(minivan);
        numOfSeat=minivan.numOfSeat;
        sct=minivan.sct;
        price=minivan.price;
    }

    @Override
    protected double calculateSCT() { // overriden method to calculate SCT
        return (0.6*super.productionYear(productionYear)) / (engineVolume + valueNumOfSeats(numOfSeat)) ;
    }

    private double valueNumOfSeats(int numOfSeats){ //for the find sct value of the number of seats

        if(numOfSeats == 4) { 
            return 0.1;  
        
        }if(numOfSeats == 5) {	
            return 0.4; 
        
        }if(numOfSeats == 6) {
            return 0.6; 
            
        }if(numOfSeats == 7) {	
            return 0.8; 
            
        }else 
            throw new IllegalAccessError("The number of seats's value can't found or \"\r\n"
                + "	+ \"the number of seat is wrong check the values!!!");
    }
    
    //Immutable class
    public int getNumerOfSeats(){
        return numOfSeat;
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
