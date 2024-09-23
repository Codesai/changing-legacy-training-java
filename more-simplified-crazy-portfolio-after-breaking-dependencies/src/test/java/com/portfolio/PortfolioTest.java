package com.portfolio;

import org.junit.jupiter.api.Test;

import static com.portfolio.helper.AssetsFileLinesBuilder.anAsset;
import static com.portfolio.helper.TestingPortfolioBuilder.aPortFolio;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PortfolioTest {

    @Test
    public void regular_asset_value_decreases_by_2_before_now() {
        var portfolio = aPortFolio()
                .with(anAsset().describedAs("Some Regular Asset")
                        .fromDate("2024/01/15").withValue(100))
                .onDate("2025/01/01")
                .build();

        portfolio.computePortfolioValue();

        assertEquals(portfolio.messages.get(0), "98");
    }
}
