/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author x17160430
 */
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
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int sort_code;
    private int acc_id; //pk
    private double debit_bal;
    private double credit_bal;

    //cust_id is the Foreign Key from Customer?
    //second FK trans_id to connect with Transaction?
    
   
    //account id

    public int getAccId() {
        return acc_id;
    }

   
    public void setAccId(int acc_id) {
        this.acc_id = acc_id;
    }
    
    //sortcode methods
    
     public int getAccSortCode() {
        return sort_code;
    }

   
    public void setAccSortCode(int sort_code) {
        this.sort_code = sort_code;
    }
    
    //debit_bal
    
     public double getAccDebitBal() {
        return debit_bal;
    }
   
    public double setAccDebitBal(int debit_bal) {
        this.debit_bal = debit_bal;
        return 0;
    }
    
    //credit account
    
      public double getAccCreditBal() {
        return credit_bal;
    }
   
    public double setAccCreditBal(int credit_bal) {
        this.credit_bal = credit_bal;
        return 0;
      
    }
    
     

}
