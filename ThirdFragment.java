package com.example.lec8exe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lec8exe.moduls.Animal;
import com.example.lec8exe.moduls.User;

import java.util.ArrayList;
import java.util.List;


public class ThirdFragment extends Fragment {

    TextView name;
    TextView age;
    TextView animal;


    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        name = view.findViewById(R.id.tv_name_fragment3);
        age = view.findViewById(R.id.tv_age_fragment3);
        animal = view.findViewById(R.id.tv_animal_fragment3);

        if (args != null) {
            User user = (User) args.getSerializable(FirstFragment.USER);
            name.setText(user.getName());
            age.setText(user.getAge());
            animal.setText(user.getAnimal().getName());
        }

        view.findViewById(R.id.btn_toast_third).setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
        });
        view.findViewById(R.id.btn_next_third).setOnClickListener(view1 -> {
            NavController controller = Navigation.findNavController(view);
            controller.navigate(R.id.action_thirdFragment_to_firstFragment);
        });
    }
}