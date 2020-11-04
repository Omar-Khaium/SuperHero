package com.example.superhero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.superhero.Utils.Database;
import com.example.superhero.model.SuperHero;

public class AddNewHeroActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TextView mPowerValue, mStaminaValue, mCharismaValue;
    AppCompatSeekBar mPowerBar, mStaminaBar, mCharismaBar;
    EditText mName, mCategory;
    AppCompatCheckBox mCanFly;
    Button mSubmit;

    Database database = new Database();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hero);

        mToolbar = findViewById(R.id.toolbar);
        mName = findViewById(R.id.input_hero_name);
        mCategory = findViewById(R.id.input_hero_category);
        mPowerValue = findViewById(R.id.input_hero_power_value);
        mPowerBar = findViewById(R.id.input_hero_power);
        mCharismaValue = findViewById(R.id.input_hero_charisma_value);
        mCharismaBar = findViewById(R.id.input_hero_charisma);
        mStaminaValue = findViewById(R.id.input_hero_stamina_value);
        mStaminaBar = findViewById(R.id.input_hero_stamina);
        mCanFly = findViewById(R.id.input_hero_can_fly);
        mSubmit = findViewById(R.id.input_save_hero);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mPowerBar.setMax(100);
        mStaminaBar.setMax(100);
        mCharismaBar.setMax(100);

        mPowerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mPowerValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mStaminaBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mStaminaValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mCharismaBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCharismaValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String category = mCategory.getText().toString();
                int power = mPowerBar.getProgress();
                int stamina = mStaminaBar.getProgress();
                int charisma = mCharismaBar.getProgress();
                boolean canFly = mCanFly.isChecked();
                SuperHero hero = new SuperHero(0, name, category, power, stamina, charisma, canFly);

                database.addData(hero);
                finish();
            }
        });
    }
}