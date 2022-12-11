package com.algorithm.testarrayalgorithm;

public class ValidSizeException extends RuntimeException{
    public ValidSizeException() {
    }

    public ValidSizeException(String message) {
        super(message);
    }

    public ValidSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidSizeException(Throwable cause) {
        super(cause);
    }


}
