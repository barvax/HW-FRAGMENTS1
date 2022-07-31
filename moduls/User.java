package com.example.lec8exe.moduls;

import java.io.Serializable;

public class User implements Serializable {
    private String  name;
    private String  age;
    private Animal animal;

    public User(String name, String age, Animal animal) {
        this.name = name;
        this.age = age;
        this.animal = animal;
    }
    public User(String name, String age) {
        this.name = name;
        this.age = age;

    }
    public User() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
