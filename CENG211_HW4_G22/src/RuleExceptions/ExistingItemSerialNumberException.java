package RuleExceptions;
//Exception 7
//check whether item's serial number is same.
public class ExistingItemSerialNumberException extends RuleException {

		public ExistingItemSerialNumberException(){
		    super("Existing item serial number!");
		}
		
		public ExistingItemSerialNumberException(String message){
		    super(message);
		}
	}


