package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */
    

/*
 * In this class we connect the methods with other classes but simply
 *  we read files easily bound to FileIO 
 * class and then create new arrays to append them. 
 */

public class InitializeInformation {
    
	private FileIO Customer = new FileIO("Customers.csv");
	private FileIO S1Product = new FileIO("S1_Products.csv"); 
	private FileIO S2Product = new FileIO("S2_Products.csv"); 
	private FileIO S3Product = new FileIO("S3_Products.csv"); 
	private FileIO S1Sales = new FileIO("S1_Sales.csv");
	private FileIO S2Sales = new FileIO("S2_Sales.csv"); 
	private FileIO S3Sales = new FileIO("S3_Sales.csv");

    static Customer[] customerArray;
	static Product[] productS1Array;
    static Product[] productS2Array;
    static Product[] productS3Array;
    static Sales[] salesS1Array;
    static Sales[] salesS2Array;
    static Sales[] salesS3Array;
	
	private FileIO customerCopyFile;
	private FileIO productS1CopyFile;
	private FileIO productS2CopyFile;
	private FileIO productS3CopyFile;
	private FileIO salesS1CopyFile;
	private FileIO salesS2CopyFile;
	private FileIO salesS3CopyFile;
	
	
	public void getInformation() {
		secureFiles();
		initializeArray();
    }


	private void secureFiles() {
		customerCopyFile = new FileIO(Customer);
		productS1CopyFile = new FileIO(S1Product);
		productS2CopyFile = new FileIO(S2Product);
		productS3CopyFile = new FileIO(S3Product);
		salesS1CopyFile = new FileIO(S1Sales);
		salesS2CopyFile = new FileIO(S2Sales);
		salesS3CopyFile = new FileIO(S3Sales);
	}	


	private void initializeArray (){
		customerArray = customerCopyFile.readCustomerFile(new Customer[customerCopyFile.getSizeForArraysByLines()]);
		productS1Array = productS1CopyFile.readProductFile(new Product[productS1CopyFile.getSizeForArraysByLines()]);
		productS2Array = productS2CopyFile.readProductFile(new Product[productS2CopyFile.getSizeForArraysByLines()]);
		productS3Array = productS3CopyFile.readProductFile(new Product[productS3CopyFile.getSizeForArraysByLines()]);
		Supplier supplier = new Supplier();
		supplier.setProductArray(productS1Array, productS2Array, productS3Array);  //To append all products to one array
	
		salesS1Array = salesS1CopyFile.readSalesFile(new Sales[salesS1CopyFile.getSizeForArraysByLines()]);
		salesS2Array = salesS2CopyFile.readSalesFile(new Sales[salesS2CopyFile.getSizeForArraysByLines()]);
		salesS3Array = salesS3CopyFile.readSalesFile(new Sales[salesS3CopyFile.getSizeForArraysByLines()]);
	
		SalesManagement salesManagement = new SalesManagement();
		salesManagement.setArrayOfSuppliers(salesS1Array, salesS2Array, salesS3Array);
		}
}
