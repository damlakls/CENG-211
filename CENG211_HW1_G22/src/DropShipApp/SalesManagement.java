package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */

public class SalesManagement {
    static Sales[][] salesArrayWithSuppliers;
    
    /* In there we created a method to find maximum number because
     * we aim to find which length we can create array that append the 
     * maximum array's length. For the rest the other array's length can 
     * adapt it .
     * Then we append sales array to two dimensional supplier-sales array.
     */
    
    public Sales[][] setArrayOfSuppliers(Sales[] salesArrayS1, Sales[] salesArrayS2, Sales[] salesArrayS3) {
        salesArrayWithSuppliers = new Sales[3][maximum(salesArrayS1.length, salesArrayS2.length, salesArrayS3.length)];
        
        for(int i=0; i<salesArrayS1.length; i++){
		    salesArrayWithSuppliers[0][i]=salesArrayS1[i];
		}for(int i=0; i<salesArrayS2.length; i++){
		    salesArrayWithSuppliers[1][i]=salesArrayS2[i];
		}for(int i=0; i<salesArrayS3.length; i++){
		    salesArrayWithSuppliers[2][i]=salesArrayS3[i];
		}
        return salesArrayWithSuppliers;
	}


    private int maximum(int num1, int num2, int num3) {   // basic max number finder method to find which array length is bigger
        if(num1>num2 && num1>num3)
            return num1;
        else if (num2>num3)
            return num2;
        else 
            return num3;
    }
}