/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carsproject;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

public class CarsProject {
    // 1. Definición de la lista global y el Scanner
    private static List<Users> userList = new ArrayList<>();
    private static Scanner data = new Scanner(System.in);

    // --- MÉTODOS DE MENÚS (VISTAS) ---
    public static void mainMenu() {
        System.out.println("\n::: MAIN MENU :::\n"
                + "[1]. Users \n"
                + "[2]. Cities \n"
                + "[3]. Brands \n"
                + "[4]. Vehicles \n"
                + "[5]. Exit \n"
                + ".::: Press an option: ");
    }

    public static void UsersMainMenu() { 
        System.out.println("\n::: USERS MENU :::\n"
                + "[1]. Register users \n"
                + "[2]. List users \n"
                + "[3]. Search user \n"
                + "[4]. Update user \n"
                + "[5]. Delete user \n"
                + "[6]. Back to main menu \n"
                + ".::: Press an option: ");
    }
     public static void CitisMainMenu(){ 
        System.out.println("::: CITY MENU :::\n"
                + "[1]. Register city \n"
                + "[2]. List cities \n"
                + "[3]. Search city \n"
                + "[4]. Update city \n"
                + "[5]. Delete city \n"
                + "[6]. Back to main menu \n"
                + ".::: Press an option: ");
    }
        public static void BrandsMainMenu(){ 
        System.out.println("::: BRANDS MENU :::\n"
                + "[1]. Register brand \n"
                + "[2]. List brands \n"
                + "[3]. Search brand \n"
                + "[4]. Update brand \n"
                + "[5]. Delete brand \n"
                + "[6]. Back to main menu \n"
                + ".::: Press an option: ");
    }
         public static void VehiclesMainMenu(){ 
        System.out.println("::: VEHICLE MENU :::\n"
                + "[1]. Register vehicle \n"
                + "[2]. List vehicle \n"
                + "[3]. Search vehicle \n"
                + "[4]. Update vehicle \n"
                + "[5]. Delete vehicle \n"
                + "[6]. Back to main menu \n"
                + ".::: Press an option: ");
    }
         

     public static void main(String[] args) {
        int opt = 0;
        boolean menu_status = true;
        
        while (menu_status) {
            mainMenu();
            try {
                opt = Integer.parseInt(data.nextLine()); // Lee como texto y convierte de forma segura
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (opt) {
                case 1: 
                    boolean users_menu_status = true;
                    while (users_menu_status) {
                        UsersMainMenu();
                        int optUsers = 0;
                        try {
                            optUsers = Integer.parseInt(data.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            continue;
                        }
                        
                        switch (optUsers) {
                            case 1:
                                System.out.println("::: CREATE NEW USER :::");
                                register();
                                break;
                                
                            case 2:
                                System.out.println("::: REGISTERED USERS LIST :::");
                                list();
                                break;
                                
                            case 3:
                                System.out.print("Enter ID to search: ");
                                try {
                                    int searchId = Integer.parseInt(data.nextLine());
                                    Users found = search(searchId);
                                    if (found != null) {
                                        System.out.println("Found: " + found.getFirstname() + " " + found.getLastname() + " | Status: " + found.getStatus());
                                    } else {
                                        System.out.println("User not found.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid ID format.");
                                }
                                break;
                                
                            case 4:
                                System.out.print("Enter ID to update: ");
                                try {
                                    int updateId = Integer.parseInt(data.nextLine());
                                    Users current = search(updateId);
                                    if (current != null) {
                                        System.out.print("New Firstname: "); String nom = data.nextLine();
                                        System.out.print("New Lastname: "); String ape = data.nextLine();
                                        System.out.print("New Status: "); String est = data.nextLine();
                                        
                                        Users newData = new Users(updateId, nom, ape, current.getEmail(), current.getMobile_phone(),
                                                                  current.getAddress(), current.getAge(), current.getBirth_date(),
                                                                  current.getCity_id(), est, current.getCreated_at(), "2026-06-08");
                                        update(updateId, newData);
                                    } else {
                                        System.out.println("User not found.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid ID format.");
                                }
                                break;
                                
                            case 5:
                                System.out.print("Enter ID to delete: ");
                                try {
                                    int deleteId = Integer.parseInt(data.nextLine());
                                    delete(deleteId);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid ID format.");
                                }
                                break;
                                
                            case 6:
                                users_menu_status = false; 
                                break;
                                
                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Cities module under construction...");
                    break;
                case 3:
                    System.out.println("Brands module under construction...");
                    break;
                case 4:
                    System.out.println("Vehicles module under construction...");
                    break;
                case 5:
                    System.out.println("Bye, bye");
                    menu_status = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }            
        }                       
    }

    // --- MÉTODOS CRUD CON CONVERSIÓN SEGURA ---

    public static Users register() {
        int id = 0;
        while (true) {
            System.out.print("ID (int): ");
            try {
                id = Integer.parseInt(data.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer for ID.");
            }
        }

        for (Users u : userList) {
            if (u.getId() == id) {
                System.out.println("Error: The ID already exists.");
                return null;
            }
        }

        System.out.print("Firstname: "); String firstname = data.nextLine();
        System.out.print("Lastname: "); String lastname = data.nextLine();
        System.out.print("Email: "); String email = data.nextLine();
        System.out.print("Mobile Phone: "); String mobile_phone = data.nextLine();

        for (Users u : userList) {
            if (u.getEmail().equalsIgnoreCase(email) || u.getMobile_phone().equals(mobile_phone)) {
                System.out.println("Error: Email or Mobile Phone already exists.");
                return null;
            }
        }

        System.out.print("Address: "); String address = data.nextLine();
        
        int age = 0;
        while (true) {
            System.out.print("Age: ");
            try {
                age = Integer.parseInt(data.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number for age.");
            }
        }

        System.out.print("Birth Date (YYYY-MM-DD): "); String birth_date = data.nextLine();
        
        int city_id = 0;
        while (true) {
            System.out.print("City ID (FK): ");
            try {
                city_id = Integer.parseInt(data.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number for City ID.");
            }
        }
        
        System.out.print("Status: "); String status = data.nextLine();

        Users newUser = new Users(id, firstname, lastname, email, mobile_phone, address, age, birth_date, city_id, status, "2026-06-08", "2026-06-08");
        userList.add(newUser);
        System.out.println("User successfully registered!");
        return newUser;
    }

    public static List<Users> list() {
        if (userList.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (Users u : userList) {
                System.out.println("ID: " + u.getId() + " | " + u.getFirstname() + " " + u.getLastname() + " | Status: " + u.getStatus());
            }
        }
        return userList;
    }

    public static Users search(int id) {
        for (Users u : userList) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public static boolean update(int id, Users newData) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.set(i, newData);
                System.out.println("User successfully updated!");
                return true;
            }
        }
        return false;
    }

    public static boolean delete(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.remove(i);
                System.out.println("User successfully deleted!");
                return true;
            }
        }
        System.out.println("User not found.");
        return false;
    }
}