package RuleExceptions;
// Exception 6
//check whether box's serial number is same.

public class ExistingBoxSerialNumberException extends RuleException{
    
    public ExistingBoxSerialNumberException(){
        super("Existing box serial number!");
    }

    public ExistingBoxSerialNumberException(String message){
        super(message);
    }
}
