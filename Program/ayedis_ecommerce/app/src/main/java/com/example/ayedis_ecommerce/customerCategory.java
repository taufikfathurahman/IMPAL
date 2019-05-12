package com.example.ayedis_ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class customerCategory extends AppCompatActivity implements  View.OnClickListener {

    private ImageView c_computer, c_shoes, c_watch, c_phone, c_clothes, c_sport, c_bag, c_beauty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_category);

        c_computer = findViewById(R.id.c_computer);
        c_shoes = findViewById(R.id.c_shoes);
        c_watch = findViewById(R.id.c_watch);
        c_phone = findViewById(R.id.c_phone);

        c_clothes = findViewById(R.id.c_clothes);
        c_sport = findViewById(R.id.c_sport);
        c_bag = findViewById(R.id.c_bag);
        c_beauty = findViewById(R.id.c_beauty);

        c_computer.setOnClickListener(this);
        c_shoes.setOnClickListener(this);
        c_watch.setOnClickListener(this);
        c_phone.setOnClickListener(this);

        c_clothes.setOnClickListener(this);
        c_sport.setOnClickListener(this);
        c_bag.setOnClickListener(this);
        c_beauty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intentCategory = null;
        if(v.getId() == R.id.c_computer)
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "computer");
        }
        else if (v.getId() == R.id.c_shoes)
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "shoes");
        }
        else if (v.getId() == R.id.c_watch)
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "watch");
        }
        else if (v.getId() == R.id.c_phone)
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "phone");
        }
        else if (v.getId() == R.id.c_clothes)
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "clothes");
        }
        else if (v.getId() == R.id.c_bag)
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "bag");
        }
        else
        {
            intentCategory = new Intent(this, Home.class);
            intentCategory.putExtra("category", "beauty");
        }

        startActivity(intentCategory);
    }
}
