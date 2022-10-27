/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanager.lab8;

import controller.controller;
import java.util.Scanner;
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
                    selectCreate();
                    break;
                case 2:
                    c.printAllCustomer();
                    break;
                case 3:
                    System.out.print("Input City : ");
                    in.nextLine();
                    city = in.nextLine();
                    c.printCustomerByCity(city);
                    break;
                case 0:
                    System.out.print("Close program\n");
                    return;
                default:
                    return;
            }
        }while(true);      
        
    }
    
    private static void selectCreate(){
        //initial input
        c.creatData(1L, "John", "Henry", "jh@mail.com", "123/4 Viphavadee Rd.", "Bangkok", "TH", "10900");
        c.creatData(2L, "Marry", "Jane", "mj@mail.com", "123/5 Viphavadee Rd.", "Bangkok", "TH", "10900");
        c.creatData(3L, "Petter", "Parker", "pp@mail.com", "5443/21 Fake Rd.", "Nonthaburi", "TH", "20900");
        c.creatData(4L, "Bruce", "Wayn", "bw@mail.com", "678/90 Unreal Rd.", "Pathumthani", "TH", "30500");
    }
    
}