package com.example.medclock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    VideoView videoView;

    public CardView cdheadache, cdcoughcold, cdnauseavomiting, cddiarrhea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cdheadache = (CardView) findViewById(R.id.cd_headache);
        cdcoughcold = (CardView) findViewById(R.id.cd_coughcold);
        cdnauseavomiting = (CardView) findViewById(R.id.cd_nauseavomiting);
        cddiarrhea = (CardView) findViewById(R.id.cd_diarrhea);

        cdheadache.setOnClickListener(this);
        cdcoughcold.setOnClickListener(this);
        cdnauseavomiting.setOnClickListener(this);
        cddiarrhea.setOnClickListener(this);


        //NAVIGATION BAR
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_schedule:
                    startActivity(new Intent(getApplicationContext(), MedicineSchedule.class));
                    overridePendingTransition(0, 0);
                    //finish();
                    return true;
                case R.id.bottom_add:
                    startActivity(new Intent(getApplicationContext(), AddReminder.class));
                    overridePendingTransition(0, 0);
                    //finish();
                    return true;
            }
            return false;
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.cd_headache :
                i = new Intent(this, Headache.class);
                startActivity(i);
                break;
            case R.id.cd_coughcold :
                i = new Intent(this, CoughCold.class);
                startActivity(i);
                break;
            case R.id.cd_nauseavomiting :
                i = new Intent(this, NasueaVomiting.class);
                startActivity(i);
                break;
            case R.id.cd_diarrhea :
                i = new Intent(this, Diarrhea.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.history:
                startActivity(new Intent(getApplicationContext(), History.class));
                finish();
                return true;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginRegister.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}