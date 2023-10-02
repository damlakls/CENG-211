package Helper1;

public class Calculate implements ICommand {

    @Override
    public void execute(String[] attributes) {
        Revenue revenue = Revenue.values()[(Integer.parseInt(attributes[1])-1)];
        revenue.calculating();
    }
    //Instead of switch case and if else statements we used enums for the better design.

    enum Revenue{
        UNEARNEDREVENUE{
            @Override
            
            protected void calculating() {
                System.out.println("Total unearned revenue: "+(produce.getTotalExpectedPrice()-load.getTotalPriceOfBoxedItems())+"TL");
            }    

        }, 
        EARNEDREVENUE{
            @Override
            protected void calculating() {
                System.out.println("Total revenue: "+(load.getTotalPriceOfBoxedItems()+produce.getTotalCost())+"TL");
            }

        };
        Produce produce = new Produce();
        Load load = new Load();
        protected abstract void calculating();
    }

}
