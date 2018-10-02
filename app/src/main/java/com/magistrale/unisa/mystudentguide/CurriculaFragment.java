package com.magistrale.unisa.mystudentguide;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;

public class CurriculaFragment extends Fragment {


    //CURRICULA LAYOUT
    LinearLayout clayout;
    LinearLayout dlayout;
    LinearLayout ilayout;
    LinearLayout siclayout;
    LinearLayout sislayout;

    View v;

    //CURRICULA IMAGE
    ImageView cloudC;
    ImageView data;
    ImageView internet;
    ImageView sicurezza;
    ImageView sistemi;

    //FLAG TO CONTROL PRESS ON IMAGES
    boolean flag = true;
    boolean flag2 = true;
    boolean flag3 = true;
    boolean flag4 = true;
    boolean flag5 = true;

    //TEXT VIEW FOR CURRICULA INFO
    public TextView txt1;
    public TextView txt2;
    public TextView txt3;
    public TextView txt4;
    public TextView txt5;

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_curricula, container, false);

        clayout = v.findViewById(R.id.cloudCLayout);
        dlayout = v.findViewById(R.id.dataScienceLayout);
        ilayout = v.findViewById(R.id.internetLayout);
        siclayout = v.findViewById(R.id.sicurezzaLayout);
        sislayout = v.findViewById(R.id.sistemiLayout);

        cloudC = v.findViewById(R.id.cloudC);
        data = v.findViewById(R.id.dataScience);
        internet = v.findViewById(R.id.internet);
        sicurezza = v.findViewById(R.id.sicurezza);
        sistemi = v.findViewById(R.id.sistemi);

        //
        //CREATE INFO FOR CLOUD COMPUTING CURRICULUM
        //
        txt1 = new TextView(getContext());
        try {
            //COPY TEXT INSIDE "INFO.TXT" IN RAW FOLDER
            //AND INSERT IN THE NEW TEXT VIEW
            Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.zinfo);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            txt1.setText(new String(b));
            txt1.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        } catch (Exception e) {
            txt1.setText("Error: can't show terms.");
        }

        //
        //CREATE INFO FOR DATA SCIENCE CURRICULUM
        //
        txt2 = new TextView(getContext());
        try {
            //COPY TEXT INSIDE "DINFO.TXT" IN RAW FOLDER
            //AND INSERT IN THE NEW TEXT VIEW
            Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.zdinfo);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            txt2.setText(new String(b));
            txt2.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        } catch (Exception e) {
            txt2.setText("Error: can't show terms.");
        }

        //
        //CREATE INFO FOR INTERNET OF THINGS CURRICULUM
        //
        txt3 = new TextView(getContext());
        try {
            //COPY TEXT INSIDE "IINFO.TXT" IN RAW FOLDER
            //AND INSERT IN THE NEW TEXT VIEW
            Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.ziinfo);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            txt3.setText(new String(b));
            txt3.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        } catch (Exception e) {
            txt3.setText("Error: can't show terms.");
        }

        //
        //CREATE INFO FOR SICUREZZA INFORMATICA CURRICULUM
        //
        txt4 = new TextView(getContext());
        try {
            //COPY TEXT INSIDE "SICINFO.TXT" IN RAW FOLDER
            //AND INSERT IN THE NEW TEXT VIEW
            Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.zsicinfo);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            txt4.setText(new String(b));
            txt4.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        } catch (Exception e) {
            txt4.setText("Error: can't show terms.");
        }

        //
        //CREATE INFO FOR CLOUD COMPUTING CURRICULUM
        //
        txt5 = new TextView(getContext());
        try {
            //COPY TEXT INSIDE "INFO.TXT" IN RAW FOLDER
            //AND INSERT IN THE NEW TEXT VIEW
            Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.zsisinfo);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            txt5.setText(new String(b));
            txt5.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        } catch (Exception e) {
            txt5.setText("Error: can't show terms.");
        }


        //
        // CLICK TO OPEN OR CLOSE CURRICULA CARDS -------------------------------------------
        //
        cloudC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag){
                    //CREATE NEW TEXT VIEW
                    clayout.addView(txt1);
                    //CHANGE IMAGE FOR CURRICULUM
                    cloudC.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.cdown));
                    flag = !flag;
                }else{
                    clayout.removeView(txt1);
                    cloudC.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.cup));
                    flag = !flag;
                }
            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag2){
                    //CREATE NEW TEXT VIEW
                    dlayout.addView(txt2);
                    //CHANGE IMAGE FOR CURRICULUM
                    data.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.ddown));
                    flag2 = !flag2;
                }else{
                    dlayout.removeView(txt2);
                    data.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.dup));
                    flag2 = !flag2;
                }
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag3){
                    //CREATE NEW TEXT VIEW
                    ilayout.addView(txt3);
                    //CHANGE IMAGE FOR CURRICULUM
                    internet.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.idown));
                    flag3 = !flag3;
                }else{
                    ilayout.removeView(txt3);
                    internet.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.iup));
                    flag3 = !flag3;
                }
            }
        });

        sicurezza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag4){
                    siclayout.addView(txt4);
                    sicurezza.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.sicdown));
                    flag4 = !flag4;
                }else{
                    siclayout.removeView(txt4);
                    sicurezza.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.sicup));
                    flag4 = !flag4;
                }
            }
        });

        sistemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag5){
                    sislayout.addView(txt5);
                    sistemi.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.sisdown));
                    flag5 = !flag5;
                }else{
                    sislayout.removeView(txt5);
                    sistemi.setImageDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.sisup));
                    flag5 = !flag5;
                }
            }
        });
        //---------------------------------------------------------------------------------

        return v;
    }
}
