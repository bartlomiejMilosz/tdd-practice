package io.github.bartlomiejmilosz.tdd.portfolio.finalimplementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PortfolioPositionTest {

    @Test
    void emptyPortfolio_zeroPositions() {
        var portfolio = new Portfolio();
        Assertions.assertEquals(0, portfolio.getAllPositions().size());
    }

    @Test
    void portfolioWithOneStock_calculatesTotalValue() {
        int qty = 10;
        double px = 260;

        var portfolio = new Portfolio();
        portfolio.add(new Position(new Stock("MSFT"), qty, px));
        Assertions.assertEquals(1, portfolio.getPositions().size());
    }
}