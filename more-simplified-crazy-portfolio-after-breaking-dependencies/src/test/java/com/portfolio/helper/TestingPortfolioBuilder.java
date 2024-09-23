package com.portfolio.helper;

import java.util.ArrayList;
import java.util.List;

public class TestingPortfolioBuilder {
    private final List<String> lines;
    private String now;

    TestingPortfolioBuilder() {
        lines = new ArrayList<>();
        now = "";
    }

    public static TestingPortfolioBuilder aPortFolio() {
        return new TestingPortfolioBuilder();
    }

    public TestingPortfolioBuilder with(AssetsFileLinesBuilder lineBuilder) {
        lines.add(lineBuilder.build());
        return this;
    }

    public TestingPortfolioBuilder onDate(String dateAsString) {
        now = dateAsString;
        return this;
    }

    public TestingPortfolio build() {
        return new TestingPortfolio(lines, now);
    }
}
