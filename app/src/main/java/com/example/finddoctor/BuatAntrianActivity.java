package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BuatAntrianActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Antrian> list;
    Button antrianbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_antrian);

        List<String> myList = Arrays.asList("Senin, 6 Juni 2022", "Selasa, 7 Juni 2022 ", "Rabu 8 Juni 2022", "Kamis 9 Juni 2022", "Jumat 10 Juni 2022");
        Random r = new Random();
        int randomitem = r.nextInt(myList.size());
        int upperbound = 25;
        int num = r.nextInt(upperbound);
        String waktu = myList.get(randomitem);
        String dokter = getIntent().getStringExtra("dokterINTENT");
        String nomor = ("A0"+num);



        //--> Creating a list
        list = new ArrayList<>();
        list.add(new Antrian(nomor, dokter, waktu));





        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterAntrian adapter = new AdapterAntrian(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.OnRecyclerViewClickListener(new AdapterAntrian.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

                new AlertDialog.Builder(BuatAntrianActivity.this)
                        .setIcon(R.drawable.deletealert)
                        .setTitle("Are You Sure ?")
                        .setMessage("Do you want to delete this record")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


            }
        });



    }
}