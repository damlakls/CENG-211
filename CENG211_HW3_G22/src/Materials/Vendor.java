package Materials;

public abstract class Vendor {
private String materials ;
private int quality ; 

public Vendor() {
	materials = null ; 
	setQuality(0) ;
	
}
public Vendor(String materials , int quality) {
	this.materials = materials;
	setQuality( quality);
}

public Vendor (Vendor vendor) {
	 materials = vendor.materials;
	 quality = vendor.quality;
}
public int getQuality() {
	return quality;
}
public void setQuality(int quality ) {
	if(quality > 100 && quality <0 ) {
		throw new IllegalAccessError("The quality can't be lesser than 0 or more than ");
	}
	this.quality = quality ; 
}




}
