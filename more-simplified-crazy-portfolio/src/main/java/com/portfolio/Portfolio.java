package com.portfolio;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Portfolio {

    private final String portfolioCsvPath;

    public Portfolio(String portfolioCsvPath) {
        this.portfolioCsvPath = portfolioCsvPath;
    }

    public void computePortfolioValue() {
        var now = new Date();
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(portfolioCsvPath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        var portfolioValue = new MeasurableValue(0);

        for (var line : lines) {
            var columns = line.split(",");
            var dateAsString = columns[1];

            Date dateTime;
            try {
                dateTime = new SimpleDateFormat("yyyy/M/dd", Locale.ROOT).parse(dateAsString);
            } catch (ParseException e) {
                throw new UncheckedParseException(e);
            }

            var asset = new Asset(columns[0],
                    dateTime,
                    columns[0].equals("Unicorn") ? new PricelessValue() : new MeasurableValue(Integer.parseInt(columns[2])));

            if (Duration.between(now.toInstant(), asset.date.toInstant()).toDays() < 0) {
                if (!asset.description.equals("French Wine")) {
                    if (!asset.description.equals("Lottery Prediction")) {
                        if (asset.value.get() > 0) {
                            if (!asset.description.equals("Unicorn")) {
                                asset.value = new MeasurableValue(asset.value.get() - 2);
                            } else {
                                System.out.println("Portfolio is priceless because it got a unicorn!!!!!");
                                return;
                            }
                        }
                    } else {
                        asset.value = new MeasurableValue(asset.value.get() - asset.value.get());
                    }
                } else {
                    if (asset.value.get() < 200) {
                        asset.value = new MeasurableValue(asset.value.get() + 2);
                    }
                }
            } else {
                if (!asset.description.equals("French Wine") && !asset.description.equals("Lottery Prediction")) {
                    if (asset.value.get() > 0.0) {
                        if (!asset.description.equals("Unicorn")) {
                            asset.value = new MeasurableValue(asset.value.get() - 1);
                        } else {
                            System.out.println("Portfolio is priceless because it got a unicorn!!!!!");
                            return;
                        }
                    } else {
                        if (asset.description.equals("Unicorn")) {
                            System.out.println("Portfolio is priceless because it got a unicorn!!!!!");
                            return;
                        }
                    }
                } else {
                    if (asset.description.equals("Lottery Prediction")) {
                        if (asset.value.get() < 800) {
                            asset.value = new MeasurableValue(asset.value.get() + 1);

                            if (Duration.between(now.toInstant(), asset.date.toInstant()).toDays() < 11) {
                                if (asset.value.get() < 800) {
                                    asset.value = new MeasurableValue(asset.value.get() + 1);
                                }
                            }

                            if (Duration.between(now.toInstant(), asset.date.toInstant()).toDays() < 6) {
                                if (asset.value.get() < 800) {
                                    asset.value = new MeasurableValue(asset.value.get() + 1);
                                }
                            }
                        }
                    } else {
                        if (asset.value.get() < 200) {
                            asset.value = new MeasurableValue(asset.value.get() + 1);
                        }
                    }
                }
            }

            portfolioValue = new MeasurableValue(portfolioValue.get() + asset.value.get());
        }

        System.out.println(portfolioValue.toString());
    }

}
