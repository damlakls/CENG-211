package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */

import java.time.LocalDate;

public class Sales {
	private String id ;
	private Customer customer;
	private Product product;				//ID in the product file
	private LocalDate salesDate;
	private double salesPrice;
	private static final double RATE_OF=5.0;

	public Sales(){  //Default constructor to privacy 
        id="";
        customer=null;
        product=null;
        salesDate=null; 
		salesPrice=0.0;
    }


    public Sales(String id, Customer customer, Product product, LocalDate date) {
		this.id=id;
		this.customer=customer;
		this.product=product;      
		this.salesDate=date;
		this.salesPrice=setSalesPrice();
	}

	
    Sales(Sales sales){
        id=sales.id;
		customer=sales.customer;
		product=sales.product;
		salesDate=sales.salesDate;
		salesPrice=sales.salesPrice;
    }


	public String getId() {
		return id;
	}


	public Customer getCustomer() {
		return customer;
	}

	
    public Product getProduct() {
		return product;
	}

	
    public LocalDate getSalesDate() {
		return salesDate;
	}

	
    public double getSalesPrice() {
		return salesPrice;
	}
	

	public double setSalesPrice() {
		salesPrice = product.getPrice() + ( (product.getRate()/RATE_OF) * 100  * product.getNumberOfReviews());  // Method for calculate the price
		return salesPrice;
	}
}
