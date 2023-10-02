package HW3;

import FileIO.File;
import Manufacturer.*;
import java.util.ArrayList;
import Materials.*;

public class simulation {

	public static void main(String[] args) {
		File myFile = new File();
		Manufacturer manufacturer1 = new Manufacturer1(File.getm1Materials(), File.getm1Furnitures());
		Manufacturer manufacturer2 = new Manufacturer2(File.getm2Materials(), File.getm2Furnitures());
		ArrayList<Furniture> perfectQuality = new ArrayList<Furniture>();
		ArrayList<Furniture> veryGoodQuality = new ArrayList<Furniture>();
		ArrayList<Furniture> goodQuality = new ArrayList<Furniture>();
		ArrayList<Furniture> badQuality = new ArrayList<Furniture>();

		for (int i = 0; i < 3; i++) {
			System.out.println("Day #" + i);
			manufacturer1.buy();
			manufacturer1.produce();
			manufacturer2.buy();
			manufacturer2.produce();

		}

	}

}
