package com.crud;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewProductAdapter extends
RecyclerView.Adapter<RecyclerViewProductAdapter.ViewHolder> {
    private ArrayList<ProductEntity> productEntityArrayList;
    private Context context;
    private OnLongItemCustomListener onLongItemCustomListener;


    RecyclerViewProductAdapter(Context context, ArrayList<ProductEntity> productEntityArrayList) {
        this.productEntityArrayList = productEntityArrayList;
        this.context = context;
    }

    public interface OnLongItemCustomListener {
        void ItemLongClicked(View v, int position);
    }

    public void setOnLongItemCustomListener(OnLongItemCustomListener onLongItemClickListener) {
        onLongItemCustomListener = onLongItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_product_item, null, false);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new RecyclerViewProductAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewProductAdapter.ViewHolder holder, final int position) {
        holder.setValues(productEntityArrayList.get(position));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (onLongItemCustomListener != null) {
                onLongItemCustomListener.ItemLongClicked(v, position);
            }
            return true;
        }
    });
}

    @Override
    public int getItemCount() {
        return productEntityArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView textViewProductName, textViewProductPrice, textViewProductDescription;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Referencias
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layoutProductItem);
            textViewProductName = (TextView) itemView.findViewById(R.id.textViewProductName);
            textViewProductPrice = (TextView) itemView.findViewById(R.id.textViewProductPrice);
            textViewProductDescription = (TextView) itemView.findViewById(R.id.textViewProductDescription);

            // Eventos
            linearLayout.setOnCreateContextMenuListener(this);
        }

        public void setValues(ProductEntity productEntity) {
            textViewProductName.setText(productEntity.getName());
            textViewProductPrice.setText("" + productEntity.getPrice());
            textViewProductDescription.setText(productEntity.getDescription());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // Se sobrescribe en ProductListActivity
        }
    }
}



