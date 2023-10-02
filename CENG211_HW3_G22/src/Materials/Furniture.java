package Materials;

import java.util.ArrayList;
import java.util.StringTokenizer;

public abstract class Furniture {
	String furnitureCode;
	ArrayList<MaterialParts> materialParts;

	public Furniture() {
		furnitureCode = null;
		materialParts = null;

	}

	public Furniture(String furnitureCode, ArrayList<MaterialParts> materialParts) {
		this.furnitureCode = furnitureCode;
		this.materialParts = materialParts;
	}

	public Furniture(Furniture furniture) {
		furnitureCode = furniture.getFurnitureCode();
		materialParts = furniture.materialParts;
	}

	public int calculateQuality(String line1) {
		ArrayList<Material> materialCode = new ArrayList<Material>();
 
		StringTokenizer string1 = new StringTokenizer(line1, ",");
		int count;

		count = countMaterials(line1);
		furnitureCode = string1.nextToken();
		for (int i = 0; i < count; i++) {

			materialCode.add(material(string1.nextToken()));
			string1.nextToken();
		}
		int quality = 0;
		int totalVolume = 0;

		furnitureCode = string1.nextToken();
		for (int i = 0; i < materialCode.size(); i++) {
			materialCode.add(string1.nextToken());
			quality = quality + materialCode.get(i).getQuality() * materialCode.get(i).getVolume();

			totalVolume = totalVolume + materialCode.get(i).getVolume();

		}
		quality = quality / totalVolume;

		return quality;

	}

	public int countMaterials(String line) {
		StringTokenizer string = new StringTokenizer(line, ",");
		int count = 0;
		count = string.countTokens();
		return (count - 1) / 2;
		// furniture code ile başlayıp hem mat code , mat count diye devam ettiği için
		// böyle yazdım
	}

	public String getFurnitureCode() {
		return furnitureCode;
	}

}
