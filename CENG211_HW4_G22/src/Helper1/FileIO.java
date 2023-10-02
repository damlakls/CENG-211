package Helper1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import MarketShipment.Box;
import MarketShipment.Container;
import MarketShipment.CountableItem;
import MarketShipment.Item;
import MarketShipment.UncountableItem;

public class FileIO {

	
	public static List<String> commands = new ArrayList<String>(); // we create array list to add lines then execute it by using enums.
	
	public static void start(String fileName) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line=reader.readLine();
			while(line!= null && line.hashCode()!=0)  {
				commands.add(line);
				String[] attributes = line.split(",");
				line=reader.readLine();
				CommandList command = CommandList.values()[Integer.parseInt(attributes[0])-1]; // cause the item's is starting from 1  
				command.execute(attributes); // but the enum's values are starting from 0 
			}reader.close();	
		}
		catch (FileNotFoundException e) {
			System.out.println("File cannot be found!");
			e.getMessage();
		}
	}

	enum CommandList {

        PRODUCE{
            @Override
            public void execute(String[] attributes){ // then we execute it in there
                produce.execute(attributes);
            }
        }, 
        LOAD{
            @Override
            public void execute(String[] attributes){
				load.execute(attributes);
            }
        }, 
        SHIP{
            @Override
            public void execute(String[] attributes) {
				ship.execute(attributes);
            }
        }, 
        CALCULATE{
            @Override
            public void execute(String[] attributes){
				calculate.execute(attributes);
            }
        };
		Produce produce = new Produce();
		Load load = new Load();
		Ship ship = new Ship();
		Calculate calculate = new Calculate();
        public abstract void execute(String[] attributes);
    }
	
   
}
   