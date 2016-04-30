package me.ryanmiles.finalgradecalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class About extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.icon)
                .setDescription("Developed by Ryan Miles \nMaterial Designed Final Exam Grade Calculator \nContact me if you discover bugs/have suggestions!")
                .addItem(versionElement)
                .addEmail("ryanm1114@gmail.com")
                .addPlayStore("me.ryanmiles.finalgradecalculator")
                .addGitHub("Ryanm14")
                .create();

        setContentView(aboutPage);
    }


}
