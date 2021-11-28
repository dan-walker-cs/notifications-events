package com.danwalkercs.notificationsevents.domain.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class EmailNotification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String type;
    private String to;

    EmailNotification() {

    }

    EmailNotification(String type, String to) {
        this.type = type;
        this.to = to;
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
