package DropShipApp;

/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */

public class Customer {
    
	private String id;
	private String name;
	private String email;
	private String country;
	private String adress;
	
	public Customer(){  // we opened default constructor to security of the files
        id = "";
        name = "";
        email = "";
        country = "";
        adress = "";
    }
    public Customer(String id, String name, String email, String country, String adress){
		this.id = id;
		this.name = name;
		this.email = email;
		this.country=country;
		this.adress = adress;
    }

    public Customer(Customer customer){  // Copy constructors to avoid privacy leaks
        id=customer.id;
        name=customer.name;
        email=customer.email;
        country=customer.country;
        adress=customer.adress;
    }
	
    // we don't need setters in the program so we made it immutable class 
	
    public String getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}
	
	
	public String getEmail() {
		return email;
	}
	

	public String getCountry() {
		return country;
	}
	

	public String getAdress() {
		return adress;
	}

	public String displayCustomer(){
		String customer = (id+" "+name+" "+email+" "+country+" "+adress);
		return customer;
	}

    public static Customer getCustomerByID(String id) {  // We write a method for the find the customers by their ID
        for(Customer customer : InitializeInformation.customerArray){
            if(customer.id.equals(id))
				return new Customer(customer);
		}return null;
    }
	
}