package com.christian.iobuilders.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long senderId;
    @NotNull
    private Long receiverId;
    @NotNull
    private int amount;

    public Transaction(){
        //JPA default constructor
    }



    public Transaction(Long receiver, int amount) {
        this.receiverId = receiver;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}
