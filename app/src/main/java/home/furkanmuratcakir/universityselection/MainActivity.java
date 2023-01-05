package home.furkanmuratcakir.universityselection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // TODO: SQL EXCEPTIONS + BACKGROUND COLOR + PARENT ACTIVITY THING

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_lisans = findViewById(R.id.btn_lisans);
        Button btn_onlisans = findViewById(R.id.btn_onlisans);
        Button btn_puan = findViewById(R.id.btn_puan);
        Button btn_gun = findViewById(R.id.btn_gün);

        // Main sayfadan diğer sayfalara geçiş için intent kullanıldı.
        btn_lisans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LisansActivity.class);
                startActivity(intent);
            }
        });

        btn_onlisans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OnlisansActivity.class);
                startActivity(intent);
            }
        });

        btn_puan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PuanActivity.class);
                startActivity(intent);
            }
        });

        btn_gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GunActivity.class);
                startActivity(intent);
            }
        });
    }
}