/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanager.lab8;

import controller.controller;
import java.util.List;
import java.util.Scanner;
import model.Customer;
/**
 *
 * @author SK
 */
public class EntityManagerLab8 {

    static controller c;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        c = new controller();
        Scanner in = new Scanner(System.in);
        int choice;
        String city;
        do{
            System.out.println("Select1");
            System.out.println("1 createData");
            System.out.println("2 printAllCustomer");
            System.out.println("3 printCustomerByCity");
            System.out.println("0 Exit");
            System.out.print(": ");
            choice = in.nextInt();
            switch (choice){
                case 1:
                    createData();
                    break;
                case 2:
                    printAllCustomer();
                    break;
                case 3:
                    System.out.print("Input City : ");
                    in.nextLine();
                    city = in.nextLine();
                    printCustomerByCity(city);
                    break;
                case 0:
                    System.out.print("Close program\n");
                    return;
                default:
                    return;
            }
        }while(true);      
        
    }
    
    private static void createData(){
        //initial input
        c.setData(1L, "John", "Henry", "jh@mail.com", "123/4 Viphavadee Rd.", "Bangkok", "TH", "10900");
        c.setData(2L, "Marry", "Jane", "mj@mail.com", "123/5 Viphavadee Rd.", "Bangkok", "TH", "10900");
        c.setData(3L, "Petter", "Parker", "pp@mail.com", "5443/21 Fake Rd.", "Nonthaburi", "TH", "20900");
        c.setData(4L, "Bruce", "Wayn", "bw@mail.com", "678/90 Unreal Rd.", "Pathumthani", "TH", "30500");
    }
    
    public static void printAllCustomer(){
        List<Customer> ctm = c.getAllCustomer();
        for(int i = 0; i < ctm.size(); i++) {
           System.out.println("Firstname : "+ctm.get(i).getFirstname());
           System.out.println("Lastname : "+ctm.get(i).getLastname());
           System.out.println("Email : "+ctm.get(i).getEmail());
           System.out.println("Street : "+ctm.get(i).getAddressId().getStreet());
           System.out.println("City : "+ctm.get(i).getAddressId().getCity());
           System.out.println("Country : "+ctm.get(i).getAddressId().getCountry());
           System.out.println("Zip code : "+ctm.get(i).getAddressId().getZipcode());
           System.out.println("--------------------------------------------------------------");
       }
    }
    
    public static void printCustomerByCity(String city){
        List<Customer> ctm = c.getCustomerByCity(city);
        if(ctm.size()==0)
           System.out.println("Can not find "+city);
        for(int i = 0; i < ctm.size(); i++) {
           System.out.println("Firstname : "+ctm.get(i).getFirstname());
           System.out.println("Lastname : "+ctm.get(i).getLastname());
           System.out.println("Email : "+ctm.get(i).getEmail());
           System.out.println("Street : "+ctm.get(i).getAddressId().getStreet());
           System.out.println("City : "+ctm.get(i).getAddressId().getCity());
           System.out.println("Country : "+ctm.get(i).getAddressId().getCountry());
           System.out.println("Zip code : "+ctm.get(i).getAddressId().getZipcode());
           System.out.println("--------------------------------------------------------------");
       }
    }

}