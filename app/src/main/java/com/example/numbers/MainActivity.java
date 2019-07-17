package com.example.numbers;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener{
    int total;
    ArrayList<String> entries;
    TextInputEditText in;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    TextView totaltext;
    MainActivity t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        in=findViewById(R.id.b);
        entries=getArray();
        total=0;
        for(int x=0; x<entries.size(); x++){
            total+=Integer.parseInt(entries.get(x));
        }

        Button Add = findViewById(R.id.button);
        Button Clear = findViewById(R.id.button2);
        t=this;
        recyclerView = findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(this, entries);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.refreshDrawableState();
        totaltext=findViewById(R.id.textView11);
        totaltext.setText(String.valueOf(total));
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!in.getText().toString().equals("")) {
                    total += Integer.parseInt(in.getText().toString());
                    entries.add(in.getText().toString());
                    /*adapter = new RecyclerAdapter(t, entries);
                    adapter.setClickListener(t);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(t));
                    recyclerView.refreshDrawableState();*/
                    adapter.notifyDataSetChanged();
                    in.setText("");
                    totaltext.setText(Integer.toString(total));
                }
            }
        });


        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total=0;
                entries.clear();
                adapter.notifyDataSetChanged();
                totaltext.setText("0");
            }
        });


    }

    @Override
    public void onItemClick(View view, int position)
    {
        total -= Integer.parseInt(entries.get(position));
        //topline.setText("Clicked " + entries.get(position));
        entries.remove(position);
        adapter.notifyDataSetChanged();
        totaltext.setText(Integer.toString(total));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean saveArray() {
        SharedPreferences sp = this.getSharedPreferences("The", Activity.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sp.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(entries);
        mEdit1.putStringSet("list", set);
        return mEdit1.commit();
    }

    public ArrayList<String> getArray() {
        SharedPreferences sp = this.getSharedPreferences("The", Activity.MODE_PRIVATE);

        //NOTE: if shared preference is null, the method return empty Hashset and not null
        Set<String> set = sp.getStringSet("list", new HashSet<String>());



        return new ArrayList<String>(set);
    }


    public void onStop() {
        saveArray();
        super.onStop();
    }
}
