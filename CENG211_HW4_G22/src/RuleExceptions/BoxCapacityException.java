package RuleExceptions;

//Exception 1
//To check Box's capacity is over. 

public class BoxCapacityException extends RuleException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoxCapacityException(){

        super("A Number Box cannot hold items more than its capacity and Mass Box can't hold items more than its capacity \nCheck the capacity "  ); 
    }
    
    public BoxCapacityException(String message){
        super(message);
    }
}
