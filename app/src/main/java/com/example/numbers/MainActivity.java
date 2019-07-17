package com.example.numbers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int total;
    ArrayList<Integer> i;
    int num;
    TextInputEditText in;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;
    TextView t10;
    TextView totaltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        in=findViewById(R.id.b);
        i=new ArrayList<Integer>();
        Button Add = findViewById(R.id.button);
        Button Clear = findViewById(R.id.button2);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t7=findViewById(R.id.textView7);
        t8=findViewById(R.id.textView8);
        t9=findViewById(R.id.textView9);
        t10=findViewById(R.id.textView10);
        totaltext=findViewById(R.id.textView11);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total+=Integer.parseInt(in.getText().toString());
                i.add(Integer.parseInt(in.getText().toString()));
                num+=1;
                t10.setText(t9.getText());
                t9.setText(t8.getText());
                t8.setText(t7.getText());
                t7.setText(t6.getText());
                t6.setText(t5.getText());
                t5.setText(t4.getText());
                t4.setText(t3.getText());
                t3.setText(t2.getText());
                t2.setText(t1.getText());
                t1.setText(in.getText());
                in.setText("");
                totaltext.setText(Integer.toString(total));
            }
        });


        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total=0;
                i.clear();
                num=0;
                t10.setText("");
                t9.setText("");
                t8.setText("");
                t7.setText("");
                t6.setText("");
                t5.setText("");
                t4.setText("");
                t3.setText("");
                t2.setText("");
                t1.setText("");
                totaltext.setText("0");
            }
        });
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
}
