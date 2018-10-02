/*
 * HomeFragment.java
 *
 * Copyright (c) 2018 myStudentGuide App
 */

// Package
package com.magistrale.unisa.mystudentguide;

// External Packages
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

// HomeFragment Class
public class HomeFragment extends Fragment {

    View v;

    // BUTTON ON HOMEPAGE
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home, container, false);

        btn1 = v.findViewById(R.id.buttonOffer);
        btn2 = v.findViewById(R.id.buttonCurricula);
        btn3 = v.findViewById(R.id.buttonContacts);
        btn4 = v.findViewById(R.id.buttonCreate);
        btn5 = v.findViewById(R.id.buttonShare);
        btn6 = v.findViewById(R.id.buttonBrochure);

        //OFFER BUTTON CONTROLLER
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // FRAGMENT ON SCREEN TO SHOW OfferFragment
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, new OfferFragment());
                ft.commit();
                }
        });

        //CURRICULA BUTTON CONTROLLER
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // FRAGMENT ON SCREEN TO SHOW CurriculaFragment
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, new CurriculaFragment());
                ft.commit();
            }
        });

        //CONTACT BUTTON CONTROLLER
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // FRAGMENT ON SCREEN TO SHOW ContactFragment
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, new ContactFragment());
                ft.commit();
            }
        });

        //CREATE GUIDE BUTTON CONTROLLER
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // FRAGMENT ON SCREEN TO SHOW CreateFragment
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, new CreateFragment());
                ft.commit();
            }
        });

        //VISUALIZE GUIDE BUTTON CONTROLLER
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        Toast.makeText(getContext(), "NO FILE! ", Toast.LENGTH_SHORT).show();
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getContext(),
                            "No Viewer Application Found", Toast.LENGTH_SHORT)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //BROCHURE BUTTON CONTROLLER
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        return v;
    }

}
