package com.example.thecatsapp.Views;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.thecatsapp.Models.Cat;
import com.example.thecatsapp.R;

import java.util.List;

public class AdapterCat extends RecyclerView.Adapter<AdapterCat.CatViewHolder> {
    private List<Cat> cats;
    private Context context;

    public AdapterCat(Context context) {
        this.context = context;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_card, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = cats.get(position);
        holder.breedNameCat.setText(cat.getBreedNameCat());
        holder.origin.setText(cat.getOrigin());
        holder.affectionLevel.setText(String.valueOf(cat.getAffectionLevel()));
        holder.intelligence.setText(String.valueOf(cat.getIntelligence()));
        Glide.with(context).load(cat.getImageUrl()).into(holder.imageUrl);
    }

    @Override
    public int getItemCount() {
        return cats != null ? cats.size() : 0;
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {
        private TextView breedNameCat;
        private TextView origin;
        private TextView affectionLevel;
        private TextView intelligence;
        private ImageView imageUrl;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            breedNameCat = itemView.findViewById(R.id.breed_name_cat);
            origin = itemView.findViewById(R.id.origin);
            intelligence = itemView.findViewById(R.id.intelligence);
            imageUrl = itemView.findViewById(R.id.image_url);
        }
    }
}

