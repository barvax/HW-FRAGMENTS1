package com.example.lec8exe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lec8exe.moduls.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] animalType={"a","b","c","d","e","f","g","h","i","g"};
    String[] animalName={"aa","bb","cc","dd","ee","ff","gg","hh","ii","gg"};
    ArrayList<Animal> animals;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public ArrayList<Animal> getAnimals(){
        animals=new ArrayList<>();
        for (int i = 0; i < animalType.length; i++) {
            Animal animal = new Animal(animalType[i],animalName[i]);
            animals.add(animal);
        }
        return animals;
    }
}