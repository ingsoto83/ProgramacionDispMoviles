package mx.its.myfirstapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import mx.its.myfirstapplication.data.Encuesta;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button btnEnviar,btnLimpiar;
    private ImageView imgLogo;
    private SeekBar seekBar;
    private EditText etNombre;
    private RatingBar rating;
    public static final String DATOS = "datos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btn_enviar);
        btnLimpiar = findViewById(R.id.btn_limpiar);
        imgLogo = findViewById(R.id.imgLogo);
        seekBar = findViewById(R.id.seekbar);
        rating = findViewById(R.id.rating);
        etNombre = findViewById(R.id.et_nombre);
        /*
         * 1) Clase Anonima
         * 2) Implementando la interfaz
         * 3) Instancia Directa
         * 4) Clase o SubClase
         *
         */
        //Manera #1
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "El rating cambió a :" +rating, Toast.LENGTH_SHORT).show();
            }
        });

        //Manera #2
        //implements View.OnClickListener en MainActivity
        //Sobreescribir el metodo onClick
        btnEnviar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        imgLogo.setOnClickListener(this);

        /*Manera #3
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, getString(R.string.txt_click),Snackbar.LENGTH_SHORT).show();
            }
        };
        btnEnviar.setOnClickListener(listener);
        btnLimpiar.setOnClickListener(listener);
        imgLogo.setOnClickListener(listener);*/
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"El valor es "+progress,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        String opcion="";
        switch (v.getId()){
            case R.id.btn_enviar:
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                Encuesta e = new Encuesta(etNombre.getText().toString(),seekBar.getProgress(),rating.getRating());
                i.putExtra(DATOS,e);

                startActivity(i);
                opcion = "Botón Enviar";
                break;
            case R.id.btn_limpiar:
                opcion = "Botón Limpiar";
                break;
            case R.id.imgLogo:
                opcion = "Logo";
                break;
        }
        Snackbar.make(v, getString(R.string.txt_click,opcion),Snackbar.LENGTH_SHORT).show();
    }
}
