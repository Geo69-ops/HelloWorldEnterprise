package com.hwe.helloworldenterprise.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

   @Id
   private long id;
   @Column(unique = true)
   private String email;
   @Temporal(TemporalType.DATE)
   private  Date updatedAt;
   @Temporal(TemporalType.DATE)
   private Date createdAt;
   @ManyToOne
   private Enterprise enterprise;
   @OneToMany
   private List<Transaction> transactions;

   public Employee() {
      this.transactions = new ArrayList<>();
   }


   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Date getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public Enterprise getEnterprise() {
      return enterprise;
   }

   public void setEnterprise(Enterprise enterprise) {
      this.enterprise = enterprise;
   }

   public List<Transaction> getTransactions() {
      return transactions;
   }

   public void setTransactions(List<Transaction> transactions) {
      this.transactions = transactions;
   }

   @Override
   public String toString() {
      return "Employee{" +
              "id=" + id +
              ", email='" + email + '\'' +
              ", updatedAt=" + updatedAt +
              ", createdAt=" + createdAt +
              ", enterprise=" + enterprise +
              ", transactions=" + transactions +
              '}';
   }
}

