package RuleExceptions;

// Our Ancestor Exception Class
public  class RuleException extends Exception {
	
	public RuleException() {
		super("Rule violation! \n Check \n Whether a box loaded to container, items cannot be placed to that box \nWhether Boxed item cannot be boxed again \n Whether Shipped boxes or containers cannot be used again ");
	}
	
	
	public RuleException(String message) {
		super(message);
	}
	
}
