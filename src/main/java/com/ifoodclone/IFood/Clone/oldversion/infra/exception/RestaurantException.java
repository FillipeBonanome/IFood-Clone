package com.ifoodclone.IFood.Clone.oldversion.infra.exception;

public class RestaurantException extends Throwable {
    public RestaurantException(String message) {
        super(message);
    }

    public RestaurantException(String message, Throwable cause) {
        super(message, cause);
    }
}
