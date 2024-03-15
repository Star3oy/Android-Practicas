package com.lalo.chat;

import java.util.Objects;

public class Message {
    private String message;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message1 = (Message) o;
        return Objects.equals(getMessage(), message1.getMessage()) && Objects.equals(getId(), message1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getId());
    }

    public Message(String message, int id) {
        this.message = message;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }

}
