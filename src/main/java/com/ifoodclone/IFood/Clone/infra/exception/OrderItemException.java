package com.ifoodclone.IFood.Clone.infra.exception;

public class OrderItemException extends Throwable {
    public OrderItemException(String message) {
        super(message);
    }
    public OrderItemException(String message, Throwable cause) { super(message, cause); }
}
