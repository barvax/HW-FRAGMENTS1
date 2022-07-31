package com.example.lec8exe;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lec8exe.moduls.Animal;
import com.example.lec8exe.moduls.OnTextClickListener;
import com.example.lec8exe.moduls.User;

import java.util.ArrayList;


public class SecondFragment extends Fragment implements OnTextClickListener {

    RecyclerView recyclerView;
    Context context;
    ArrayList<Animal> animals;
    Animal currentAnimal;
    Bundle args;

    public static final String UPDATE_USER = "param1";

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity main = new MainActivity();
        animals = main.getAnimals();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecycleView(view);
        recyclerView.setAdapter(new PetAdapter(animals, this));

        sendData(view);

    }

    private void sendData(View view) {

        view.findViewById(R.id.btn_next_second).setOnClickListener(view1 -> {
            if(args!=null){
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_secondFragment_to_thirdFragment, args);
            }else{
                Toast.makeText(context, "PICK AN ANIMAL", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void setRecycleView(View view) {
        recyclerView = view.findViewById(R.id.recycle_animal);
        PetAdapter petAdapter = new PetAdapter(animals, this);
        recyclerView.setAdapter(petAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    @Override
    public void onTextClick(Animal animal) {
        Toast.makeText(getActivity(), "you choose: "+ animal.getName()+" press next", Toast.LENGTH_SHORT).show();
        currentAnimal = animal;
        args = getArguments();
        User user = (User) args.getSerializable(FirstFragment.USER);
        User updateUser = new User(user.getName(), user.getAge(), currentAnimal);
        args.putSerializable(UPDATE_USER, updateUser);
    }
}