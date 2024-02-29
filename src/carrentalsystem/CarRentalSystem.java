/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;
import java.util.Scanner;
/**
 *
 * COURSE     : BCS2143 OBJECT ORIENTED PROGRAMMING
 * SECTION    : 02
 * GROUP      : 10
 * ASSESSMENT : PROJECT PHASE 2
 * 
 * Group Member:
 * 1) CHAN HUE WAH (CA19059) (LEADER)
 * 2) BENEDICT HWONG NAI YI (CA19109)
 * 3) TANG XIN ZHE (CA19101)
 * 4) SOH KAI JIE (CA19091)
 * 5) YEW JIA YIE (CA19068)
 * 
 */
public class CarRentalSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        //input customer details
         System.out.println("------------------------------------------------");
         System.out.println("------------------------------------------------");
         System.out.println("\t   !!! WELCOME !!!");
         System.out.println("\tONLINE CAR RENTAL SYSYEM");
         System.out.println("------------------------------------------------");
         System.out.println("------------------------------------------------");
         System.out.print("Are you Student? (Yes/No) : ");
         String userType = input.nextLine();
         if (userType.equalsIgnoreCase("yes")){
             userType = "Student";
         }else if(userType.equalsIgnoreCase("no")){
             userType = "NonStudent";
         }else{
             userType = "INVALID";
         }
         System.out.print("Enter Your Name           : ");
         String name = input.nextLine();
         System.out.print("Enter Your IC Number      : ");
         String ICnumber = input.nextLine();
         String stdID = null;
         if (userType.equalsIgnoreCase("student")){
            System.out.print("Enter Your Student ID     : ");
            stdID = input.nextLine();
         }
         System.out.print("Enter Your Phone Number   : ");
         String phone = input.nextLine();
         System.out.println("---------------------------------------------------------------"); //end input customer details

         System.out.println("---------------------------------------------------------------");
         System.out.println("\tLIST OF CAR AVAILABLE");
         System.out.println("---------------------------------------------------------------");
         System.out.println("Five Seater Car :::");
         System.out.println("A - Proton Iriz [Grey, Automatic, AHK8616, RM6 per hour]"); 
         System.out.println("B - Proton Axia [White, Automatic, JDG9966, RM7 per hour]");
         System.out.println("C - Myvi [Black, Automatic, WCJ4863, RM8 per hour]\n");
         System.out.println("Seven Seater Car :::");
         System.out.println("A - Proton Avanza [Red, Manual, WUV6374, RM9 per hour]");
         System.out.println("B - Proton Exora [Blue, Automatic, BEN7274, RM10 per hour]");
         System.out.println("---------------------------------------------------------------");
        
         System.out.println("How many car do you want to rent? : ");
         int number = input.nextInt();
     
        //array declaration for car
        RentalInfo[] info = new RentalInfo[number];
        RentalOption[] option = new RentalOption[number];// declare rental option obj 
        //get the concrete obj from the factory method()
        CarRental[] rental = new CarRental[number];
            
         //input car rental (array)
         int i = 0;
         while(i<number){
             System.out.println("---------------------------------------------------------------");
             System.out.println("Car " + (i+1));
             System.out.println("Enter Car Type (Five/Seven) Seater :");
             String model = input.next();
             if(model.equalsIgnoreCase("five")) {
                 System.out.println("\nFive Seaters Car List");
                 System.out.println("*** Iriz *** \n*** Axia *** \n*** Myvi ***\n");
             }else if(model.equalsIgnoreCase("seven")){
                 System.out.println("\nSeven Seaters Car List");
                 System.out.println("*** Avanza *** \n*** Exora ***\n");
             }else {
                 model = "INVALID";
             }
             System.out.println("Enter Type of Car                  : ");
             String type = input.next();
             System.out.println("Enter Departure Time               : ");
             String time = input.next();
             System.out.println("Enter Rental Hour (per hour)       : ");
             int hour = input.nextInt();
            
             info[i] = new RentalInfo(model, type, hour, time);//store rental info as array
             option[i] = new RentalOption();// array rental option obj  
             rental[i] = option[i].getCar(model);//get array concrete obj from the rental option method()
             System.out.println("---------------------------------------------------------------\n");
             i++;
         }//end input car rental
         
         Insurance insurance = new Insurance();//create obj for aggregation
         RentalInfo rent = new RentalInfo(insurance);
         
        //polymophism - User class as abstract
        User customer1 = new Stud();
        User customer2 = new NonStud();
        
        //output for customer details
        if (userType.equalsIgnoreCase("student")){
            customer1.getUserDetail(userType, name, ICnumber,stdID, phone);
        }else if(userType.equalsIgnoreCase("nonstudent")){
            customer2.getUserDetail(userType, name, ICnumber,stdID, phone);
        }else{
            System.out.println("Invalid Input!!");
        }//end customer details
         
         System.out.println("\tTHE DETAIL OF CAR RENTAL");
         System.out.println("---------------------------------------------------------------");

         double TotalStudPrice = 0;
         double TotalNonStudPrice = 0;
         
         for(int j=0; j<number; j++){
             System.out.println("Number of car rent     : " + (j+1)); 
             System.out.println("Car Seater             : " + info[j].getCarModel().toUpperCase() + " SEATERS"); 
             System.out.println("Type of Car            : " + info[j].getCarType().toUpperCase() + "(" + info[j].getColor_().toUpperCase() + ")");
             System.out.println("Car Plate Number       : " + info[j].getPlateNum_());
             System.out.println("Transmission           : " + info[j].getTransmission_());
             System.out.println("Powertrain             : " + info[j].getPowertrain_());
             System.out.println("Departure Time         : " + info[j].getTimeStart()); 
             System.out.println("Hour of Rent           : " + info[j].getRentHour() + " hours"); 
             System.out.println("---------------------------------------------------------------");
             
            double studentPrice = 0;
            double nonStudentPrice = 0;
            
         if (userType.equalsIgnoreCase("student")){
             
             studentPrice = rental[j].getStudPrice(info[j].getCarModel(), info[j].getCarType(), userType, info[j].getRentHour());
             System.out.println("Total Price for Car " + (j+1) + "  : RM " + studentPrice);
             System.out.println("---------------------------------------------------------------");
             TotalStudPrice+=studentPrice;
             
         }else if(userType.equalsIgnoreCase("nonstudent")){

              nonStudentPrice = rental[j].getNonStudPrice(info[j].getCarModel(), info[j].getCarType(), userType, info[j].getRentHour());
              System.out.println("Total Price of Car " + (j+1) + "  : RM " + nonStudentPrice);
              System.out.println("---------------------------------------------------------------");
              TotalNonStudPrice+=nonStudentPrice;
         }
         else{
             System.out.println("Invalid Input!!");    
         }
         }//end car details
         
         //Displaying the overall total price in RM
         System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
         if (userType.equalsIgnoreCase("student")) {
             System.out.println("Overall Total Price for " + number + " Cars : RM " + TotalStudPrice);
         }else if(userType.equalsIgnoreCase("nonstudent")) {
             System.out.println("Overall Total Price for " + number + " Cars : RM " + TotalNonStudPrice);
         }else {
             System.out.println("Invalid Input!!");    
         }
         System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

         System.out.println("---------------------------------------------------------------");
         System.out.println("\tINSURANCE DETAILS");
         System.out.println("---------------------------------------------------------------");
         System.out.println("Insurance Agency        : " + rent.getAgencyComp_()); 
         System.out.println("Agent Name              : " + rent.getAgent_()); 
         System.out.println("Phone number            : " + rent.getPhoneNum_()); 
         System.out.println("Email                   : " + rent.getEmailAdd_()); 
         System.out.println("---------------------------------------------------------------\n");
    }
}
