package com.example.retrofitpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class adapterPokemon extends RecyclerView.Adapter<adapterPokemon.ViewHolder> {

    private ArrayList<Post> posts;
    private Context context;

    public adapterPokemon(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).asBitmap().load(posts.get(position).getImage()).into(holder.ivPokeImage);
        holder.tvPokeName.setText(posts.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPokeImage;
        TextView tvPokeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokeImage = (ImageView) itemView.findViewById(R.id.ivPokeImage);
            tvPokeName = (TextView) itemView.findViewById(R.id.tvPokeName);

            itemView.setTag(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}
