package com.it_skills.ramzi.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Toolbar toolbar;
    String [] Name,Email;
    int[] img_id={R.drawable.bb,R.drawable.dd,R.drawable.ff,R.drawable.gg,R.drawable.nn,R.drawable.rr
            ,R.drawable.ss,R.drawable.uu,R.drawable.yy,R.drawable.zz};
    ArrayList<Contact> contacts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Name=getResources().getStringArray(R.array.name);
        Email=getResources().getStringArray(R.array.email);
        int i=0;
        for (String NAME :Name){
            Contact contact =new Contact(img_id[i],NAME,Email[i]);
            contacts.add(contact);
            i++;
        }
            adapter= new ContactAdapter(contacts,MainActivity.this);
            recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }
}
