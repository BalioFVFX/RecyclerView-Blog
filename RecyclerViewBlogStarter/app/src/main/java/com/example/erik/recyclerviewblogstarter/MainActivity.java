package com.example.erik.recyclerviewblogstarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.erik.recyclerviewblogstarter.model.Product;
import com.example.erik.recyclerviewblogstarter.recycler.ProductRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product #1", "Description about product #1"));
        products.add(new Product("Product #2", "Description about product #2"));
        products.add(new Product("Product #3", "Description about product #3"));
        products.add(new Product("Product #4", "Description about product #4"));
        products.add(new Product("Product #5", "Description about product #5"));
        products.add(new Product("Product #6", "Description about product #6"));
        products.add(new Product("Product #7", "Description about product #7"));
        products.add(new Product("Product #8", "Description about product #8"));
        products.add(new Product("Product #9", "Description about product #9"));
        products.add(new Product("Product #10", "Description about product #10"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductRecyclerAdapter(this.getApplicationContext(), products));
    }
}
