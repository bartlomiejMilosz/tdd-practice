package io.github.bartlomiejmilosz.tdd.portfolio.finalimplementation;

public class Position {
    private final Stock stock;
    private int qty;
    private double px;

    public Position(Stock stock, int qty, double px) {
        this.stock = stock;
        this.qty = qty;
        this.px = px;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQty() {
        return qty;
    }

    public double getPx() {
        return px;
    }

    public double getValue() {
        return qty * px;
    }

    public void setQuantity(int newQty) {
        this.qty = newQty;
    }

    public void setAveragePx(double newAveragePx) {
        this.px = newAveragePx;
    }
}
