/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accounts")
public class AccountServices {
    
        private EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("test");
        private EntityManager em2 = emf2.createEntityManager();
        private EntityTransaction tx2 = em2.getTransaction(); 


//ACCOUNT
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> getAccount() {
       return allAccounts();
    }
    
     public List<Account> allAccounts() {
        CriteriaBuilder cb = em2.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> rootEntry = cq.from(Account.class);
        CriteriaQuery<Account> all = cq.select(rootEntry);
        TypedQuery<Account> allQuery = em2.createQuery(all);
        return allQuery.getResultList();
    }
     
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{acc_id}")
    public Account getAccount(@PathParam("acc_id") int acc_id) {
        Account test = em2.find(Account.class, acc_id);
        em2.close();
        return test;
    }
    
    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account saveAccount(Account p) {
        Account test = em2.find(Account.class, p.getAccId());
        if (test == null) {
            tx2.begin();
            em2.persist(p);
            tx2.commit();
            em2.close();
        }
        return p;   
    }
    
        
    @DELETE
    @Path("/{acc_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void deleteAccount(@PathParam("id") int acc_id) {
        Account test = em2.find(Account.class, acc_id);
        if (test !=null) {
            tx2.begin();
            em2.remove(test);
            tx2.commit();
            em2.close();
        }
    }
}
