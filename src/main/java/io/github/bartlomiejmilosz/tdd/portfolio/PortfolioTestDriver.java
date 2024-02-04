package io.github.bartlomiejmilosz.tdd.portfolio;

public class PortfolioTestDriver {
    public static void main(String[] args) {
        var portfolio = new Portfolio();
        portfolio.add(new Stock("AAPL", 1, 140));
        portfolio.add(new Stock("AAPL", 1, 120));
        portfolio.add(new Stock("MSFT", 1, 200));

        var printer = new PortfolioPrinter(portfolio);
        printer.printPortfolio();
        System.out.println("=================================");
        System.out.println(portfolio.totalValue());
    }
}