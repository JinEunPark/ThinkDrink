package com.thinkdring.biohealth.exception;

public class NoSuchHealthInformationException extends RuntimeException{
    private static final long serialVersionUID = 3867172506387382920L;

    public NoSuchHealthInformationException(String message) {
        super(message);
    }
}
