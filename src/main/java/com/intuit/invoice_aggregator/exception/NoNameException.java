package com.intuit.invoice_aggregator.exception;

/**
 * Created by sgurram on 8/27/17.
 */
public class NoNameException extends Exception{
    protected static String message = "Name of the Merchant is not provided";

    public NoNameException() {
        super(message);
    }

    public NoNameException(String message) {
        super(message);
    }
}
