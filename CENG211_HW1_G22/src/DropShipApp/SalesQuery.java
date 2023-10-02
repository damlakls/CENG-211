package DropShipApp;
/* OUR TEAM -GROUP 22
 * Damla Keleş 280201057
 * Nurcan Yıldız 280201082
 * Dilay Gülhan Öztürk 280201059
 * Ceren Çınar 290201013
 
 */
    

import java.text.NumberFormat;
import java.util.Locale;

public class SalesQuery {
    
    Locale locale = new Locale("tr", "TR");      
    NumberFormat currencyFormatter=NumberFormat.getCurrencyInstance(locale);
    
    private Sales[][]salesArray=SalesManagement.salesArrayWithSuppliers;
    private Customer[] customerArray=InitializeInformation.customerArray;
    private Product product;
    private Customer customer;
    private int profit;
    private int price;
    private int maxProfit;
    private int minProfit;
    private int maxPrice;
    private int numberOfPurchases;
    

    public void displayInformation() {
        System.out.print(mostProfitableProductAmongSuppliers().displayProduct()+" --> "+currencyFormatter.format(maxProfit)+" profit\n"+
                        mostExpensiveProduct().displayProduct()+" --> "+currencyFormatter.format(maxPrice)+" sales price\n"+
                        currencyFormatter.format(totalProfitFromAllSales())+"\n"+
                        customerPurchasesMostProducts().displayCustomer()+" --> "+numberOfPurchases+" Purchases\n"+
                        leastProfitProductOfS1().displayProduct()+" --> "+currencyFormatter.format(minProfit)+" profit");
    }


    private Product mostProfitableProductAmongSuppliers() {
        for(int i=0; i< salesArray.length; i++){     // we search from the sales array to most profitable product
            for(int j=0; j<salesArray[i].length; j++){
                if(salesArray[i][j]==null)
                    break;
                profit=(int)(salesArray[i][j].getSalesPrice())-(salesArray[i][j].getProduct().getPrice());
                if(profit>maxProfit){
                    maxProfit=profit;
                    product = salesArray[i][j].getProduct();
                }
            }
        } return new Product(product);
    }
   
    
    private Product mostExpensiveProduct() {    // we search from the sales array to most expensive product
        for(int i=0; i< salesArray.length; i++){
            for(int j=0; j<salesArray[i].length; j++) {
                if(salesArray[i][j]==null)
                    break;
                price = (int)salesArray[i][j].getSalesPrice();
                if(price > maxPrice){
                    maxPrice = price;
                    product = salesArray[i][j].getProduct();
                }
            }
        }return new Product(product);
    }
    

    private Customer customerPurchasesMostProducts() {
    	/*
    	 * Since we have a method about the find customer by ID
    	 * and CustomerID to 
    	 *  we easily find the Customer that Purchases max products
    	 */
    	int maxPurchases=0;
    	String customerID = null;
       for(int i=0; i<customerArray.length;i++) {
    	   if(CustomerID(customerArray[i].getId())>maxPurchases) {
    		   maxPurchases = CustomerID(customerArray[i].getId());       
    		   customerID = customerArray[i].getId();
            }
            numberOfPurchases = maxPurchases; 
    	  customer = Customer.getCustomerByID(customerID);
        
        }return new Customer(customer);
    }
   

    private int CustomerID(String customerID) {   // to find the customer ID while we use the next method.
    	int numberOfPurchases = 0;
    	for(int i = 0; i<salesArray.length;i++) {
    		for(int j = 0;j<salesArray[i].length;j++) {
    			if(salesArray[i][j]==null)
                    break;
    			else if(salesArray[i][j].getCustomer().getId() == customerID)
    				numberOfPurchases += 1;
    		}
    	}return numberOfPurchases;
    }


    private int totalProfitFromAllSales() {   // we find in there total profit from the all sales. With for loop through the array .
        profit=0;
        for(int i=0; i< salesArray.length; i++){
            for(int j=0; j<salesArray[i].length; j++){
                if(salesArray[i][j]==null)
                    break;
                profit+=(int)(salesArray[i][j].getSalesPrice())-(salesArray[i][j].getProduct().getPrice());
            }
        }return profit;
    }
    

    private Product leastProfitProductOfS1() {    // we find there least profitable product with for loop
        minProfit=(int)(salesArray[0][0].getSalesPrice())-(salesArray[0][0].getProduct().getPrice());
        profit=0;
        for(int j=0; j<salesArray[0].length; j++){
            profit=(int)(salesArray[0][j].getSalesPrice())-(salesArray[0][j].getProduct().getPrice());
                if(profit<minProfit){
                    minProfit=profit;
                    product = salesArray[0][j].getProduct();
                }
        }return new Product(product);
    }
}    
