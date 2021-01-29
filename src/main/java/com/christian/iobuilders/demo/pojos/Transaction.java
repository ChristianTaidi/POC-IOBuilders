package com.christian.iobuilders.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Class that represents a Transaction object
 *
 * It contains:
 *
 * - An id used to retrieve data from the database
 * - The transaction sender´s id to identify whose balance will be decresead
 * - The receiver id to identify whose balacne will be increased
 * - The amount to determine how much money will be trransfered
 *
 * This class is also used to add funds to a user account
 * setting only the receiver id this means that tue user is adding funds
 * to the wallet
 */
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

    /**
     * Default constructor ued for JPA
     */
    public Transaction(){
        //JPA default constructor
    }


    /**
     * Basic constructor with only a receiver and amount
     * @param receiver
     * @param amount
     */
    public Transaction(Long receiver, int amount) {
        this.receiverId = receiver;
        this.amount = amount;
    }


    /**
     * Setters and getters
     */

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
