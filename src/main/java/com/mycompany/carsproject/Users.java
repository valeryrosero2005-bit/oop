/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carsproject;

/**
 *
 * @author HOGAR
 */
public class Users {
    //ATRIBUTOS
     private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String mobile_phone;
    private String address;
    private int age;
    private String birth_date; // Usamos String para manejo simple en consola
    private int city_id;
    private String status;
    private String created_at;
    private String updated_at;
    
    //CONSTRUCTORES
      public Users(int id, String firstname, String lastname, String email, String mobile_phone, 
                 String address, int age, String birth_date, int city_id, String status, 
                 String created_at, String updated_at) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile_phone = mobile_phone;
        this.address = address;
        this.age = age;
        this.birth_date = birth_date;
        this.city_id = city_id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
       // Métodos Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile_phone() { return mobile_phone; }
    public void setMobile_phone(String mobile_phone) { this.mobile_phone = mobile_phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getBirth_date() { return birth_date; }
    public void setBirth_date(String birth_date) { this.birth_date = birth_date; }

    public int getCity_id() { return city_id; }
    public void setCity_id(int city_id) { this.city_id = city_id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
}
    
      
    
    

