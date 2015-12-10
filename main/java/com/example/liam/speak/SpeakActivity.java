package com.example.liam.speak;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SpeakActivity extends AppCompatActivity {

    EditText et1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent intent = getIntent(); //use this in future if need data from intent
        setContentView(R.layout.activity_text_to_speech);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextToSpeech tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status){
            }
        });

        et1 = (EditText) findViewById(R.id.editText1);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                  String s = et1.getText().toString();
                  tts.speak(s, TextToSpeech.QUEUE_ADD, null, "");
               }
           });
    }
}
