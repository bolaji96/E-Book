package joshua.e_book;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity implements View.OnClickListener {

    Button signIn_imageButton_login;
    EditText register_editText_username, register_editText_email, register_editText_password;
    MembersLocalStore membersLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_editText_username = (EditText) findViewById(R.id.register_editText_username);
        register_editText_email = (EditText) findViewById(R.id.register_editText_email);
        register_editText_password = (EditText) findViewById(R.id.register_editText_password);
        signIn_imageButton_login = (Button) findViewById(R.id.signIn_imageButton_login);

        signIn_imageButton_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.signIn_imageButton_login:

                String Username = register_editText_username.getText().toString();
                String EmailAddress = register_editText_email.getText().toString();
                String Password = register_editText_password.getText().toString();

                Members members = new Members(Username, EmailAddress, Password);
                registerMembers(members);
                break;
        }
    }

    private void registerMembers(Members members) {
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeMembersDataInBackground(members, new GetMembersCallBack() {
            @Override
            public void done(Members returnedMembers) {
                //startActivity(new Intent(register.this, login.class));
            }
        });
    }
}
