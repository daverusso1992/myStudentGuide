/*
 * MainActivity.java
 *
 * Copyright (c) 2018 myStudentGuide App
 */

// Package
package com.magistrale.unisa.mystudentguide;

// External Packages
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

// MainActivity Class
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHelper.initialize(this);

        //hideNavigationBar();
        setContentView(R.layout.activity_main);

        //GENERATE LATERAL MENU -----------------------------------
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //------------------------------------------------------------

        //SAVE FRAGMENT CONTENT IF PAUSE THE APPLICATION
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_main);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            //
            //CLICK ON MENU HOME BUTTON
            //
            case R.id.nav_main:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            //
            //CLICK ON MENU OFFER BUTTON
            //
            case R.id.nav_offer:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OfferFragment()).commit();
                break;

            //
            //CLICK ON MENU CURRICULA BUTTON
            //
            case R.id.nav_curriculum:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CurriculaFragment()).commit();
                break;

            //
            //CLICK ON MENU CONTACT BUTTON
            //
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;

            //
            //CLICK ON MENU CREATE OR MODIFY BUTTON
            //
            case R.id.nav_create_guide:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CreateFragment()).commit();
                break;

            //
            //CLICK ON SHOW BUTTON
            //
            case R.id.nav_check_guide:

                //
                //OPEN THE PERSOLANIZED STUDENT GUIDE WITH A CLIENT PDF READER APP
                //
                File pdfFile = new File(Environment.getExternalStorageDirectory() + "/myGuide.pdf");//File path
                try {
                    if (pdfFile.exists()) //Checking if the file exists or not
                    {
                        Uri path = Uri.parse("content://" + pdfFile );
                        Intent objIntent = new Intent(Intent.ACTION_VIEW);
                        objIntent.setDataAndType(path, "application/pdf");
                        objIntent.setFlags(Intent. FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(objIntent);//Starting the pdf viewer
                    } else {
                        Toast.makeText(this, "NO FILE! ", Toast.LENGTH_SHORT).show();
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this,
                            "No Viewer Application Found", Toast.LENGTH_SHORT)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //
            //CLICK ON SHOW BUTTON
            //
            case R.id.nav_other:

                //
                //OPEN THE PERSOLANIZED STUDENT GUIDE WITH A CLIENT PDF READER APP
                //
                File pdfFile2 = new File(Environment.getExternalStorageDirectory() + "/myGuide.pdf");//File path
                try {
                    if (pdfFile2.exists()) //Checking if the file exists or not
                    {
                        Uri path = Uri.parse("content://" + pdfFile2);
                        Intent objIntent = new Intent(Intent.ACTION_VIEW);
                        objIntent.setDataAndType(path, "application/pdf");
                        objIntent.setFlags(Intent. FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(objIntent);//Starting the pdf viewer
                    } else {
                        Toast.makeText(this, "NO FILE! ", Toast.LENGTH_SHORT).show();
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this,
                            "No Viewer Application Found", Toast.LENGTH_SHORT)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            //
            //CLICK ON SHARE BUTTON
            //
            case R.id.nav_share:
                break;

            //
            //CLICK ON PRINT BROCHURE BUTTON
            //
            case R.id.nav_print:
                Toast.makeText(this, "Hai premuto Stampa Brochure", Toast.LENGTH_SHORT).show();
                break;

            //
            //CLICK ON WEB SITE BUTTON
            //
            case R.id.nav_website:
                //OPEN A WEB PAGE TO OTHER INFORMATIONS
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://corsi.unisa.it/unisa-rescue-page/dettaglio/url/L2luZm9ybWF0aWNhL25ld3M%3D/id/1542/module/475/row/3255"));
                startActivity(intent);
                break;

            //
            //CLICK ON APP INFORMATION BUTTON
            //
            case R.id.nav_infoApp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InfoFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //
    // MAKE THE APP FULL SCREEN
    //
    public void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |

                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                );
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
