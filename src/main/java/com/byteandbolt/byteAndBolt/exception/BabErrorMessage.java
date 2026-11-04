package com.byteandbolt.byteAndBolt.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum BabErrorMessage {
    //User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not Found"),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "Email already exists"),
    PASSWORD_ALREADY_EXISTS(HttpStatus.CONFLICT, "Password already exists"),

    //Generic
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong happened"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request");

    private final HttpStatus httpstatus;
    private final String message;

    private BabErrorMessage(HttpStatus httpstatus, String message) {
        this.httpstatus = httpstatus;
        this.message = message;
    }

    public HttpStatus getHttpstatus() {
        return httpstatus;
    }

    public String getMessage() {
        return message;
    }

    public static HttpStatus getHttpStatus(BabErrorMessage errorMessage) {
        return Arrays.stream(BabErrorMessage.values())
                .filter(element -> element.equals(errorMessage))
                .findFirst()
                .map(element -> element.getHttpstatus())
                .orElse(null);
    }

    public static String getMessage(BabErrorMessage errorMessage){
        return Arrays.stream(BabErrorMessage.values())
                .filter(element -> element.equals(errorMessage))
                .findFirst()
                .map(element -> element.getMessage())
                .orElse(null);
    }

    public static BabErrorMessage getFromHttpStatus(HttpStatus code){
        return Arrays.stream(BabErrorMessage.values())
                .filter(element -> element.getHttpstatus().equals(code))
                .findFirst()
                .orElse(INTERNAL_SERVER_ERROR);
    }
}
