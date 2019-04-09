package com.example.ayedis_ecommerce;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Category extends AppCompatActivity implements View.OnClickListener
{

    private ImageView c_computer, c_shoes, c_watch, c_phone, c_clothes, c_sport, c_bag, c_beauty;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        c_computer = findViewById(R.id.category_computer);
        c_shoes = findViewById(R.id.category_shoes);
        c_watch = findViewById(R.id.category_watch);
        c_phone = findViewById(R.id.category_phone);

        c_clothes = findViewById(R.id.category_clothes);
        c_sport = findViewById(R.id.category_sport);
        c_bag = findViewById(R.id.category_bag);
        c_beauty = findViewById(R.id.category_beauty);

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
        if(v.getId() == R.id.category_computer)
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "computer");
        }
        else if (v.getId() == R.id.category_shoes)
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "shoes");
        }
        else if (v.getId() == R.id.category_watch)
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "watch");
        }
        else if (v.getId() == R.id.category_phone)
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "phone");
        }
        else if (v.getId() == R.id.category_clothes)
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "clothes");
        }
        else if (v.getId() == R.id.category_bag)
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "bag");
        }
        else
        {
            intentCategory = new Intent(this, AddProduct.class);
            intentCategory.putExtra("category", "beauty");
        }

        startActivity(intentCategory);
    }
}
