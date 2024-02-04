package io.github.bartlomiejmilosz.tdd.portfolio.firstattempt;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PortfolioTestDriver {
    private static final Logger LOGGER = Logger.getLogger(PortfolioTestDriver.class.getName());

    public static void main(String[] args) {
        var portfolio = new Portfolio();
        portfolio.add(new Stock("AAPL", 1, 140));
        portfolio.add(new Stock("AAPL", 1, 120));
        portfolio.add(new Stock("MSFT", 1, 200));

        var printer = new PortfolioPrinter(portfolio);
        printer.printPortfolio();
        LOGGER.log(Level.INFO, "=================================");
        LOGGER.log(Level.INFO, String.valueOf(portfolio.totalValue()));
    }
}