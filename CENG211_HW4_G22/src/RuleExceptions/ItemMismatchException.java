package RuleExceptions;

// Exception 8
//Check whether the uncountable and countable items goes through the true box.  
public class ItemMismatchException extends Exception{
    
    public ItemMismatchException(){
        super("Type of item does not match the type of box!");
    }

    public ItemMismatchException(String message){
        super(message);
    }

}
