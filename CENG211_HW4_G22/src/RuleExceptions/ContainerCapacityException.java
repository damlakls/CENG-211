package RuleExceptions;

//Exception 4
//Check whether conatiner's capacity is over.
public class ContainerCapacityException extends RuleException {
    public ContainerCapacityException(){
        super("A Container cannot hold boxes more than its capacity");
    }

     public ContainerCapacityException(String message){
        super(message);    
    }

}
