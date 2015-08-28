package model;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * Jackson DataBind example, augmented with getter and setters, hashCode and equals
 */
public class MyValue {
    public String name;
    public int age;
    public Instant date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyValue myValue = (MyValue) o;
        return Objects.equals(age, myValue.age) &&
                Objects.equals(name, myValue.name) &&
                Objects.equals(date, myValue.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, date);
    }
}
