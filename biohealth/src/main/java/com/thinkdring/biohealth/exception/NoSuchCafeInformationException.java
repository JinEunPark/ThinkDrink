package com.thinkdring.biohealth.exception;

public class NoSuchCafeInformationException extends RuntimeException{
    private static final long serialVersionUID = 4867172506387382920L;

    public NoSuchCafeInformationException(String message) {
        super(message);
    }
}
