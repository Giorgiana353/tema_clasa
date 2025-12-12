package org.example;

import java.time.Instant;

public final class StockChangeEvent {
    private final String stockName;
    private final StockField field;
    private final Object oldValue;
    private final Object newValue;
    private final Instant happenedAt;

    public StockChangeEvent(String stockName, StockField field, Object oldValue, Object newValue) {
        this.stockName = stockName;
        this.field = field;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.happenedAt = Instant.now();
    }

    public String getStockName() { return stockName; }
    public StockField getField() { return field; }
    public Object getOldValue() { return oldValue; }
    public Object getNewValue() { return newValue; }
    public Instant getHappenedAt() { return happenedAt; }
}
