package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */
    
public class Supplier {
    static Product[] productArray;
	private String supplierName;
	private int index;
	
	
	public Supplier() {
		this.supplierName="";
	}


	public Supplier(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setProductArray(Product[] productS1Array, Product[] productS2Array, Product[] productS3Array) {
		productArray = new Product[(productS1Array.length+productS2Array.length+productS3Array.length)]; // we connect all products in one place.
		
		for(Product element : productS1Array) {
			productArray[index]=element;
			index++;
			}
	       
       for(Product element : productS2Array) {
			productArray[index]=element;
			index++;
       		}
       
       for(Product element : productS3Array) {
    	    productArray[index]=element;
    	    index++;
       		}
    }

	
	public Product[] getProductArray() {
		return productArray;
	}
}
