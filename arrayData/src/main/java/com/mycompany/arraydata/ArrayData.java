/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraydata;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joan
 */
public class ArrayData {

    public static void mainMenu(){ 
        System.out.println("::: MAIN MENU :::\n"
                + "[1]. Create/register users \n"
                + "[2]. List users \n"
                + "[3]. Search user \n"
                + "[4]. Update user \n"
                + "[5]. Delete user \n"
                + "[6]. Exit \n"
                + ".::: Press an option: ");
    }
    
    public static void main(String[] args) {
        Scanner data=new Scanner(System.in);
   
        ArrayList<String> identNumbers = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        String firstname, lastname, email, key, ident_number;
        int age, opt;
        boolean menu_status = true;
        
        int i=1;
        while(menu_status){
            mainMenu();
            opt=data.nextInt();
            data.nextLine();
            
            switch (opt){
                case 1:
                    System.out.println("::: REGISTER NEW USER :::");
                    System.out.println("\nUser Nro.: " + (firstNames.size()+1));   
            
                    System.out.println("Identification number: ");   
                    ident_number=data.nextLine();
                    System.out.println("First name: ");   
                    firstname=data.nextLine();
                    System.out.println("Last name: ");   
                    lastname=data.nextLine();
                    System.out.println("Email: ");   
                    email=data.nextLine();
                    System.out.println("Age: ");   
                    age=data.nextInt();
                    data.nextLine();

                    identNumbers.add(ident_number);
                    firstNames.add(firstname);
                    lastNames.add(lastname);
                    emails.add(email);
                    ages.add(age);
                    System.out.println("\nUser has been registered successfully !!!");
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 2:
                    
                    System.out.println("Total users: " + firstNames.size());
                    if (firstNames.size() == 0){
                        System.out.println("No users !!!");
                    }else{
                        for(int  j = 0; j < firstNames.size(); j+=1){
                            System.out.println("User " + (j+1) + ": " 
                                    + identNumbers.get(j) + " | " 
                                    + firstNames.get(j) + " | " 
                                    + lastNames.get(j) + " | " 
                                    + emails.get(j) + " | " 
                                    + ages.get(j));
                        }
                    }
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 3:
                    System.out.println("Search user");
                    if (identNumbers.size()==0){
                        System.out.println("No users registered in the sistem yet");
                    }
                   else
                        System.out.println("enter the identification number to search ");
                    String searchIdent =data.nextLine();
                    int index= identNumbers.indexOf(searchIdent);
                    if (index != -1){
                        System.out.println("User Found");
                        System.out.println("ID: " + identNumbers.get (index));
                        System.out.println("First Name: " + firstNames.get (index));
                        System.out.println("Last Name: " + lastNames.get (index));
                        System.out.println("Email: " + emails.get (index));
                        System.out.println("Ages: " + ages.get (index));
                    }
                    else{
                        System.out.println("User with ID: "+ searchIdent + " not found.");
                }
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 4:
                    System.out.println("Update user");
                   if (identNumbers.size()==0){
                        System.out.println("No users registered in the sistem yet");
                    }
                   else
                       System.out.println("enter the identification number of the user to update: ");
                    String idActualizar =data.nextLine();
                    int posicion = identNumbers.indexOf(idActualizar);
                    if(posicion != -1){
                   System.out.println ("Curren email: "+ emails.get(posicion));
                   System.out.println("Enter the new email: ");
                   email=data.nextLine();
                   emails.set(posicion,email);
                   System.out.println("Email updated successfully!");}
                    else {
                        System.out.println ("User with ID: "+ idActualizar + " Not foun.");
                    }
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 5:
                    System.out.println("Delete user");
                    if (identNumbers.size()==0){
                        System.out.println("No users registered in the sistem yet");
                    }
                   else
                        System.out.println("enter the identification number of the user to update: ");
                    if(data.hasNextLine()){data.nextLine();
                    String deleteIdent = data.nextLine();
                    posicion= identNumbers.indexOf(deleteIdent);
                    
                    if (posicion !=-1){
                        identNumbers.remove(posicion);
                        firstNames.remove(posicion);
                        lastNames.remove(posicion);
                        emails.remove(posicion);
                        ages.remove(posicion);
                        System.out.println("User has been deleted successfully!");}
                    else{
                        System.out.println ("User with ID: "+ deleteIdent + " Not foun.");
                    } 
            }
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                    
                case 6:
                    System.out.println("Bye, bye");
                    menu_status = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
