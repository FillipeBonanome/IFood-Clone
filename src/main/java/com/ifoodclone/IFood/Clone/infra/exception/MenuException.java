package com.ifoodclone.IFood.Clone.infra.exception;

public class MenuException extends Throwable {
    public MenuException(String message) {
        super(message);
    }
    public MenuException(String message, Throwable cause) { super(message, cause); }
}
