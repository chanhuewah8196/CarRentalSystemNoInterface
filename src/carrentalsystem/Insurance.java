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
public class Insurance{
    String agencyComp,agent,phoneNum,emailAdd;
    Scanner input = new Scanner (System.in);
    public Insurance(){
         System.out.println("---------------------------------------------------------------");
         System.out.println("\t\tINSURANCE INFORMATION");
         System.out.println("---------------------------------------------------------------");
         System.out.print("Enter Insurance Agency Company : ");
         agencyComp = input.nextLine();
         System.out.print("Enter Agent Full Name          : ");
         agent = input.nextLine();
         System.out.print("Enter Agent Phone Number       : ");
         phoneNum = input.nextLine();
         System.out.print("Enter Agent Email              : ");
         emailAdd = input.nextLine();
         System.out.println("---------------------------------------------------------------");
         System.out.println("\n");
    }

    public String getAgencyComp() {
        return agencyComp;
    }

    public String getAgent() {
        return agent;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

}
