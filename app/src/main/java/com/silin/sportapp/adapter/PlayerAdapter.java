package com.silin.sportapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.silin.sportapp.R;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {
    String[] data1,data2;
    int[] images;
    Context context;

    public PlayerAdapter(Context ct, String[] s1, String[] s2, int[] img){
            context = ct;
            data1 = s1;
            data2 = s2;
            images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.player_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1,text2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.player_name);
            text2 = itemView.findViewById(R.id.player_team);
            imageView = itemView.findViewById(R.id.player_img);
        }
    }
}
