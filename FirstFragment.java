package com.example.lec8exe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lec8exe.moduls.User;


public class FirstFragment extends Fragment {


    public static final String USER = "param1";

    public FirstFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types of parameters

    EditText etName;
    EditText etAge;
    String name;
    String age;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void findViews(View view) {
        etName = view.findViewById(R.id.et_name_first);
        etAge = view.findViewById(R.id.et_age_first);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        findViews(container);
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.et_name_first);
        etAge = view.findViewById(R.id.et_age_first);
        view.findViewById(R.id.btn_next_first).setOnClickListener(view1 -> {
            name = etName.getText().toString();
            age = etAge.getText().toString();
            User user = new User(name, age);

            NavController controller = Navigation.findNavController(view);
            Bundle bundle = new Bundle();
            bundle.putSerializable(USER, user);

            controller.navigate(R.id.action_firstFragment_to_secondFragment, bundle);
        });
    }
}