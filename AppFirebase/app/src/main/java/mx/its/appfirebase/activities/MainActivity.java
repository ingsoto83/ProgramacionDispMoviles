package mx.its.appfirebase.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import mx.its.appfirebase.DetailActivity;
import mx.its.appfirebase.Message;
import mx.its.appfirebase.MessagesAdapter;
import mx.its.appfirebase.MessagesListener;
import mx.its.appfirebase.R;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MessagesListener{
    FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private RecyclerView recyclerView;
    private EditText etMessage;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etMessage = findViewById(R.id.et_message);
        recyclerView =  findViewById(R.id.recycler);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("messages");
        if(mAuth.getCurrentUser()==null){
          goToLogin();
        }
        user = mAuth.getCurrentUser();
        MessagesAdapter adapter = new MessagesAdapter(this,mReference,Message.class,new ArrayList<Message>(),new ArrayList<String>(),this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etMessage.getText().toString().isEmpty()){
                    Message msg =  new Message(user.getUid(),user.getEmail(),etMessage.getText().toString());
                    mReference.push().setValue(msg);
                }

            }
        });
    }
    void goToLogin(){
        Intent i = new Intent(this,LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            mAuth.signOut();
            goToLogin();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMessageLongClick(String key) {
      mReference.child(key).setValue(null);
    }

    @Override
    public void onMessageClick(Message message, String key) {
        /*https://developer.android.com/training/sharing/send#java*/
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message.getEmail()+" escribío: "+message.getMessage());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
        //Toast.makeText(getApplicationContext(),message.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
