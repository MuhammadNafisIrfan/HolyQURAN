package com.example.holyquran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holyquran.R;
import com.example.holyquran.modal.ModalAyatHome;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    View view;
    ArrayList<ModalAyatHome> modalAyatHomes;

    public AdapterHome(Context context, ArrayList<ModalAyatHome> modalAyatHomes) {
        this.context = context;
        this.modalAyatHomes = modalAyatHomes;
    }



    class MyAdapterHome extends RecyclerView.ViewHolder {

        TextView nomor, name, asma, arti;

        public MyAdapterHome(@NonNull View itemView) {

            super(itemView);

            nomor = itemView.findViewById(R.id.nomor);
            name = itemView.findViewById(R.id.name);
            asma = itemView.findViewById(R.id.asma);
            arti = itemView.findViewById(R.id.arti);

        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home, parent, false);


        return new MyAdapterHome(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        ((MyAdapterHome) holder).nomor.setText(modalAyatHomes.get(i).getNomor());
        ((MyAdapterHome) holder).name.setText(modalAyatHomes.get(i).getName());
        ((MyAdapterHome) holder).asma.setText(modalAyatHomes.get(i).getAsma());
        ((MyAdapterHome) holder).arti.setText(modalAyatHomes.get(i).getArti());


    }

    @Override
    public int getItemCount() {
        return modalAyatHomes.size();
    }
}
