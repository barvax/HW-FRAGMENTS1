package com.example.lec8exe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lec8exe.moduls.Animal;
import com.example.lec8exe.moduls.OnTextClickListener;

import java.util.ArrayList;


public class PetAdapter extends RecyclerView.Adapter<PetAdapter.AnimalViewHolder> {
    Context context;
    ArrayList<Animal> animals;
    OnTextClickListener listener;
    public PetAdapter(ArrayList<Animal> animals, OnTextClickListener listener) {
        this.animals = animals;
        this.listener = listener;
    }



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
        holder.tvAnimalType.setText(animal.getType());
        holder.tvAnimalName.setOnClickListener(view -> {

            Animal data = animals.get(position);
            listener.onTextClick(data);
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
        TextView tvAnimalType;
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }

        private void findViews() {

            tvAnimalName = itemView.findViewById(R.id.tv_animal_name);
            tvAnimalType = itemView.findViewById(R.id.tv_animal_type);
        }
    }
}
