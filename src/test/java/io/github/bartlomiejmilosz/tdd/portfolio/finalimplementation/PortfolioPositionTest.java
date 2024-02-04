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
    void portfolioWithOnePosition_ReturnsThatPosition() {
        var portfolio = new Portfolio();

        String symbol = "MSFT";

        portfolio.add(new Position(new Stock(symbol), 10, 260));
        Assertions.assertEquals(1, portfolio.getAllPositions().size());

        Assertions.assertEquals(10, portfolio.getPositions(symbol).getQty());
        Assertions.assertEquals(260, portfolio.getPositions(symbol).getPx());
        Assertions.assertEquals(2600, portfolio.getPositions(symbol).getValue());
    }
}