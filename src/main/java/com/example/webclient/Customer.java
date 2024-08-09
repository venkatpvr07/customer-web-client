package com.example.webclient;

public class Customer {

    private Long id;
    private String name;
    private double total_sales = 0.0;
    private double balance_due = 0.0; 

    public Customer() {}

    public Customer(String name){
        this.name = name;
    }

    // public Customer(Long id, String name){
    //     this.id = id;
    //     this.name = name;
    // }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalSales(){
        return this.total_sales;
    }

    public void setTotalSales(double total_sales) {
        this.total_sales = total_sales;
    }

    public double getBalanceDue(){
        return this.balance_due;
    }

    public void setBalanceDue(double balance_due) {
        this.balance_due = balance_due;
    }
}
