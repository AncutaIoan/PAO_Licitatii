package model;

public final class Notification {
    private final String message;
    private final String from;

    public Notification(String message, String from) {
        this.message = message;
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }
}