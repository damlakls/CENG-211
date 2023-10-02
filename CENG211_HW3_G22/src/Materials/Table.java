package Materials;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Table extends Furniture {
	public static final String Obsidian = "TB1401" ;
	public static final String Pearl = "TB1402";
	public static final String Elegant = "TB1501";
	public static final String Walnut = "TB1502";
	public static final String Garden = "TB1503";
	private String tableCode ;
	
	

    public Table(){
        super();
    }

    public Table(String tableCode,  ArrayList<MaterialParts>  materialParts){
        super(tableCode, materialParts);
    }

    public Table(Table table){
        super(table);
    }

	


	public String getTableCode() {
		return tableCode;
	}


}
