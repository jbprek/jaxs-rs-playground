package model;

import java.time.Instant;
import java.util.Date;

/**
 * Jackson DataBind example
 */
public class MyValue {
    public String name;
    public int age;
    public Instant date;
    // NOTE: if using getters/setters, can keep fields `protected` or `private`


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
