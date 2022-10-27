/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.model;
import model.Address;
import model.Customer;

/**
 *
 * @author SK
 */
public class controller {
    model m;
    public controller() {
        m = new model();
    }
    
    public void setData(Long id, String firstname, String lastname, String email, String street, String city, String country, String zipcode){
        Customer customer = new Customer(id, firstname, lastname, email);
        Address address = new Address(id, street, city, zipcode, country);
        address.setCustomerFk(customer);
        customer.setAddressId(address);
        m.persist(address, customer);
    }
    
    public List<Customer> getAllCustomer(){
        return m.findAllCustomer();
    }
    
    public List<Customer> getCustomerByCity(String city){
        return m.findCustomerByCity(city);
    }
}
