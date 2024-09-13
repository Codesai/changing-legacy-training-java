package com.portfolio.helper;

public class AssetsFileLinesBuilder {
    private String _dateAsString;
    private String _description;
    private String _valueAsString;

    private AssetsFileLinesBuilder()
    {
        _dateAsString = "";
        _description = "description";
        _valueAsString = "";
    }

    public static AssetsFileLinesBuilder anAsset()
    {
        return new AssetsFileLinesBuilder();
    }

    public AssetsFileLinesBuilder fromDate(String date)
    {
        _dateAsString = date;
        return this;
    }

    public AssetsFileLinesBuilder describedAs(String description)
    {
        _description = description;
        return this;
    }

    public AssetsFileLinesBuilder withValue(int value)
    {
        _valueAsString = String.valueOf(value);
        return this;
    }

    public String build()
    {
        return String.format("%s,%s,%s", _description, _dateAsString, _valueAsString);
    }
}
