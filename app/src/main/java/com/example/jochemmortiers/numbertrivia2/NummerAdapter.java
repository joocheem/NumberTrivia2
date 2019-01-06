package com.example.jochemmortiers.numbertrivia2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NummerAdapter extends RecyclerView.Adapter<NummerAdapter.MyViewHolder> {

    private List<Nummer> list;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nummer;
        public TextView tekst;

        public MyViewHolder(View itemView) {
            super(itemView);

            nummer = itemView.findViewById(R.id.textView_nummer);
            tekst = itemView.findViewById(R.id.textView_text);
        }
    }

    public NummerAdapter(Context mContext, List<Nummer> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public NummerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NummerAdapter.MyViewHolder holder, int position) {
        holder.nummer.setText(list.get(position).getText());       //getNumber().toString());
        holder.tekst.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
