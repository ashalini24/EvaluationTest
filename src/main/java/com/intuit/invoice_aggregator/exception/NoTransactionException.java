package com.intuit.invoice_aggregator.exception;

/**
 * Created by sgurram on 8/27/17.
 */
public class NoTransactionException extends Exception{
    protected static String message = "No Transaction Found";

    public NoTransactionException() {
        super(message);
    }

    public NoTransactionException(String message) {
        super(message);
    }
}
