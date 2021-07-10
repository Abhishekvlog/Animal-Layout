package com.example.animals;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvType;
    private TextView mtvSound;
    private ImageView mtvImage;
    private ItemClickListener itemClickListener;
    private RelativeLayout relativeLayout;
    public AnimalViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
       this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mtvType = itemView.findViewById(R.id.type);
        mtvSound = itemView.findViewById(R.id.sound);
        mtvImage = itemView.findViewById(R.id.Image);
        relativeLayout = itemView.findViewById(R.id.relativelayout);

    }
    public void setData(Animal animal){
        mtvType.setText(animal.getType());
        mtvSound.setText(animal.getSound());
        mtvImage.setImageResource(animal.getImage());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(),animal);
            }
        });
    }
}
