package io.github.bartlomiejmilosz.tdd.portfolio.firstattempt;

public class PortfolioPrinter {
    private final Portfolio portfolio;

    public PortfolioPrinter(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void printPortfolio() {
        portfolio.getStocks().forEach(System.out::println);
    }
}
