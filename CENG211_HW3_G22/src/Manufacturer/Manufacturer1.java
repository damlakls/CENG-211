package Manufacturer;

import java.util.ArrayList;

import FileIO.File;
import Materials.*;
import MyDeque.Deque;

public class Manufacturer1 extends Manufacturer {

	private Deque<String> requiredMaterials = new Deque<String>();
	private Deque<String> furnituresToProduce = new Deque<String>();
	private Deque<Material> possessions = new Deque<Material>();
	private Deque<String> storeMaterials = new Deque<String>();
	private Deque<Furniture> furniture = new Deque<Furniture>();

	public Manufacturer1(Deque<String> requiredMaterials, Deque<String> furnituresToProduce) {
		this.furnituresToProduce = furnituresToProduce;
		this.requiredMaterials = requiredMaterials;

	}
	@Override

	public void buy() {  //fileIO okunduktan sonra oluşturulan materialParts listesi lazım parametre olarak, parametre furniture olmalı
		Deque<Material> Materials = File.getMaterials();
		String[] partsOfMaterial = requiredMaterials.getFront().split(",");
		for(int i = 1; i< partsOfMaterial.length; i+=2) {
			Material material = getMaterialByCode(partsOfMaterial[i]);
			int count = Integer.parseInt(partsOfMaterial[i+1]);
			while(count !=0) {	
			    possessions.addLast(material);
				
			}
		}
	}
	@Override
    public void produce() {
		Deque<Material> Materials = File.getMaterials();
		String [] furnitureOfManu1= File.getm1Furnitures().getFront().split(",");
		ArrayList<String> ReqFurniture = File.getRequireFurnitureParts();
		for(int i = 1;i<furnitureOfManu1.length;i+=2){
			for(int x =0; x<furnitureOfManu1.length;x++){
				for(int b = 0; b < ReqFurniture.size();b++){
					String[] part = ReqFurniture.get(b).split(",");
					if(furnitureOfManu1[i]==part[0]){
						if(lengthMaterials.getObjectIndex(i).getMaterialCode().equals(parts[1])){

						}
						


					}}
					}

			
		}

		furniture.addFront(furniture);

	}

	private Material getMaterialByCode(String code){
		Deque<Material> Materials = File.getMaterials();
		Material material = null;
		for(int i=0; i<Materials.getNumberOfItems(); i++){
			if(Materials.getObjectIndex(i).getMaterialCode().equals(code)) {
				material = Materials.getObjectIndex(i);
				return material;
			}
		}
		return material;
	}

	public Deque<Material> getPossessions() {
		return possessions ;
	}

	public Deque<String> getRequiredMaterials() {
		return requiredMaterials;
	}

	public Deque<Material> getStoreMaterials() {
		return storeMaterials;
	}

}
