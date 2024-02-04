package io.github.bartlomiejmilosz.tdd.portfolio.firstattempt;

import io.github.bartlomiejmilosz.tdd.portfolio.firstattempt.Portfolio;
import io.github.bartlomiejmilosz.tdd.portfolio.firstattempt.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

    @Test
    void emptyPortfolio_hasZeroValue() {
        var portfolio = new Portfolio();
        Assertions.assertEquals(0, portfolio.totalValue());
    }

    @Test
    void portfolioWithOneStock_calculatesTotalValue() {
        int qty = 10;
        double px = 260;
        double value = qty * px;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("MSFT", qty, px));
        Assertions.assertEquals(value, portfolio.totalValue());
    }

    @Test
    void portfolioWithMultipleStocks_calculatesTotalValue() {
        int microsoftQty = 10;
        double microsoftPx = 260;
        double microsoftValue = microsoftQty * microsoftPx;

        int appleQty = 1;
        double applePx = 150;
        double appleValue = appleQty * applePx;

        var portfolio = new Portfolio();
        portfolio.add(new Stock("MSFT", microsoftQty, microsoftPx));
        portfolio.add(new Stock("AAPL", appleQty, applePx));

        Assertions.assertEquals(microsoftValue + appleValue, portfolio.totalValue());
    }
}
