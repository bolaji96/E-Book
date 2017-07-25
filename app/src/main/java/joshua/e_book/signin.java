package joshua.e_book;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signin extends AppCompatActivity implements View.OnClickListener {
    TextView signIn_textView_CreateNewAccount;
    Button signIn_button_login;
    EditText signIn_editText_username, signIn_editText_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signIn_editText_username = (EditText) findViewById(R.id.signIn_editText_username);
        signIn_editText_password = (EditText) findViewById(R.id.signIn_editText_password);
        signIn_textView_CreateNewAccount = (TextView) findViewById(R.id.signIn_textView_CreateNewAccount);
        signIn_button_login = (Button) findViewById(R.id.signIn_button_login);

        signIn_textView_CreateNewAccount.setOnClickListener(this);
        signIn_button_login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signIn_button_login:
                String username = signIn_editText_username.getText().toString();
                String password = signIn_editText_password.getText().toString();

                if (username == "joshua" && password == "12345")
                {
                    startActivity(new Intent(this, MainActivity.class));
                }
                else {
                    //Toast.makeText(signin.this, "Incorrect Email address and/or Password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                }
                break;

            case R.id.signIn_textView_CreateNewAccount:
                startActivity(new Intent(this, register.class));
                break;
        }
    }
}
