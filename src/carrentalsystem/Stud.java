/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

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
public class Stud extends User{
 
    @Override
    public void getUserDetail(String userType,String name,String ICNumber,String stdID,String phoneNum) {
        
         System.out.println("---------------------------------------------------------------");
         System.out.println("\tTHE INFORMATION OF CUSTOMER" + " - (Student)");
         System.out.println("---------------------------------------------------------------");
         System.out.println("Name                   : " + name.toUpperCase()); 
         System.out.println("IC Number              : " + ICNumber);
         System.out.println("Student ID             : " + stdID.toUpperCase());
         System.out.println("Phone Number           : " + phoneNum);
         System.out.println("---------------------------------------------------------------");
         
         
    }
    
}
