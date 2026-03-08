package com.example.payments;



public class SafeCashAdapter implements PaymentGateway {

  SafeCashClient safecashClient;

  public SafeCashAdapter(SafeCashClient safeCashClient){
    this.safecashClient = safeCashClient;
  }



  public String charge(String customerId, int amountCents){
    SafeCashPayment safecashPayment = this.safecashClient.createPayment(amountCents, customerId);
    return safecashPayment.confirm();
  }
  
}
