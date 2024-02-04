package io.github.bartlomiejmilosz.tdd.portfolio.firstattempt;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private final List<Stock> stocks = new ArrayList<>();

    private double totalValue;
    public void add(Stock stock) {
        stocks.add(stock);
    }

    public double totalValue() {
        if (stocks.isEmpty())
            return 0;
        return stocks.stream()
                .mapToDouble(Stock::totalValue)
                .sum();
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}