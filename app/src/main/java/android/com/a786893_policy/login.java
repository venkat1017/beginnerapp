package android.com.a786893_policy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText loginName = (EditText) findViewById(R.id.txt_userName);
                String  name  = loginName.getText().toString();

                Intent intent  = new Intent(getApplicationContext(),LoginSuccess.class);

                intent.putExtra("name", name);

                startActivity(intent);

            }
        });
    }

}
