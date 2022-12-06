/* Assignment 1
   Goran Kraljic   L00162123 */
   
import java.util.*;
public class Assignment1
{
   public static void main(String [] args)
   {
      Scanner keyboardIn = new Scanner(System.in);
      double type,meter; 
      int units,bus,bUnits,totBUnits=0;
      double years,below200=0.18,over200=0.23,costOfUnits=0,uStCharge=17.50,rStCharge=21.50,total=0.00;
      double vattot,vat=0.13,amdue,freeunits=200,bUnitsPrice=0.25,costOfbUnits=0,bStCharge=20.00;

      char type,meter;
      int units,bus,bUnits,totBUnits=0;
      double years,below200=0.18,over200=0.23,costOfUnits=0,uStCharge=17.50,rStCharge=21.50,total=0.00;
      double vattot,vat=0.13,amdue,freeunits=200,bUnitsPrice=0.25,costOfbUnits=0,bStCharge=20.00;
      /* added text for the purpose of the Lab
         
       */
      
      System.out.println("****   LYIT Electric   ****");
      System.out.println("Please enter following customer details");
      System.out.print("Enter the customer type Residental[R] or Business[B] ");
      System.out.println("****   LYIT Electric   ****");
      System.out.println("Please enter following customer details");
      System.out.print("Enter the customer type Residental[R] or Business[B] ");
      type = keyboardIn.next().charAt(0);
        
              switch(type)
              {
              default:    do
                        {
                           System.out.print("Invalid customer type entered - please re-enter ");
                           type = keyboardIn.next().charAt(0);
                        } while(type != 'R' && type != 'B');
             case 'r': 
             case 'R': System.out.print("Please enter the number of units used this month: ");
                       units = keyboardIn.nextInt();
                       System.out.print("How many years is the customer with the company: ");
                       years = keyboardIn.nextDouble();
                       System.out.print("Which meter is the customer on Urban[U] or Rural[R]: ");
                       meter = keyboardIn.next().charAt(0);
                                             
                       do
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
                        System.out.println("Electric Bill for month ending 31st January 2022");
                        System.out.println();
                        System.out.println("Customer Type R");
                   
                        if(years > 5 && units <=400)
                           {
                              costOfUnits=units*0.00;  
                           }
                        else if(years >5 && units >400)
                           {
                              costOfUnits=(units-freeunits)*over200;
                           }   
                        else if(years <=3 && units <= 200)
                           {
                              costOfUnits=units*below200;
                           }
                        else
                           {
                              costOfUnits=(200*below200)+((units-200)*over200);
                           }
                           
                    
                   System.out.println("Usage "+units+" Units"+"   �"+costOfUnits);

                   switch(meter)
                   {
                                       
                     case 'u':
                     case 'U': System.out.println("Standing Charge   �"+uStCharge);
                               total=uStCharge+costOfUnits; 
                               break;  
                     case 'r':          
                     case 'R': System.out.println("Standing Charge   �"+rStCharge);
                               total=rStCharge+costOfUnits;
                               break; 
                   }
                     
                   System.out.println();
                   System.out.println("Total           �"+total);
                   vattot=total*vat;
                   System.out.println("VAT @ 13%       �"+vattot);
                   amdue=total+vattot;
                   System.out.println("Amount Due      �"+amdue);
                   
                   break;
           case 'b':        
           case 'B': System.out.print("How many businesses are registered to the electric supply: ");
                     bus=keyboardIn.nextInt();
                     for(int counter=1;counter<=bus;counter++)
                     {
                        System.out.print("Enter number of units used for business "+counter+" ");
                        bUnits=keyboardIn.nextInt();
                        totBUnits=totBUnits+bUnits;    
                     }
                     System.out.println(" ");
                     System.out.println("Electric Bill for month ending 31st January 2022");
                     System.out.println(" ");
                     System.out.println("Customer Type B");
                     costOfbUnits = totBUnits * bUnitsPrice;
                     System.out.println("Usage "+totBUnits+" Units          �"+costOfbUnits);
                     System.out.println("Standing Charge          �"+bStCharge);
                     System.out.println(" ");
                     total = costOfbUnits + bStCharge;
                     System.out.println("Total                  �"+total);
                     vattot = total * vat;
                     System.out.println("VAT @ 13%              �"+vattot);
                     amdue = total + vattot;
                     System.out.println("Amount Due             �"+amdue);
                     break;    
       
       }
 
   }
}
