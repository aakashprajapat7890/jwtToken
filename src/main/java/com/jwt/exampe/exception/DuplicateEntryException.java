package com.jwt.exampe.exception;

public class DuplicateEntryException  extends RuntimeException{

    public DuplicateEntryException(String message)
    {
        super(message);
    }
}
