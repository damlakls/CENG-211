package Materials;

import java.util.ArrayList;

public class Wardrobe extends Furniture{
    
	public static final String Lavinia = "WD2201";
	public static final String Loki = "WD2202";
	public static final String Atlas = "WD2203";
    public Wardrobe(){
        super();
    }

    public Wardrobe(String wardrobeCode ,ArrayList<MaterialParts> materialParts){
        super(wardrobeCode, materialParts);
    }

    public Wardrobe(Wardrobe wardrobe){
        super(wardrobe);
    }
}
