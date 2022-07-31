package com.example.lec8exe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lec8exe.moduls.Animal;

import java.util.ArrayList;


public class PetAdapter extends RecyclerView.Adapter<PetAdapter.AnimalViewHolder> {
    Context context;
    ArrayList<Animal> animals= new ArrayList();

    public PetAdapter(ArrayList<Animal> animals) {
        this.animals = animals;
    }


    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_row,parent,false);
        AnimalViewHolder vh  = new AnimalViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.tvAnimalName.setText(animal.getName());
        holder.tvAnimalName.setOnClickListener(view -> {

            ThirdFragment.newInstance("test1","test2");
            Toast.makeText(context, ThirdFragment.ARG_PARAM1, Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(context ,MainActivity.class);
////            intent.putExtra("ANIMAL" , holder.tvAnimalName.toString());
////            Toast.makeText(context, holder.tvAnimalName.getText().toString(), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        if (animals==null){
           return 0;
        }
        return animals.size();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder{
        TextView tvAnimalName;
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }

        private void findViews() {
            tvAnimalName = itemView.findViewById(R.id.tv_animal_row);
        }
    }
}
