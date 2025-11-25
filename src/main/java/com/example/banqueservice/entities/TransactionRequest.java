package com.example.banqueservice.entities;

import java.util.Date;

public class TransactionRequest {
    int id;
    Double montant;
    String date;
    TypeTransaction type;

    public TransactionRequest(TypeTransaction type, Double montant, String date) {
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public long getCompteId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
