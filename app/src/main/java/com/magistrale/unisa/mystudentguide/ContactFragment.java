/*
 * ContactFragment.java
 *
 * Copyright (c) 2018 myStudentGuide App
 */

// Package
package com.magistrale.unisa.mystudentguide;

// External Packages
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

// ContactFragment Class
public class ContactFragment extends Fragment {

    View v;
    // PROF. LAYOUT
    LinearLayout negro;
    LinearLayout deLucia;
    LinearLayout ferrucci;
    LinearLayout deSantis;
    LinearLayout polese;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_contact, container, false);

        negro = v.findViewById(R.id.negroLayout);
        deLucia = v.findViewById(R.id.deLuciaLayout);
        ferrucci = v.findViewById(R.id.ferrucciLayout);
        deSantis = v.findViewById(R.id.deSantisLayout);
        polese = v.findViewById(R.id.poleseLayout);

        //PROF. NEGRO CARD
        negro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPEN E-MAIL CLIENT TO SEND EMAIL TO alberto@unisa.it
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "alberto@unisa.it" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        //PROF. DE LUCIA CARD
        deLucia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPEN E-MAIL CLIENT TO SEND EMAIL TO adelucia@unisa.it
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "adelucia@unisa.it" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        //PROF.SSA FERRUCCI CARD
        ferrucci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPEN E-MAIL CLIENT TO SEND EMAIL TO fferrucci@unisa.it
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "fferrucci@unisa.it" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        //PROF. DE SANTIS CARD
        deSantis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPEN E-MAIL CLIENT TO SEND EMAIL TO ads@unisa.it
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "ads@unisa.it" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        //PROF. POLESE CARD
        polese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPEN E-MAIL CLIENT TO SEND EMAIL TO gpolese@unisa.it
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "gpolese@unisa.it" });
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        return v;
    }

}
