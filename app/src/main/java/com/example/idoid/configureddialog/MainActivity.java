package com.example.idoid.configureddialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder bul;
    String[]colors={"red","green","blue"};
    int[]color;
    LinearLayout li;
    Intent t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=(LinearLayout)findViewById(R.id.linear);
    }
    public void onclick1(View view){
        color=new int[]{0,0,0};
        bul=new AlertDialog.Builder(this);
        bul.setTitle("3 colors- choose one");
        bul.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i]=255;
                li.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        bul.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ar=bul.create();
        ar.show();

    }
    public void onclick2(View view){
        color=new int[]{0,0,0};
        bul=new AlertDialog.Builder(this);
        bul.setTitle("3 colors- multi choise");
        bul.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean check) {
                if(check) color[i]=255;
                else if(color[i]==255)color[i]=0;
                li.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });
        bul.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              li.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        bul.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                li.setBackgroundColor(Color.WHITE);
                dialogInterface.cancel();
            }
        });
        AlertDialog ar=bul.create();
        ar.show();


    }
    public void onclick3(View view){
        li.setBackgroundColor(Color.WHITE);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("credits")) {
            t=new Intent(this,Main2Activity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }
}

