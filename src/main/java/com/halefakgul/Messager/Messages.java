package com.halefakgul.Messager;

public enum Messages {
    fileNotFoundMessage("An input required. (Ex: compile test.mscc)"),
    ioExceptionMessage("IOException has occoured while file is exporting");
    protected String message;

    Messages(String message) {
        this.message = message;
    }
}
