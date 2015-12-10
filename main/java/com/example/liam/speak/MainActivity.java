package com.example.liam.speak;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String name;
    Button b2;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et2 = (EditText) findViewById(R.id.editText2);
        b2 = (Button) findViewById(R.id.button2);

        final TextToSpeech tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status){
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name = et2.getText().toString();
                name = "Hello "+name+"! Thank you for testing!";
                tts.speak(name, TextToSpeech.QUEUE_FLUSH, null, "");
                Intent intent = new Intent(MainActivity.this, SpeakActivity.class);
                startActivity(intent);
            }
        });

    }

    //could use this method to change languages, settings
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //called when they press a button on options menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
