package com.example.superhero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.superhero.Utils.Database;
import com.example.superhero.Utils.adapter.SuperHeroAdapter;

public class DashboardActivity extends AppCompatActivity {

    ImageButton mAddSuperHero;
    Spinner mCategorySpinner;
    RecyclerView mSuperHeroList;
    SuperHeroAdapter mSuperHeroAdapter;
    Database database = new Database();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAddSuperHero = findViewById(R.id.dashboard_superhero_add_new);
        mCategorySpinner = findViewById(R.id.dashboard_superhero_category);
        mSuperHeroList = findViewById(R.id.dashboard_superhero_list);
        mSuperHeroList.setLayoutManager(new LinearLayoutManager(this));

        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, database.getCategories());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategorySpinner.setAdapter(spinnerAdapter);

        mSuperHeroAdapter = new SuperHeroAdapter(this, database.getData(mCategorySpinner.getSelectedItem().toString()));
        mSuperHeroList.setAdapter(mSuperHeroAdapter);

        mCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSuperHeroAdapter = new SuperHeroAdapter(DashboardActivity.this, database.getData(mCategorySpinner.getSelectedItem().toString()));
                mSuperHeroList.setAdapter(mSuperHeroAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mAddSuperHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, AddNewHeroActivity.class));
            }
        });

    }
}