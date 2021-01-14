package com;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "officehoursmangementsystem")
public class MessageEntity implements Comparable<MessageEntity> {
    private Integer messageId;
    private String messageContent;
    private String receiverId;
    private String subject;
    private String senderId;
    private Timestamp messageDate;

    @Id
    @Column(name = "MessageID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public Integer getMessageId() {
        return messageId;
    }

    private void setMessageId(Integer messageId) {
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

    @Basic
    @Column(name = "ReceiverId")
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    @Basic
    @Column(name = "Subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Basic
    @Column(name = "SenderId")
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public int compareTo(MessageEntity o) {
        return this.getMessageId().compareTo(o.getMessageId());
    }
    @Basic
    @Column(name = "MessageDate")
    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }
}
