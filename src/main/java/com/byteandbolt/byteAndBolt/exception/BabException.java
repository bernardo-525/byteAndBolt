package com.byteandbolt.byteAndBolt.exception;

public class BabException extends RuntimeException {
    private final BabErrorMessage errorMessage;

    public BabException(BabErrorMessage errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }
    public BabErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
