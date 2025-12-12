package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements StockPublisher {
    private String name;
    private String currency;
    private double price;

    private final List<StockObserver> pullObservers = new ArrayList<>();
    private final List<StockObserverWithData> pushObservers = new ArrayList<>();

    protected Stock(String name, String currency, double price) {
        this.name = name;
        this.currency = currency;
        this.price = price;
    }

    @Override
    public void subscribe(StockObserver observer) {
        if (!pullObservers.contains(observer)) pullObservers.add(observer);
    }

    @Override
    public void unsubscribe(StockObserver observer) {
        pullObservers.remove(observer);
    }

    @Override
    public void subscribe(StockObserverWithData observer) {
        if (!pushObservers.contains(observer)) pushObservers.add(observer);
    }

    @Override
    public void unsubscribe(StockObserverWithData observer) {
        pushObservers.remove(observer);
    }

    private void notifyPullObservers() {
        pullObservers.forEach(StockObserver::update);
    }

    private void notifyPushObservers(StockChangeEvent event) {
        pushObservers.forEach(o -> o.update(event));
    }

    private void notifyAll(StockChangeEvent event) {
        notifyPullObservers();
        notifyPushObservers(event);
    }

    public String getName() { return name; }
    public String getCurrency() { return currency; }
    public double getPrice() { return price; }

    public void setPrice(double newPrice) {
        if (Double.compare(this.price, newPrice) == 0) return;
        double old = this.price;
        this.price = newPrice;
        notifyAll(new StockChangeEvent(name, StockField.PRICE, old, newPrice));
    }

    public void setCurrency(String newCurrency) {
        if (this.currency.equals(newCurrency)) return;
        String old = this.currency;
        this.currency = newCurrency;
        notifyAll(new StockChangeEvent(name, StockField.CURRENCY, old, newCurrency));
    }

    public void setName(String newName) {
        if (this.name.equals(newName)) return;
        String old = this.name;
        this.name = newName;
        notifyAll(new StockChangeEvent(name, StockField.NAME, old, newName));
    }

//Sa vad daca merge
    public String quote() {
        return name + " " + price + " " + currency;
    }
}
