package com.rujirakongsomran.realtimedatabaseonfirebase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rujirakongsomran.realtimedatabaseonfirebase.Model.Calorie;
import com.rujirakongsomran.realtimedatabaseonfirebase.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Calorie> calorieList;

    public MyAdapter(Context context, List<Calorie> calorieList) {
        this.context = context;
        this.calorieList = calorieList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Picasso.get().load(calorieList.get(position).getImg())
                .into(holder.ivImg);
        holder.tvName.setText(calorieList.get(position).getName());
        holder.tvCategory.setText(calorieList.get(position).getCategory());
        holder.tvKcal.setText(String.valueOf(calorieList.get(position).getKcal()));
    }

    @Override
    public int getItemCount() {
        return calorieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImg;
        TextView tvName, tvCategory, tvKcal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImg = (ImageView) itemView.findViewById(R.id.ivImg);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            tvKcal = (TextView) itemView.findViewById(R.id.tvKcal);
        }
    }
}
