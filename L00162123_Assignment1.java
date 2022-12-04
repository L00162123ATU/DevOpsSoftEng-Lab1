/* Assignment 1 -LYIT Electric
   Goran Kraljic   L00162123 
   Date: 25/01/2022*/
   
import java.util.*;                         // Import all classes 
public class L00162123_Assignment1
{
   public static void main(String [] args)
   {
      Scanner keyboardIn = new Scanner(System.in);    // Declare object of Scanner class
      // Declare variables
      char type,meter;
      int units,bus,bUnits,totBUnits=0;
      double years,below200=0.18,over200=0.23,costOfUnits=0,uStCharge=17.50,rStCharge=21.50,total=0.00;
      double vattot,vat=0.13,amdue,freeunits=200,bUnitsPrice=0.25,costOfbUnits=0,bStCharge=20.00;
      String month="31st January 2022";
      
      System.out.println("****   LYIT Electric   ****");
      System.out.println("Please enter following customer details");
      System.out.print("Enter the customer type Residental[R] or Business[B] ");     
      type = keyboardIn.next().charAt(0);          // user input R or B
              switch(type)                 // Using switch statement to allow for residental of business customer
              {
               default: do                 // Validating if user entered allowed letters for customer type, and allowing that lowercase letters are accepted
                        {
                           System.out.print("Invalid customer type entered - please re-enter ");
                           type = keyboardIn.next().charAt(0);                                    // repeating user input until input is R or r  or B or b 
                        } while(type != 'R' && type != 'r' && type != 'B' && type != 'b');      
              case 'r':                                                                           // Case clauses for residental customer
              case 'R':System.out.print("Please enter the number of units used this month: ");    
                       units = keyboardIn.nextInt();                                              // user input for number of units
                       System.out.print("How many years is the customer with the company: ");
                       years = keyboardIn.nextDouble();                                           // user input for how many years user is with the company
                       System.out.print("Which meter is the customer on Urban[U] or Rural[R]: ");
                       meter = keyboardIn.next().charAt(0);                                       // user input for type of meter
                       
                       do                                                                        // Validating if user entered allowed letters for meter and allowing lowercase letters        
                       {
                           if(meter=='U' || meter == 'u' || meter =='R' || meter == 'r')
                           {
                               break;
                           }
                           else
                           {
                               System.out.print("Invalid customer type entered - please re-enter ");
                               meter = keyboardIn.next().charAt(0);
                           }    
                       }while ((meter!='U' || meter!='u') && (meter!='R' || meter!='r'));  
                   
                        System.out.println();
                        System.out.println("Electric Bill for month ending "+month);           // printing out heading for designated mont
                        System.out.println();                                                  
                        System.out.println("Customer Type R");                                 
                        // Calculation for unit charges
                        if(years > 3 && units <=200)                                          
                           {
                              costOfUnits=units*0.00;                                         // special January offer with less than 200 units spent
                           }
                        else if(years >3 && units >200)
                           {
                              costOfUnits=(units-freeunits)*over200;                         // special January offer with more than 200 units spent 
                           }   
                        else if(years <=3 && units <= 200)
                           {
                              costOfUnits=units*below200;                                    // calculation for users that are less then 3 years with company an less then 200 units spent 
                           }
                        else
                           {
                              costOfUnits=(200*below200)+((units-200)*over200);             // all other users
                           }
                             
                        System.out.println("Usage "+units+" Units"+"   €"+costOfUnits);    // print out how many units is used and cost of this units
                         
                        switch(meter)                                                 // switch statement that enables calculation based on type of meter user is using
                        {
                             case 'u':                                                   // case clauses for Urban meter
                             case 'U': System.out.println("Standing Charge   €"+uStCharge); // print out standing charge for urban meter
                                       total=uStCharge+costOfUnits;                         // total for units and standing charge in case of urban meter
                                       break;
                             case 'r':                                                      // case clauses for Rural meter
                             case 'R': System.out.println("Standing Charge   €"+rStCharge); // print out standing charge for rural meter
                                       total=rStCharge+costOfUnits;                         // total for units and standing charge in case of rural meter
                                       break; 
                        }
                     
                        System.out.println();
                        System.out.println("Total           €"+total);                     // print out total depending on which meter is entered
                        vattot=total*vat;                                                  // VAT calculation
                        System.out.println("VAT @ 13%       €"+vattot);                    // print out VAT
                        amdue=total+vattot;                                               // Amount Due calculation
                        System.out.println("Amount Due      €"+amdue);                    // Print out Amount Due   
                        break;
           case 'b':                                                                                   // case clauses for business customer
           case 'B': System.out.print("How many businesses are registered to the electric supply: ");
                     bus=keyboardIn.nextInt();                                                          // enter number of businesses
                     for(int counter=1;counter<=bus;counter++)                                          // using for loop since we know how many businesses user has
                     {                                                                                     
                        System.out.print("Enter number of units used for business "+counter+" ");
                        bUnits=keyboardIn.nextInt();                                                    //  based on number above we enter number of units for each
                        totBUnits=totBUnits+bUnits;                                                     // calculating total for untis spent in all businesses  
                     }
                     System.out.println(" ");
                     System.out.println("Electric Bill for month ending 31st January 2022");
                     System.out.println(" ");
                     System.out.println("Customer Type B");
                     costOfbUnits = totBUnits * bUnitsPrice;                                            // calculating cost of units spent in all businesses
                     System.out.println("Usage "+totBUnits+" Units          €"+costOfbUnits);           // print out how many units businesses spent togather and cost for this units  
                     System.out.println("Standing Charge          €"+bStCharge);                        // print out standing charge
                     System.out.println(" ");
                     total = costOfbUnits + bStCharge;                                                  // calculating total for cost of units and standing charge for business
                     System.out.println("Total                  €"+total);
                     vattot = total * vat;                                                              // calculating amount of VAT
                     System.out.println("VAT @ 13%              €"+vattot);                             // print out VAT
                     amdue = total + vattot;                                                            // calculating Amount Due
                     System.out.println("Amount Due             €"+amdue);                              // print out Amount Due
                     break;
                                 
            }                                                             // close switch(type)
            System.out.println();
            System.out.print("Thank you for using our services");
   }             // close main method
}           