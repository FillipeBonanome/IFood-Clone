package com.ifoodclone.IFood.Clone.infra.exception;

public class OrderException extends Throwable {
    public OrderException(String message) {
        super(message);
    }
    public OrderException(String message, Throwable cause) { super(message, cause); }
}
