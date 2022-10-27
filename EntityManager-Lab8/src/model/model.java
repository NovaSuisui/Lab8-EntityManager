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
  
    public List<Address> findAddressByCity(String city) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT a FROM Address a WHERE a.city = :city";
        Query query = em.createQuery(jpql);
        query.setParameter("city", city);
        List<Address> addressList = (List<Address>) query.getResultList();
        return addressList;
    }
    
    public List<Customer> findCustomerByCity(String city) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManager-Lab8PU");
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT c FROM Customer c WHERE c.addressId.city = :city";
        Query query = em.createQuery(jpql);
        query.setParameter("city", city);
        List<Customer> customerList = (List<Customer>) query.getResultList();
        return customerList;
    }
    
}
