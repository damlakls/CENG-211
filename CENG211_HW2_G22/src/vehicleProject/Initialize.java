package vehicleProject;

import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Initialize {

public static void MenuOFVehicles() throws FileNotFoundException{
   System.out.println("Welcome to Vehicle Price Calculator!\nPlease press a number to see: "
   		+ "\n1 to see sold Vehicles list "
   		+ "\n2 to see sold Sedan list "
   		+ "\n3 to see sold Hatchback list"
   		+ "\n4 to see sold Minivan list"
   		+ "\n5 to see sold Pickup Truck list"
   		+ "\n6 to see sold Bicycle list"
   		+ "\n0 to exit");// 
   
   Scanner theInput = new Scanner(System.in);
   int number = -1;
     
   while(number!=0){ //  cases which users enters the input to do their operation
      System.out.print("Please enter: ");
      number = theInput.nextInt();
      
      switch(number){
         case 0:
         System.out.println("Goodbye!!!");
         break;

         case 1: // case 1 all vehicles
         SalesRecordClass vehicle = new SalesRecordClass();
         vehicle.getArrayOfVehicle();
         break;

         case 2: // case 2 Sedan
         SalesRecordClass sedan = new SalesRecordClass();
         sedan.getArraysOfSedan();
         break;

         case 3: // case 3 Hatchback
         SalesRecordClass hatchback = new SalesRecordClass();
         hatchback.getArraysOfHatchback();
         break;

         case 4: // case 4 Minivan
         SalesRecordClass minivan = new SalesRecordClass();
         minivan.getArraysOfMinivan();
         break;

         case 5: // case 5 Truck
         SalesRecordClass truck = new SalesRecordClass();
         truck.getArraysOfTruck();
         break;

         case 6: // case 6 Bicycle
         SalesRecordClass bicycle = new SalesRecordClass();
         bicycle.getArraysOfBicycle();
         break;
         
         default: // for other wrong inputs we have default cases
         System.out.println("Please enter a valid list number!");
         break;
         }
      }theInput.close();
   }
}
