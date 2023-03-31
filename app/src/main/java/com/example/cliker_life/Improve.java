package com.example.cliker_life;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Improve extends AppCompatActivity {
    Button upgradeee;
        Button city_price;
        Button bckl;
        TextView asshop;
        TextView up111;
        TextView up112;
        ImageView foni;
        ImageView fonit;
        ImageView fonita;

    public static int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        upgradeee = (Button) findViewById(R.id.upgradeee);
        city_price = (Button) findViewById(R.id.city_price);
        upgradeee.setText("Цена: " + price + "$");
        upgradeee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= price) {
                    MainActivity.money += 10;
                    MainActivity.coutmoney -= price;
                    price += 30;
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "$");
                    upgradeee.setText("Цена:" + price + "$");
                    new Saved().save();
                }
            }
        });
        city_price.setText(MainActivity.nalog);
        city_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.coutmoney >= MainActivity.nalog) {
                    MainActivity.coutmoney -= MainActivity.nalog;
                    MainActivity.nalog = 0;
                    MainActivity.nalogi.setText("Налог\n" + MainActivity.nalog);
                    city_price.setText("Оплатить налоги " + MainActivity.nalog);
                    MainActivity.textmoney.setText(MainActivity.coutmoney + "$");
                    new Saved().save();
                }
            }
        });

        bckl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Improve.this, MainActivity.class);
                startActivity(intent);
            }
        });

            }
        }
