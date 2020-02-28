package ru.azat.xapexample.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

@SpaceClass
public class Event {

    private Long id;

    private String value;

    public Event() {

    }

    public Event(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @SpaceId(autoGenerate = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
