package com.mycompany.mavenproject1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
// @Table 
@XmlRootElement
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int cust_id;
    private String name;
    private String address;
    private String email;

    public int getId() {
        return cust_id;
    }

    public String getName() {
        return name;
    }

    public void setId(int cust_id) {
        this.cust_id = cust_id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
      public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
