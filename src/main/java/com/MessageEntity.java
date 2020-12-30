package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "officehoursmangementsystem", catalog = "")
public class MessageEntity {
    private int messageId;
    private String studentId;
    private String staffId;
    private String messageContent;
    private StudentEntity studentByStudentId;
    private StaffmemberEntity staffmemberByStaffId;

    @Id
    @Column(name = "MessageID")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "StudentId")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "StaffId")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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
        return messageId == that.messageId && Objects.equals(studentId, that.studentId) && Objects.equals(staffId, that.staffId) && Objects.equals(messageContent, that.messageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, studentId, staffId, messageContent);
    }

    @ManyToOne
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId")
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "StaffId", referencedColumnName = "StaffId")
    public StaffmemberEntity getStaffmemberByStaffId() {
        return staffmemberByStaffId;
    }

    public void setStaffmemberByStaffId(StaffmemberEntity staffmemberByStaffId) {
        this.staffmemberByStaffId = staffmemberByStaffId;
    }
}
