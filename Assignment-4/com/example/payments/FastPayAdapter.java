package com.example.payments;

public class FastPayAdapter implements PaymentGateway{
  FastPayClient fastPayClient;

  public FastPayAdapter(FastPayClient fastPayClient){
    this.fastPayClient = fastPayClient;
  }

  public String charge(String customerId, int amountInt){
    return this.fastPayClient.payNow(customerId, amountInt);
  }
}
