package com.magistrale.unisa.mystudentguide;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BoxHandler {
    Context context;

    public LinearLayout layout;

    private ArrayList<CheckBox> arrayBox = new ArrayList();
    private ArrayList<String> arrayBoxFilename = new ArrayList();

    private ArrayList<String> arraySeparatorText = new ArrayList();


    public BoxHandler(Context con, LinearLayout layout){
        //CONTROLL CONTEXT AND LAYOUT
        this.context = con;
        this.layout = layout;

    }

    public void addCheckBox(String text, String filename){
        //CREATE CHECKBOX AND ADD DATA
        CheckBox box = new CheckBox(context);
        box.setText(text);
        arrayBox.add(box);
        arrayBoxFilename.add(filename);
        layout.addView(arrayBox.get(arrayBox.size()-1));
    }

    //FIND A CHECKBOX MY TEXT
    public CheckBox findBoxByText(String text){
        CheckBox mybox = null;
        for(int i = 0; i < arrayBox.size(); i++){
            if(arrayBox.get(i).getText().equals(text)){
                mybox = arrayBox.get(i);
            }
        }
        return mybox;
    }

    //ADD A TEXT SEPARATOR BETWEEN GUIDE ARGUMENTS
    public void addTextSeparator(String text){
        //ADD A TEXTVIEW TO LAYOUT
        arraySeparatorText.add(text);
        TextView mytext= new TextView(context);
        mytext.setText(text);
        layout.addView(mytext);
    }


    //ADD ANOTHER VIEW TO LAYOUT
    public void addOtherView(View view){
        layout.addView(view);
    }

    //GET FILE NAME FROM TEXT
    public String getFileameFromText(String text){
        for(int i = 0; i < arrayBoxFilename.size(); i++){
            if (arrayBox.get(i).getText().equals(text)){
                return arrayBoxFilename.get(i);
            }
        }
        return "error";
    }

    //GET ARRAY SIZE
    public int getSize(){
        return arrayBoxFilename.size();
    }

    //CONTROL IF CHECKBOX IS CHECKED
    public boolean isChecked(int index){
        return arrayBox.get(index).isChecked();
    }

    //GET FILE NAME FROM INDEX
    public String getFienameFromIndex(int i){
        return arrayBoxFilename.get(i);
    }
}