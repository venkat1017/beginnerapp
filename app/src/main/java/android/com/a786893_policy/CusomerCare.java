package android.com.a786893_policy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by venkatesh on 07-07-2016.
 */
public class CusomerCare extends Activity {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customercare);
        Button btncall = (Button) findViewById(R.id.button);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:180024343"));
                startActivity(intent);

            }
        });

    }

    }
