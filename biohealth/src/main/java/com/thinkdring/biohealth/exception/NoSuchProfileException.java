package com.thinkdring.biohealth.exception;

public class NoSuchProfileException extends RuntimeException {
    //
    private static final long serialVersionUID = 2867172506387382920L;

    public NoSuchProfileException(String message) {
        super(message);
    }
}

