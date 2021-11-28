package com.danwalkercs.notificationsevents.domain.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class EmailNotification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String type;
    private String to;
    private String cc;
    private String subject;
    private String body;
    private Date sent_dt;

    EmailNotification() {

    }

    EmailNotification(String type, String to, String cc) {
        this.type = type;
        this.to = to;
        this.cc = cc;
    }

    public Date getSent_dt() {
        return sent_dt;
    }

    public void setSent_dt(Date sent_dt) {
        this.sent_dt = sent_dt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        // literally the same object
        if (this == o)
            return true;

        // not even of the same type
        if(!(o instanceof EmailNotification))
            return false;

        // so if they're not literally the same object, and they're of the same type - compare their fields
        EmailNotification emailNotification = (EmailNotification) o;
        return Objects.equals(this.id, emailNotification.id) &&
                Objects.equals(this.type, emailNotification.type) &&
                Objects.equals(this.to, emailNotification.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.type, this.to);
    }

    @Override
    public String toString() {
        return "EmailNotification{" + "id=" + this.id + ", type='" + this.type + '\'' + "to=" + this.to + '\'' + '}';
    }
}
