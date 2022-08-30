package com.thinkdring.biohealth.exception;

public class NoSuchBeverageInformationException extends RuntimeException{
    private static final long serialVersionUID = 5867172506387382920L;

    public NoSuchBeverageInformationException(String message) {
        super(message);
    }
}
