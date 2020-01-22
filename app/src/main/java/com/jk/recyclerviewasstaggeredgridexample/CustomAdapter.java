package com.jk.recyclerviewasstaggeredgridexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList <String> personNames;
    ArrayList <Integer> personImages;

    public CustomAdapter(Context context, ArrayList<String> personNames, ArrayList<Integer> personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the item Layout
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent,false);
        // set the view's size, margins, padding's and layout parameters
        MyViewHolder vh=new MyViewHolder(v);// pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
        //set the data in items
        holder.name.setText(personNames.get(position));
        holder.image.setImageResource(personImages.get(position));

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position));//put image data in intent
                context.startActivity(intent);//start intent
            }
        });


    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //init the item view's
        TextView name;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //get the reference of item view's
            name=itemView.findViewById(R.id.name);
            image=itemView.findViewById(R.id.image);
        }
    }
}
