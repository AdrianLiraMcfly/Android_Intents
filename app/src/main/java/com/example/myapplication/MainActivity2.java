package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
        Button btng = findViewById( R.id.btng );
        Button btnc = findViewById( R.id.btnc );
        Button btnno = findViewById( R.id.btnn );
        Button btn5 = findViewById( R.id.btn5 );
        Button btn6 = findViewById( R.id.btn6 );
        Button btn7 = findViewById( R.id.btn7 );
        Button btn8 = findViewById( R.id.btn8 );

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

        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitud =25.532851168559922;
                double longitud=-103.32174354857497;

                Uri abrirmaps = Uri.parse("google.navigation:q=" + latitud + "," + longitud);
                Intent maps= new Intent(Intent.ACTION_VIEW, abrirmaps);
                maps.setPackage("com.google.android.apps.maps");
                if (maps.resolveActivity(getPackageManager()) != null) {
                    startActivity(maps);
                } else {
                    Toast.makeText(getApplicationContext(), "No fue posible realizar la opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calc = new Intent( Intent.ACTION_MAIN );
                calc.setAction(Intent.ACTION_MAIN);
                calc.addCategory(Intent.CATEGORY_APP_CALCULATOR);

                PackageManager pm = getPackageManager();
                ResolveInfo ri = pm.resolveActivity(calc, PackageManager.MATCH_DEFAULT_ONLY);

                if (ri != null) {
                    startActivity(calc);
                } else {
                    Toast.makeText(getApplicationContext(), "No fue posible realizar la opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });

            btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3 = new Intent( MainActivity2.this, MainActivity3.class );
                startActivity( act3 );

            }
        });
    }
}