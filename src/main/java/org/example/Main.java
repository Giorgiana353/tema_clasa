package org.example;

public class Main {
    public static void main(String[] args) {
        Stock amz = new AmazonStock("$", 1000);

        PrivateInvestor john = new PrivateInvestor("John Doe", amz);

        PublicInvestor voo = new PublicInvestor("VOO");

        amz.subscribe(john); // pull
        amz.subscribe(voo);  // push

        amz.setPrice(1001);
        amz.setCurrency("USD");
        amz.unsubscribe(john);
        amz.setPrice(1002);
    }
}
