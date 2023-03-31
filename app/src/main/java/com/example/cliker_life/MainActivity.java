package com.example.cliker_life;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static public int coutmoney = 0;
    static public int money = 1;
    static public int nalog = 0;
    Button click, improve;
    public ProgressBar levil;
    static public TextView textmoney, nalogi;
    SharedPreferences preferences;

    public static int getNalog() {
        return nalog;
    }

    public static void setNalog(int nalog) {
        MainActivity.nalog = nalog;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button)findViewById(R.id.click);
        improve = (Button)findViewById(R.id.improve);
        textmoney = (TextView)findViewById(R.id.money);
        nalogi = (TextView)findViewById(R.id.nalogi);
        Saved.init(getApplicationContext());
        new Saved().load_save();
        Click();
    }
    void Click(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coutmoney += money;
                textmoney.setText(coutmoney + "$");
                setNalog(getNalog() + 1);
                nalogi.setText("Налог\n" + getNalog() + "$");
                ProgressBar progressBar = findViewById(R.id.levil);
                progressBar.setProgress(coutmoney);
                new Saved().save();
            }
        });
        improve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Improve.class);
                startActivity(intent);
            }
        });

    }

}
