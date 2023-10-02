package Helper1;


public class Ship implements ICommand {
 
    
    @Override
    public void execute(String[] attributes) {
   	if(Produce.getContainer1()!=null) {
   		Produce.getContainer1().setSerialNumber(attributes[1]); // check attributes from field to find serial number
   		Produce.getContainer1().setIsShipped(); // uses boolean value then executes if container is shipped 
    
    }
}
}

