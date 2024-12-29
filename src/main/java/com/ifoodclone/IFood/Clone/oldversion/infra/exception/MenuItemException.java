package com.ifoodclone.IFood.Clone.oldversion.infra.exception;

public class MenuItemException extends Throwable {
    public MenuItemException(String message) {
        super(message);
    }
    public MenuItemException(String message, Throwable cause) { super(message, cause); }
}
