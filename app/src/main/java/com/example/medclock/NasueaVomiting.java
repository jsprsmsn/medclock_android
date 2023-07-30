package com.example.medclock;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class NasueaVomiting extends AppCompatActivity {

    TextView tv_description, tv_descriptionsymptoms, tv_descriptionmed;
    LinearLayout layout_nasueavomiting, layout_nasueavomiting_symptoms, layout_nasueavomiting_med;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasuea_vomiting);

        tv_description = findViewById(R.id.tv_description);
        tv_descriptionsymptoms = findViewById(R.id.tv_descriptionsymptoms);
        tv_descriptionmed = findViewById(R.id.tv_descriptionmed);
        layout_nasueavomiting = findViewById(R.id.layout_nasueavomiting);
        layout_nasueavomiting_symptoms =findViewById(R.id.layout_nasueavomiting_symptoms);
        layout_nasueavomiting_med = findViewById(R.id.layout_nasueavomiting_med);

        layout_nasueavomiting.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout_nasueavomiting_symptoms.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout_nasueavomiting_med.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

    }
    public void expandnasueavomiting(View view) {
        int d = (tv_description.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_nasueavomiting, new AutoTransition());

        tv_description.setVisibility(d);
    }

    public void expandsymptoms(View view) {
        int ds = (tv_descriptionsymptoms.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_nasueavomiting_symptoms, new AutoTransition());

        tv_descriptionsymptoms.setVisibility(ds);
    }
    public void expandmed(View view) {
        int dm = (tv_descriptionmed.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_nasueavomiting_med, new AutoTransition());

        tv_descriptionmed.setVisibility(dm);
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