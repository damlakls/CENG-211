package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.StringTokenizer;

    
public class FileIO {
    private String fileName;
	private String line;
    private BufferedReader file;
    private StringTokenizer data;
    private int index; 
	private int count;
	
/*
 * We use String Tokenizer class to read file.
 * Then we write method for the each class to read the code
 * Finally we write getSizeByArrayLines to find exact size to arrays to use it initialize array
 */
	
	
	
    public FileIO (String fileName) {
		this.fileName = fileName;
	}	
	
    
    public FileIO(FileIO file){
        fileName = file.fileName;
    }
   
    public void readFile(String fileName) throws IOException {
    	file = new BufferedReader(new FileReader(fileName));
	    line = file.readLine();
		line=file.readLine();
    }
   

    

    public Customer[] readCustomerFile(Customer[] customerArray) { // Customer Array method to read product array 
    	try{
    	
    		readFile(fileName);
			while(line!=null) {
				data = new StringTokenizer(line,",");
	    		Customer customer = new Customer(data.nextToken(), data.nextToken(),data.nextToken(),data.nextToken(),data.nextToken());
	            customerArray[index] = customer; 
		    		
                index++;    
		    	line=file.readLine();
		    }file.close(); 
			

		}catch(FileNotFoundException e){
            System.out.println(e.getMessage() + " file not found");
            System.exit(-1);
        

		}catch (IOException e) {
			System.out.println("Error opening the file " + fileName + " " + e.getMessage());
			System.exit(-1);
		}
        return customerArray;
	}



    public Product[] readProductFile(Product[] productArray) { // product array method to read product array 
    	try{
    		readFile(fileName);
			
			while(line!=null) {
				data = new StringTokenizer(line,",");
				Product product = new Product(data.nextToken(), data.nextToken(), Double.parseDouble(data.nextToken()), Integer.parseInt(data.nextToken()), Integer.parseInt(data.nextToken()));
	            productArray[index] = product;
		    		
                index++;    
		    	line=file.readLine();
		    }file.close();
			

		}catch(FileNotFoundException e){
            System.out.println(e.getMessage() + " file not found");
            System.exit(-1);
        

		}catch (IOException e) {
			System.out.println("Error opening the file " + fileName + " " + e.getMessage());
			System.exit(-1);
		}
        return productArray;
	}
    

    public Sales[] readSalesFile(Sales[] salesArray) {  // Sales array method to read sales array
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yy", Locale.ENGLISH);
		
		try{
			readFile(fileName);
			
			while(line!=null) {
		    	data = new StringTokenizer(line,",");
				String id = data.nextToken();
				Customer customer = Customer.getCustomerByID(data.nextToken()); 
				Product product = Product.getProductByID(data.nextToken());	
				LocalDate date = LocalDate.parse(data.nextToken(), formatter);
				Sales sales = new Sales(id, customer, product, date); 
        		salesArray[index] = sales; // we append every index of the salesCopy to salesArray
                
                index++;    
		    	line=file.readLine();
		    }file.close();
		    
		    
		    

		}catch(FileNotFoundException e){
            System.out.println(e.getMessage() + " file not found");
            System.exit(-1);
        

		}catch (IOException e) {
			System.out.println("Error opening the file " + fileName + " " + e.getMessage());
			System.exit(-1);
		}
        return salesArray;
	}


	public int getSizeForArraysByLines() {  
	/*
	 To find array's exact length we write a method like that then we 
	 will use it in the initialize information class*/
		try{
			readFile(fileName);
			while(line!=null) {
                count++;    
		    	line=file.readLine();
		    	
		    }file.close();
			

		}catch (IOException e) {
			System.out.println("Error opening the file " + fileName + " " + e.getMessage());
			System.exit(-1);
		}

		return count;
	}

}
