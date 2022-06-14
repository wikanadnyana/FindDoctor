package com.example.finddoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterAntrian extends RecyclerView.Adapter<AdapterAntrian.MyViewHolder> {
    private final ArrayList <Antrian> myList;

    private OnRecyclerViewClickListener listener;

    public interface OnRecyclerViewClickListener{
        void OnItemClick(int position);
    }

    public void OnRecyclerViewClickListener (OnRecyclerViewClickListener listener){
        this.listener = listener;
    }

    //--> Constructor
    public AdapterAntrian(ArrayList<Antrian> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_antrian,parent,false);
        return new MyViewHolder(view, listener);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       Antrian item = myList.get(position);
        holder.textView_nomor.setText(item.getNomor());
        holder.textView_dokter.setText(item.getDokter());
        holder.textView_waktu.setText(item.getWaktu());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    //--> My ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_nomor;
        public TextView textView_dokter;
        public TextView textView_waktu;

        //--> Constructor
        public MyViewHolder(@NonNull View itemView, OnRecyclerViewClickListener listener) {
            super(itemView);

            textView_nomor = itemView.findViewById(R.id.nomor);
            textView_dokter = itemView.findViewById(R.id.dokter);
            textView_waktu = itemView.findViewById(R.id.waktu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null && getAbsoluteAdapterPosition()!=RecyclerView.NO_POSITION){
                        listener.OnItemClick(getAbsoluteAdapterPosition());
                    }
                }
            });

        }

    }

}