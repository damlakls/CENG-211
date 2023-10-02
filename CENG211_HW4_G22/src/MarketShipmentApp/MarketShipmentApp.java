package MarketShipmentApp;
/*
 * Damla Keleş - 280201057
 * 	Ceren Çınar - 290
 * Dilay Gülhan Öztürk - 280201059
 * Nurcan Yıldız - 280201082
 */
import java.io.IOException;

import Helper1.FileIO;

// OUR MAIN CLASS 
public class MarketShipmentApp {

	public static void main(String[] args) {
		try {
			FileIO.start("ExampleCommands.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
