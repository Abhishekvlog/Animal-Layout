package com.example.animals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private ArrayList<Animal> animalList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buildRecyclerViewData();
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(animalAdapter);
    }

    private void buildRecyclerViewData() {
        animalList = new ArrayList<>();
       for(int i=0;i<7;i++){
           Animal animal = new Animal("Type - Dog","Sound - Bow Bow",R.drawable.dog);
           Animal animal1 = new Animal("Type - Cat","Sound - Meow Meow",R.drawable.cat);
           Animal animal2= new Animal("Type - Duck","Sound - Quack Quack",R.drawable.quack);

           animalList.add(animal);
           animalList.add(animal1);
           animalList.add(animal2);

       }


    }


    @Override
    public void onItemClicked(int position,Animal animal) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is the Data")
                .setMessage(animal.getType()+"\n"
                        +animal.getSound()

                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();    }
}