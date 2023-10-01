package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnn = findViewById( R.id.btnn );

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent navega = new Intent( Intent.ACTION_VIEW, uri );

                if (navega.resolveActivity(getPackageManager()) != null) {
                    startActivity(navega);
                } else {
                    Toast.makeText(getApplicationContext(), "No fue posible realizar la opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}