/*
 * CreateFragment.java
 *
 * Copyright (c) 2018 myStudentGuide App
 */

// Package
package com.magistrale.unisa.mystudentguide;

// External Packages
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

// CreateFragment Class
public class CreateFragment extends Fragment  {

    // FINAL DOCUMENT FIlE
    String resultDocFile;
    Document resultDoc;

    // ARGUMENTS CONTROLLER
    BoxHandler handler;

    // LAYOUT FOR CHECK-BOX
    LinearLayout layout;

    // YEARS
    RadioGroup radio;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_create, container,false);

        layout = v.findViewById(R.id.layoutCreateCheckBox);

        //CHECKBOX CONTROLLER-------------------------
        handler = new BoxHandler(getContext(), layout);
        // -------------------------------------------

        radio = v.findViewById(R.id.radioButtons);

        //BUTTON TO CREATE THE PERSONALIZED GUIDE -------------------------------------
        Button submitButton = v.findViewById(R.id.submit_button);
        //--------------------------------------------------------------------------

        //CREATE THE EXTERNAL STORAGE DIRECTORY PATH
        final String env = Environment.getExternalStorageDirectory().toString();
        final String path = env + "/myStudentGuide/";

        //
        //CREATE ALL GUIDE ARGUMENTS, ADD CHECKBOX AND ANY OTHER VIEW-----------------------
        //
        handler.addCheckBox("INFORMAZIONI GENERALI", "0");
        handler.addTextSeparator("Offerta Formativa Programmata Laura in Informatica");
        handler.addCheckBox("OBIETTIVI FORMATIVI", "1");
        handler.addCheckBox("SBOCCHI OCCUPAZIONALII", "2");
        handler.addCheckBox("RISULTATI DI APPRENDIMENTO ATTESI", "3");
        handler.addCheckBox("REQUISITI DI AMMISSIONE E MODALITÀ DI VERIFICA", "4");
        handler.addCheckBox("PROSEGUIMENTO DEGLI STUDI", "5");
        handler.addCheckBox("ORDINAMENTO DIDATTICO", "6");
        handler.addCheckBox("OFFERTA FORMATIVA", "7");
        handler.addCheckBox("ATTIVITÀ A SCELTA LIBERA DELLO STUDENTE", "8");
        handler.addCheckBox("TIPOLOGIA DELLE FORME DIDATTICHE", "9");
        handler.addCheckBox("INSEGNAMENTI A SCELTA", "10");
        handler.addCheckBox("ESAMI E ALTRE MODALITÀ DI VERIFICA DEL PROFITTO", "11");
        handler.addCheckBox("PROVA FINALE", "12");
        handler.addCheckBox("RICONOSCIMENTO DEI CREDITI (CFU)", "13");
        handler.addCheckBox("DECADENZA DALLA QUALITÀ DI STUDENTE", "14");
        handler.addCheckBox("TIROCINIO O ATTIVITÀ EQUIVALENTE", "15");
        handler.addCheckBox("VERIFICA LINGUA STRANIERA", "16");
        handler.addTextSeparator("Offerta Formativa Erogata");
        handler.addCheckBox("ASSOCIAZIONE CORSI-DOCENTI", "17");
        handler.addCheckBox("DOCENTI DEL CORSO", "18");
        handler.addTextSeparator("Appendice A - Syllabi delle Attività Didattiche");
        handler.addTextSeparator("Offerta Formativa Programmata");
        // ------------------------------------------------------------------------------------

        //
        //WHEN PRESS "AGGIORNA" BUTTON, CONTROL ALL CHECKBOXES
        //AND CREATE THE FINAL PERSONALIZED STUDENT GUIDE ------------------------------
        //
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //
                //CREATE A PUBLIC FOLDER TO COPY THE PDF APP FILES
                //
                String appFolder = "myStudentGuide";
                File f = new File(Environment.getExternalStorageDirectory(), appFolder);
                if (!f.exists()) {
                    f.mkdirs();
                }

                //
                //TAKE ALL THE PDF APP FILES IN "RAW" FOLDER AND PUT
                //EVERY FILE NAMES IN AN ARRAYLIST, SO COPY ALL FILE
                //IN THE NEW CREATED FOLDER "INFOMAGISTRALE"
                //

                try {
                    ArrayList<String> filenames = new ArrayList<>();

                    Field[] fields=R.raw.class.getFields();

                    for (Field field : fields) {
                        filenames.add(field.getName());
                    }

                    Log.d("filenames", filenames.toString());

                    //TAKE ALL FOLDER RAW FILES
                    for(int i = 0; i < filenames.size(); i++){
                        InputStream ins1 = getResources().openRawResource(
                                getResources().getIdentifier(filenames.get(i),
                                        "raw", getActivity().getPackageName()));

                        String doc1 = Environment.getExternalStorageDirectory() + "/myStudentGuide/"+ filenames.get(i)+".pdf";

                        //READ ALL FILE AND PUT INTO THE NEW INFOMAGISTRALE FOLDER
                        OutputStream os = new FileOutputStream(doc1);
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        //read from is to buffer
                        while((bytesRead = ins1.read(buffer)) !=-1){
                            os.write(buffer, 0, bytesRead);
                        }
                        ins1.close();

                        //flush OutputStream to write any buffered data to file
                        os.flush();
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //
                //CHECK WHAT DOCUMENT TO MERGE AND CREATE THE FINAL
                //PERSONALIZED STUDENT GUIDE IN EXTERNALSTORAGE
                //
                try {
                    //PATH OF FINAL PERSONALIZED STUDENT GUIDE
                    resultDocFile =  Environment.getExternalStorageDirectory() + "/myGuide.pdf";
                    resultDoc = new Document();

                    //CREATE A TEMPORARY COPY TO MERGE PDF
                    PdfCopy copy = new PdfCopy(resultDoc, new FileOutputStream(resultDocFile));

                    //OPEN THE RESULT PERSONALIZED GUIDE
                    resultDoc.open();

                    //
                    //yearLetter REPRESENTS THE SELECTED YEAR
                    //ADD THE yearLetter VARIABLE TO THE FILE NAME
                    //
                    String yearLetter = "";
                    if(radio.getCheckedRadioButtonId() == R.id.radioYearSeventeen){ yearLetter = "b"; }
                    if(radio.getCheckedRadioButtonId() == R.id.radioYearEighteen){ yearLetter = "a"; }

                    //CREATE THE COVER PAGE FILE NAME
                    final String cover = env + "/myStudentGuide/" + yearLetter + "copertina.pdf";

                    //ADD THE COVER TO THE FINAL GUIDE
                    PdfReader reader = new PdfReader(cover);
                    for(int i = 1; i <= reader.getNumberOfPages(); i++)    {
                        copy.addPage(copy.getImportedPage(reader, i));
                    }

                    //
                    //VERIFY WHAT CHECKBOX IS CHECKED, ADD FILES AND CREATE THE FINAL GUIDE
                    //
                    for(int j= 0; j < handler.getSize(); j++){
                        if(handler.isChecked(j)){
                            String file = path + yearLetter + handler.getFienameFromIndex(j) + ".pdf";
                            PdfReader reader1 = new PdfReader(file);
                            for(int i = 1; i <= reader1.getNumberOfPages(); i++)    {
                                copy.addPage(copy.getImportedPage(reader1, i));
                            }
                            Log.d("DOCUMENTO: ", yearLetter +
                                    handler.getFienameFromIndex(j));

                        }
                    }

                    //CLOSE THE FILE GUIDE
                    resultDoc.close();

                    //SHOW CORRECT MESSAGE
                    Toast.makeText(getContext(), "GUIDA CREATA\n" + Environment.getExternalStorageDirectory() + "/myGuide.pdf", Toast.LENGTH_LONG).show();
                    Log.d("GUIDA CREATA",Environment.getExternalStorageDirectory() + "/myGuide.pdf");

                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        return v;

    }

}
