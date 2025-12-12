package org.example;

public class PrivateInvestor implements StockObserver {
    private final String investorName;
    private final Stock stock; // pentru PULL

    public PrivateInvestor(String investorName, Stock stock) {
        this.investorName = investorName;
        this.stock = stock;
    }

    @Override
    public void update() {
        System.out.println(investorName + " notified (PULL). Current quote: " + stock.quote());
    }
}
