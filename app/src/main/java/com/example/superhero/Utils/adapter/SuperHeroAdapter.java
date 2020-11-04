package com.example.superhero.Utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superhero.R;
import com.example.superhero.model.SuperHero;

import java.util.ArrayList;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<SuperHero> arrayList;

    public SuperHeroAdapter(Context context, ArrayList<SuperHero> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SuperHeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.row_layout_dashboard, parent, false);
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroAdapter.ViewHolder holder, int position) {
        holder.mItemDivider.setVisibility(position+1 == getItemCount() ? View.GONE : View.VISIBLE);
        holder.mItemCanFly.setVisibility(arrayList.get(position).isCanFly() ? View.VISIBLE : View.GONE);
        holder.mItemName.setText(arrayList.get(position).getName());
        holder.mItemPower.setText(String.valueOf(arrayList.get(position).getPower()));
        holder.mItemStamina.setText(String.valueOf(arrayList.get(position).getStamina()));
        holder.mItemCharisma.setText(String.valueOf(arrayList.get(position).getCharisma()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mItemName,mItemPower,mItemStamina,mItemCharisma;
        LinearLayout mItemDivider;
        ImageView mItemCanFly;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.dashboard_list_item_name);
            mItemPower = itemView.findViewById(R.id.dashboard_list_item_power);
            mItemStamina = itemView.findViewById(R.id.dashboard_list_item_stamina);
            mItemCharisma = itemView.findViewById(R.id.dashboard_list_item_charisma);
            mItemCanFly = itemView.findViewById(R.id.dashboard_list_item_can_fly);
            mItemDivider = itemView.findViewById(R.id.dashboard_list_item_divider);
        }
    }
}
