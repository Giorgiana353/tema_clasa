package org.example;

public class Main {
    public static void main(String[] args) {
        Stock amz = new AmazonStock("$", 1000);

        PrivateInvestor Giorgi = new PrivateInvestor("Giorgi", amz);

        PublicInvestor voo = new PublicInvestor("VOO");

        amz.subscribe(Giorgi); // pull
        amz.subscribe(voo);  // push

        amz.setPrice(201);
        amz.setCurrency("Euro");
        amz.unsubscribe(Giorgi);
        amz.setPrice(100);
    }
}
