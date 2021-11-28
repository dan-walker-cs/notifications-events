package com.danwalkercs.notificationsevents.domain.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Information {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String content;

    Information() {

    }

    Information(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        // literally the same object
        if (this == o)
            return true;

        // not even of the same type
        if(!(o instanceof Information))
            return false;

        // so if they're not literally the same object, and they're of the same type - compare their fields
        Information information = (Information) o;
        return Objects.equals(this.id, information.id) &&
                Objects.equals(this.content, information.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.content);
    }

    @Override
    public String toString() {
        return "EmailNotification{" + "id=" + this.id + ", content='" + this.content + '\'' + '}';
    }
}
