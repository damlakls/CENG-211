package DropShipApp;

/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */
    

// Our Main Class
public class DropShippingApp {

	public static void main(String[] args) {
		InitializeInformation information = new InitializeInformation();
		information.getInformation();
		SalesQuery query = new SalesQuery();
		query.displayInformation();
	}

}
