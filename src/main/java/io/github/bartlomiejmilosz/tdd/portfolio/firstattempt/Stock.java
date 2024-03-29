package io.github.bartlomiejmilosz.tdd.portfolio.firstattempt;

public class Stock {
    private final String symbol;
    private final int qty;
    private final double px;

    public String getSymbol() {
        return symbol;
    }

    public int getQty() {
        return qty;
    }

    public double getPx() {
        return px;
    }

    public Stock(String symbol, int qty, double px) {
        this.symbol = symbol;
        this.qty = qty;
        this.px = px;
    }

    public double totalValue() {
        return qty * px;
    }

    @Override
    public String toString() {
        return String.format("{ %s | Qty: %s | Px: %s | Value: %s}", symbol, qty, px, qty * px);
    }
}


