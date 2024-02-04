package io.github.bartlomiejmilosz.tdd.portfolio;

public class Portfolio {
    private Stock stock;
    private double totalValue;

    public void add(Stock stock) {
        this.stock = stock;
    }

    public double totalValue() {
        if (stock == null)
            return 0;
        return stock.totalValue();
    }
}