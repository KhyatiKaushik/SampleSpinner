package com.naveen.samplespinner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Implicit_Intent extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit__intent);

        spinner = (Spinner)findViewById(R.id.implicit_Spinner);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(Implicit_Intent.this,R.array.intents,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }

    public void implicitTrigger(View view) {

        //Passing selected Item position into Integer given below for Condition

        int position = spinner.getSelectedItemPosition();

        //Implicit Intent.
        Intent intent = null;

        switch (position){


            case 0:
                //Opening Browser for given URL

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/"));


                break;
            case 1:
                //Dial a call on given number.

                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:(+91)1234567890"));
                break;
            case 2:
                //Opening Google Maps for given Long & Lat.
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:15.52,14.5656?z=19"));

                break;
            case 3:
                //Search on Google Maps

                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=Durga Soft"));

                break;
            case 4:
                //Opening Contacts in current Mobile.
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));

                break;
            case 5:
                //Edit the FIrst contact.

                intent = new Intent(Intent.ACTION_EDIT,Uri.parse("content://contacts/people/1"));
                break;
        }

        if (intent!=null){
            startActivity(intent);
        }


    }

    public void exitClick(View view) {
        finish();
    }
}
