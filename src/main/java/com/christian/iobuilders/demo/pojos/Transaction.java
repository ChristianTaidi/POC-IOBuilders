package com.christian.iobuilders.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;


    private String senderPublicKey;
    private String receiverPublicKey;
    private int amount;

    public Transaction(){
        //JPA default constructor
    }

    public Transaction(String sender, int amount) {
        this.senderPublicKey = sender;
        this.amount = amount;
    }

    public Transaction(String sender, String receiver, int amount) {
        this.senderPublicKey = sender;
        this.receiverPublicKey = receiver;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderPublicKey() {
        return senderPublicKey;
    }

    public void setSenderPublicKey(String senderPublicKey) {
        this.senderPublicKey = senderPublicKey;
    }

    public String getReceiverPublicKey() {
        return receiverPublicKey;
    }

    public void setReceiverPublicKey(String receiverPublicKey) {
        this.receiverPublicKey = receiverPublicKey;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
