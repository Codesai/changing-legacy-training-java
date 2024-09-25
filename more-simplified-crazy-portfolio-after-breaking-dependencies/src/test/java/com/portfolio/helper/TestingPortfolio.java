package com.portfolio.helper;

import com.portfolio.Portfolio;
import com.portfolio.UncheckedParseException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TestingPortfolio extends Portfolio {
    private final List<String> assetsFileLines;
    private final Date now;
    public List<String> messages;

    public TestingPortfolio(List<String> assetsFileLines, String nowAsString) {
        super("");
        this.assetsFileLines = assetsFileLines;
        this.now = parseDate(nowAsString);
        messages = new ArrayList<>();
    }

    @Override
    protected Date getNow() {
        return now;
    }

    @Override
    protected List<String> readAssetsFileLines() {
        return assetsFileLines;
    }

    @Override
    protected void displayMessage(String message) {
        messages.add(message);
    }

    @Override
    protected Date createAssetDateTime(String dateAsString) {
        return parseDate(dateAsString);
    }

    private Date parseDate(String dateAsString) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/dd", new Locale("en", "US"));
        try {
            return formatter.parse(dateAsString);
        } catch (ParseException e) {
            throw new UncheckedParseException(e);
        }
    }
}
