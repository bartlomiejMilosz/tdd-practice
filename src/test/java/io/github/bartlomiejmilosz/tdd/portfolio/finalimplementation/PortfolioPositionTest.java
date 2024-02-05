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

    @Test
    void portfolioWithTwoDifferentPositions_ReturnsThosePositions() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        String apple = "AAPL";

        portfolio.add(position(microsoft, 10, 260));
        portfolio.add(position(apple, 2, 150));

        Assertions.assertEquals(2, portfolio.getAllPositions().size());

        // msft
        var microsoftPosition = portfolio.getPositions(microsoft);
        Assertions.assertEquals(10, microsoftPosition.getQty());
        Assertions.assertEquals(260, microsoftPosition.getPx());
        Assertions.assertEquals(2600, microsoftPosition.getValue());

        // aapl
        var applePosition = portfolio.getPositions(apple);
        Assertions.assertEquals(2, applePosition.getQty());
        Assertions.assertEquals(150, applePosition.getPx());
        Assertions.assertEquals(300, applePosition.getValue());
    }

    static Position position(String symbol, int qty, double px) {
        return new Position(new Stock(symbol), qty, px);
    }

    @Test
    void portfolioWithSameStock_ReturnsOnePosition() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";

        portfolio.add(position(microsoft, 10, 260));
        portfolio.add(position(microsoft, 5, 200));

        Assertions.assertEquals(1, portfolio.getAllPositions().size());
    }

    @Test
    void portfolioWithSameStock_ReturnsCorrectQty() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";

        portfolio.add(position(microsoft, 10, 260));
        portfolio.add(position(microsoft, 1, 200));

        Assertions.assertEquals(11, portfolio.getPositions(microsoft).getQty());
    }

    @Test
    void portfolioWithSameStock_ReturnsCorrectAveragePrice() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(position(microsoft, 1, 240));
        portfolio.add(position(microsoft, 1, 220));

        Assertions.assertEquals(230, portfolio.getPositions("MSFT").getPx());
    }

    @Test
    void portfolioWithSameStock_ReturnsCorrectPositionValue() {
        var portfolio = new Portfolio();

        String microsoft = "MSFT";
        portfolio.add(position(microsoft, 2, 240));
        portfolio.add(position(microsoft, 1, 220));

        double expected = 2 * 240 + 220;
        Assertions.assertEquals(expected, portfolio.getPositions(microsoft).getValue());
    }

    @Test
    void complexPortfolio_ReturnsCorrectTotalValue() {
        var portfolio = new Portfolio();

        portfolio.add(position("MSFT", 1, 260));
        portfolio.add(position("MSFT", 2, 250));

        portfolio.add(position("AAPL", 5, 90));
        portfolio.add(position("AAPL", 10, 80));

        portfolio.add(position("ORCL", 100, 80));

        Assertions.assertEquals(3, portfolio.getAllPositions().size());
        Assertions.assertEquals(10010, portfolio.getTotalValue());
    }
}