package com.example.retrofitpractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class adapterPokemon extends RecyclerView.Adapter<adapterPokemon.ViewHolder> {

    private ArrayList<Post> posts;
    private Context context;

    LayoutInflater inflater;
    private View.OnClickListener itemlisten;

    public adapterPokemon(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        itemlisten = itemClickListener;
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
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Post clickedDataItem = posts.get(pos);
                        Intent intent = new Intent(context, Pkemondesc.class);
                        intent.putExtra("name", posts.get(pos).getName());
                        intent.putExtra("image", posts.get(pos).getImage());
                        intent.putExtra("type", posts.get(pos).getType());
                        intent.putExtra("ability", posts.get(pos).getAbility());
                        intent.putExtra("height", posts.get(pos).getHeight());
                        intent.putExtra("weight", posts.get(pos).getWeight());
                        intent.putExtra("description", posts.get(pos).getDescription());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(view.getContext(), "You clicked" + clickedDataItem.getName(),
                                Toast.LENGTH_LONG).show();

                    }
                }
            });

        }
    }
}
