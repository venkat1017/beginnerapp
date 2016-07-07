package android.com.a786893_policy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by venkatesh on 29-06-2016.
 */
public class LoginSuccess extends Activity{
    private ListView mainListView ;

    private ArrayAdapter<String> listAdapter ;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        mainListView = (ListView) findViewById( R.id.mainListView );

        // Create and populate a List of planet names.
        final String[] policy = new String[] { "View Policy Details", "Report and accident", "Speak to customer care", "About the App"};
        ArrayList<String> policyList = new ArrayList<String>();
        policyList.addAll( Arrays.asList(policy) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simple_row, policyList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.


        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
        // Setup listerner for clicks
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                   // txtView.setText("Option One");
                    Intent intent  = new Intent(getApplicationContext(),policy_details.class);
                    startActivity(intent);
                }
                if(position == 1) {
                   // txtView.setText("Option Two");
                    Intent intent  = new Intent(getApplicationContext(),report_accident.class);
                    startActivity(intent);
                }
                if(position == 2) {
                    Intent intent  = new Intent(getApplicationContext(),CusomerCare.class);
                    startActivity(intent);
                }
                if(position == 3) {
                    Intent intent  = new Intent(getApplicationContext(),login.class);
                    startActivity(intent);
                }
            }
        });



    TextView txt_loggedName = (TextView) findViewById(R.id.txt_loggedName);

        /* Get values from Intent */
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        txt_loggedName.setText(name);
        Button logout = (Button) findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });


        }

}
