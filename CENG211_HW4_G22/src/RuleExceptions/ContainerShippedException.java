package RuleExceptions;
//Exception 5
//Check whether container is shipped because after the shipping no more box can be added.

public class ContainerShippedException extends RuleException{
    
    public ContainerShippedException(){
        super("Container is shipped. Box addition is cannot be done!");
    }

    public ContainerShippedException(String message){
        super(message);
    }
}
