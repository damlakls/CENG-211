package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 */

public class Product {
    
	private String id;
	private String title;
	private double rate;
	private int numberOfReviews;
	private int price;
	
	public Product() {    // Default Constructor to security 
        id = "";
		title = "";
		rate = 0.0;
		numberOfReviews = 0;
		price =  0;
	}


	public Product(String id, String title, double rate, int numberOfReviews, int price) {
		this.id = id;
		this.title = title;
		this.rate = rate;
		this.numberOfReviews = numberOfReviews;
		this.price=price;
	}
	

	public Product(Product product) {
        id = product.id;
        title = product.title;
        rate = product.rate;
		numberOfReviews = product.numberOfReviews;
		price = product.price;
    }
   
	
	public String getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}
		

	public double getRate() {
		return rate;
	}
	

	public int getNumberOfReviews() {
		return numberOfReviews;
	}
	

	public int getPrice() {
		return price;
	}


	public String displayProduct(){
		String product = (id+' '+title+' '+rate+' '+numberOfReviews+' '+price);
		return product;
	}


	public static Product getProductByID(String id) {   // We aim to find take the product by ID with this method
		for(int i=0; i<Supplier.productArray.length; i++){
            if(Supplier.productArray[i].id.equals(id))
				return new Product(Supplier.productArray[i]);
		}
		return null;
	}
	
}
