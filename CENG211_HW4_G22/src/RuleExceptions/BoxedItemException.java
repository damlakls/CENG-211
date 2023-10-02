package RuleExceptions;
//Exception 2
//To check whether Item is boxed. Because same item can't be boxed again 
public class BoxedItemException extends RuleException{
    
    public BoxedItemException(){
        super("Item is boxed. This item cannot be added again!");
    }

    public BoxedItemException(String message){
        super(message);
    }
}
