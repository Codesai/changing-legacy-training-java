package com.portfolio;

import java.text.ParseException;

public class UncheckedParseException extends RuntimeException {

    public UncheckedParseException(ParseException e) {
        super(e);
    }
}
