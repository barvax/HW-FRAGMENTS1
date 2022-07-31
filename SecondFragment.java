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
import com.example.lec8exe.moduls.User;

import java.util.ArrayList;


public class SecondFragment extends Fragment {

     RecyclerView recyclerView;
     Context context;
    ArrayList<Animal> animals ;

    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    String mParam1;
    String mParam2;
    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String param1, String param2 ) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
        MainActivity main = new MainActivity();
        animals= main.getAnimals();

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
        Bundle args = getArguments();
        if(args !=null){
            User user =(User) args.getSerializable(FirstFragment.USER);

            Toast.makeText(getContext(), "MY NAME IS:"+ user.getName() , Toast.LENGTH_SHORT).show();
        }




        view.findViewById(R.id.btn_next_second).setOnClickListener(view1 -> {


            NavController controller= Navigation.findNavController(view);
            controller.navigate(R.id.action_secondFragment_to_thirdFragment,args);
        });
    }

    public  void setRecycleView(View view){
        recyclerView=view.findViewById(R.id.recycle_animal);
        PetAdapter petAdapter = new PetAdapter(animals);
        recyclerView.setAdapter(petAdapter);
        context = getParentFragment().getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


}