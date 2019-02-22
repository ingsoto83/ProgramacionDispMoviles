package mx.its.firtsapp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DataActivity extends AppCompatActivity {
    //private float currentRating;
    //private int color;
    //private String nombre;
    private Pojo p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ConstraintLayout contenido = findViewById(R.id.contenido);
        //currentRating = getIntent().getFloatExtra(MainActivity.RATING,0f);
        //color = getIntent().getIntExtra(MainActivity.COLOR,0);
        //nombre = getIntent().getStringExtra(MainActivity.NOMBRE);
        p = (Pojo) getIntent().getSerializableExtra(MainActivity.POJO);
        contenido.setBackgroundColor(getResources().getColor(p.getColor()));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "El rating recibido es de "+p.getCurrentRating()+" de : "+p.getNombre(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
