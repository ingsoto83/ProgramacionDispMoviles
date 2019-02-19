package mx.its.firtsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText txtNombre;
    private RatingBar rating;
    private Button button1,button2;
    private ImageView logo;
    private SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txt_nombre);
        button1  = findViewById(R.id.button1);
        button2  = findViewById(R.id.button2);
        rating =  findViewById(R.id.rating);
        logo = findViewById(R.id.logo);
        seek = findViewById(R.id.seek);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        //rating.setRating(5.0f);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),
                        getString(R.string.rating_selected,rating),
                        Toast.LENGTH_SHORT).show();
            }
        });
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),
                        " El progreso cambió a :"+progress,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),
                        " Inicia desplazamiento :",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),
                        " Termina desplazamiento",
                        Toast.LENGTH_SHORT).show();
            }
        });
        logo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.button1){
            Toast.makeText(getApplicationContext(),"Hiciste click en hombre",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()== R.id.button2){
            Toast.makeText(getApplicationContext(),"Hiciste click en mujer",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()== R.id.logo){
            if(txtNombre.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),
                        "Escribe tu nombre primero!",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),
                        " Hola, "+txtNombre.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}

















