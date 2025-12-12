package org.example;

public class PublicInvestor implements StockObserverWithData {
    private final String investorName;

    public PublicInvestor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(StockChangeEvent event) {
        System.out.println(
            investorName + " notified (PUSH). " + event.getStockName() + " changed " + event.getField() + " from " + event.getOldValue() + " to " + event.getNewValue() +  " at " + event.getHappenedAt()
        );
    }
}
