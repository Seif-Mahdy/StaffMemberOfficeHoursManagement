package com;

import java.util.Objects;

public class Key {
    private final String sender;

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    private final String receiver;

    public Key(String sender, String receiver) {
        this.sender = sender;
        this.receiver= receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key that = (Key) o;
        return Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver);
    }

}
