package org.training.collections;

import java.util.Objects;

public class Contact {

    private int age;
    private String name;

    public Contact(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return age == contact.age && Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
