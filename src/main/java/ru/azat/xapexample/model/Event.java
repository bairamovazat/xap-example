package ru.azat.xapexample.model;

import java.util.UUID;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

@SpaceClass
public class Event {

    private UUID id;

    private String value;

    public Event() {
    }

    public Event(UUID id, String value) {
        this.id = id;
        this.value = value;
    }

    @SpaceRouting
    @SpaceId(autoGenerate = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
