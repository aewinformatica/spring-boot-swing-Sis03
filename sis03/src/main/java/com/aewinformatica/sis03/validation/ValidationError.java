package com.aewinformatica.sis03.validation;

public class ValidationError {
	
	private String message;

    public ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
