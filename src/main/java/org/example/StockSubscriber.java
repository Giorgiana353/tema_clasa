package org.example;

public interface StockSubscriber {
    void subscribe(IInvestor investor);
    void unsubscribe(IInvestor investor);
}
