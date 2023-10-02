package RuleExceptions;

//Execption 3
//Check if box is loaded because when box loaded item can't be added
public class BoxLoadedException extends RuleException{
	    
	    public BoxLoadedException(){
	        super("Box is loaded. Item addition is cannot be done!");
	    }

	    public BoxLoadedException(String message){
	        super(message);
	    }
	    
	}

