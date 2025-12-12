package org.example;

public interface StockPublisher {
    void subscribe(StockObserver observer);
    void unsubscribe(StockObserver observer);

    void subscribe(StockObserverWithData observer);
    void unsubscribe(StockObserverWithData observer);
}
