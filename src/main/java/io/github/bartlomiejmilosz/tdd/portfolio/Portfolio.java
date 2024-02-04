package io.github.bartlomiejmilosz.tdd.portfolio;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Stock> stocks = new ArrayList<>();
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
}