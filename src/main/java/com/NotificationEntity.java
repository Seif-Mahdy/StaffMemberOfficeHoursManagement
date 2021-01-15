package com;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "notifications", schema = "officehoursmangementsystem")
public class NotificationEntity implements java.lang.Comparable<NotificationEntity> {
    private Integer notificationId;
    private String notificationContent;
    private String userId;
    private Timestamp notificationDate;
    private String notificationSubject;

    @Id
    @Column(name = "NotificationId", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    @Basic
    @Column(name = "NotificationContent", nullable = false, length = 100)
    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    @Basic
    @Column(name = "userId", nullable = true, length = 8)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "NotificationDate", nullable = false)
    public Timestamp getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Timestamp notificationDate) {
        this.notificationDate = notificationDate;
    }

    @Basic
    @Column(name = "NotificationSubject", nullable = false, length = 100)
    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return notificationId.equals(that.notificationId) && Objects.equals(notificationContent, that.notificationContent) && Objects.equals(userId, that.userId) && Objects.equals(notificationDate, that.notificationDate) && Objects.equals(notificationSubject, that.notificationSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, notificationContent, userId, notificationDate, notificationSubject);
    }


    @Override
    public int compareTo(NotificationEntity o) {
        return this.notificationId.compareTo(o.getNotificationId());
    }
}
