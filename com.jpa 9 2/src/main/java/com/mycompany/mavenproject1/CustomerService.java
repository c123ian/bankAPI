package com.mycompany.mavenproject1;

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

@Path("/customers")
public class CustomerService {
    
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        private EntityManager em = emf.createEntityManager();
        private EntityTransaction tx = em.getTransaction(); 


    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> getPersons() {
       return allEntries();
    }
    
     public List<Customer> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
     
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{cust_id}")
    public Customer getPerson(@PathParam("cust_id") int cust_id) {
        Customer test = em.find(Customer.class, cust_id);
        em.close();
        return test;
    }
    
    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer save(Customer p) {
        Customer test = em.find(Customer.class, p.getId());
        if (test == null) {
            tx.begin();
            em.persist(p);
            tx.commit();
            em.close();
        }
        return p;   
    }
    
        
    @DELETE
    @Path("/{cust_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void deleteItem(@PathParam("id") int cust_id) {
        Customer test = em.find(Customer.class, cust_id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            em.close();
        }
    }
}