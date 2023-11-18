package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private final LayoutInflater mInflater;
    private List<FoodModel> foodList;
    private Context context;
    final FoodAdapter.OnItemClickListener listener;

    public FoodAdapter(List<FoodModel> foodList, Context context, FoodAdapter.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.foodList = foodList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.food_item, null);
        return new FoodAdapter.FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bindData(foodList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void setItem(List<FoodModel> item) {
        foodList = item;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvRating, tvPrice;
        ImageView ivImage;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvRating);
            ivImage = itemView.findViewById(R.id.ivImage);
        }

        public void bindData(final FoodModel item) {
//            ivImage.setImageResource(item.getImage());
            tvName.setText(item.getName());
            tvPrice.setText(item.getPrice());
            tvRating.setText(item.getRating());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(FoodModel item);
    }
}
