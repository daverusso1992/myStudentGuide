/*
 * InfoFragment.java
 *
 * Copyright (c) 2018 myStudentGuide App
 */

// Package
package com.magistrale.unisa.mystudentguide;

// External Packages
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.InputStream;

// InfoFragment Class
public class InfoFragment extends Fragment {

    View v;

    // INFORMATION TEXTVIEW
    TextView txt;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_info, container, false);

        //
        //CREATE INFO APPLICATION
        //
        txt = v.findViewById(R.id.infoAppText);
        try {

            // COPY TEXT INSIDE "INFO.TXT" IN RAW FOLDER
            // AND INSERT IN THE NEW TEXT VIEW
            Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.zinfoapp);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            txt.setText(new String(b));
            txt.setTextAppearance(R.style.TextAppearance_AppCompat_Body2);
        } catch (Exception e) {
            txt.setText("Error: can't show data.");
        }

        return v;
    }
}
