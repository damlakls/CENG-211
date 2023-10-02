package Materials;

import java.util.ArrayList;

public class Shelf extends Furniture {
	public static final String Corner = "SH5001";
	public static final String Harmony = "SH5002";
	public static final String Luna = "SH5003";
	public static final String Hittite = "SH5004";
	
	
	 public Shelf(){
	        super();
	    }

	    public Shelf (String ShelfCode,  ArrayList<MaterialParts>  materialParts){
	        super(ShelfCode, materialParts);
	    }

	    public Shelf(Shelf shelf){
	        super(shelf);
	    }

		
}
