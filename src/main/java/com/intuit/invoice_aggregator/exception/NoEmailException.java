package com.intuit.invoice_aggregator.exception;

/**
 * Created by sgurram on 8/27/17.
 */
public class NoEmailException extends Exception{
    protected static String message = "Email address was Not provided or Not valid is not provided";

    public NoEmailException() {
        super(message);
    }

    public NoEmailException(String message) {
        super(message);
    }
}
