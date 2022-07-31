package com.example.lec8exe.moduls;

import java.util.ArrayList;

public class GetData {
    String[] animalType={"lion","dog","cat","dolphin","snake","fish","goat","tiger","shark","ant"};
    String[] animalName={"aa","bb","cc","dd","ee","ff","gg","hh","ii","gg"};
    ArrayList<Animal> animals;

    public ArrayList<Animal> getAnimals(){
        animals=new ArrayList<>();
        for (int i = 0; i < animalType.length; i++) {
            Animal animal = new Animal(animalType[i],animalName[i]);
            animals.add(animal);
        }
        return animals;
    }
}
