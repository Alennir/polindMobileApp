package esiea.com.polind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etEmail = findViewById(R.id.etEmail);

        UserDatabase db = new UserDatabase(this);

        User user = new User("test@test.fr","test");

        db.open();
        db.insertUser(user);

        User userFromDb = db.getUserWithEmail(user.getEmail());

        if(userFromDb != null){
            etEmail.setText(userFromDb.getEmail());
        }
    }
}
