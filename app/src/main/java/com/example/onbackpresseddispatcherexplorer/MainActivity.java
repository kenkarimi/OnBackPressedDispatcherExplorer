package com.example.onbackpresseddispatcherexplorer;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean exit = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For API level 33+:
        /*OnBackInvokedCallback callback = new OnBackInvokedCallback() {
            @Override
            public void onBackInvoked() {

            }
        };
        getOnBackInvokedDispatcher().registerOnBackInvokedCallback(callback);*/

        //For API level 13+:
        OnBackPressedCallback callback2 = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(exit) {
                    //getOnBackPressedDispatcher().onBackPressed(); //Default. Replaces super.onBackPressed(). Whether it's going back to the previous activity or exiting.
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Back button pressed", Toast.LENGTH_SHORT).show();
                }

            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback2);
    }

    /*@Override
    public void onBackPressed() {
        if(exit) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Back button pressed", Toast.LENGTH_SHORT).show();
        }
    }*/
}