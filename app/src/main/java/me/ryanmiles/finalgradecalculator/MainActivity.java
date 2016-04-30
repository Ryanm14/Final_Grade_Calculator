package me.ryanmiles.finalgradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import me.ryanmiles.finalgradecalculator.fragments.SimpleGradeFragment;

public class MainActivity extends AppCompatActivity {
    private SimpleGradeFragment mSimpleGradeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        mSimpleGradeFragment = new SimpleGradeFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_activity_frame_layout, mSimpleGradeFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) {
            launchAboutMe();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }

    private void launchAboutMe() {
        startActivity(new Intent(this, About.class));
    }
}
