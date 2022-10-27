/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author SK
 */
public class model {

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void persist(Address address, Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(address);
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public List<Address> findAllAddress() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT a FROM Address a";
        Query query = em.createQuery(jpql);
        List<Address> addressList = (List<Address>) query.getResultList();
        return addressList;
    }
    
    public List<Customer> findAllCustomer() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT c FROM Customer c";
        Query query = em.createQuery(jpql);
        List<Customer> customerList = (List<Customer>) query.getResultList();
        return customerList;
    }
    
    public void printAll(){
        List<Customer> ctm = findAllCustomer();
        //List<Address> addr = findAllAddress();
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
    
    public static List<Address> findAddressByCity(String city) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT a FROM Address a WHERE a.city = :city";
        Query query = em.createQuery(jpql);
        query.setParameter("city", city);
        List<Address> addressList = (List<Address>) query.getResultList();
        return addressList;
    }
    
    public void printByCity(String city){
        List<Address> addr = findAddressByCity(city);
        if(addr.size()==0)
           System.out.println("Can not find "+city);
        for(int i = 0; i < addr.size(); i++) {
           System.out.println("Firstname : "+addr.get(i).getCustomerFk().getFirstname());
           System.out.println("Lastname : "+addr.get(i).getCustomerFk().getLastname());
           System.out.println("Email : "+addr.get(i).getCustomerFk().getEmail());
           System.out.println("Street : "+addr.get(i).getStreet());
           System.out.println("City : "+addr.get(i).getCity());
           System.out.println("Country : "+addr.get(i).getCountry());
           System.out.println("Zip code : "+addr.get(i).getZipcode());
           System.out.println("--------------------------------------------------------------");
       }
    }
    
}
