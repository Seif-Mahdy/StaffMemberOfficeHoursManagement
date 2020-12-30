package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "officehoursmangementsystem")
public class MessageEntity {
    private Integer messageId;
    private String messageContent;

    @Id
    @Column(name = "MessageID")
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "MessageContent")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(messageId, that.messageId) && Objects.equals(messageContent, that.messageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageContent);
    }
}
