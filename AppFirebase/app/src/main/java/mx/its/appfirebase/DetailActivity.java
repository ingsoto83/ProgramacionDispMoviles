package mx.its.appfirebase;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView txtTitulo = findViewById(R.id.txtTitulo);
        TextView txtTel = findViewById(R.id.txtTel);
        setSupportActionBar(toolbar);
        String pagina = "https://youtube.com";
        String tel =  "8441856266";

        txtTitulo.setText(pagina);
        txtTel.setText(tel);
        Linkify.addLinks(txtTitulo,Linkify.ALL);
        Linkify.addLinks(txtTel,Linkify.PHONE_NUMBERS);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
