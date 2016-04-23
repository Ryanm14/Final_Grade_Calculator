package me.ryanmiles.finalgradecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.ryanmiles.finalgradecalculator.fragments.SimpleGradeFragment;

public class MainActivity extends AppCompatActivity {
    private SimpleGradeFragment mSimpleGradeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSimpleGradeFragment = new SimpleGradeFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_activity_frame_layout, mSimpleGradeFragment)
                .commit();
    }
}
