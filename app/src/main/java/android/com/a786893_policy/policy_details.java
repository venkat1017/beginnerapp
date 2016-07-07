package android.com.a786893_policy;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by venkatesh on 30-06-2016.
 */
public class policy_details extends Activity  {

    DBhelper mHelper;
    Button btn_show;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;
    EditText ed7;
    EditText ed8;


    public static final String DB_NAME = "policy_db";
    public static final int DB_VERSION = 4;

    // Table attributes
    public static final String TABLE_NAME_POLICY = "policy_details_table";
    public static final String COLUMN_NAME_policy_number = "policy_number_column";
    public static final String COLUMN_NAME_policy_type = "policy_type_column";
    public static final String COLLUMN_NAME_policy_product_name = "policy_product_name_column";
    public static final String COLLUMN_NAME_policy_cover_type = "policy_cover_type_column";
    public static final String COLLUMN_NAME_policy_start_date = "policy_start_date_column";
    public static final String COLLUMN_NAME_policy_due_date = "policy_due_date_column";
    public static final String COLLUMN_NAME_policy_premium = "policy_premium_column";


    public class DBhelper extends SQLiteOpenHelper {

        public DBhelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        // Called when the database is created for the first time.
        //This is where the creation of tables and the initial population of the tables should happen.
        @Override
        public void onCreate(SQLiteDatabase db) {
            // We need to check whether table that we are going to create is already exists.
            //Because this method get executed every time we created an object of this class.
            //"create table if not exists TABLE_NAME ( BaseColumns._ID integer primary key autoincrement, FIRST_COLUMN_NAME text not null, SECOND_COLUMN_NAME integer not null);"
            String policy_table_create = "create table if not exists " + TABLE_NAME_POLICY + " ( "
                    + COLUMN_NAME_policy_number + " text not null, "
                    + COLUMN_NAME_policy_type + " text not null, "
                    + COLLUMN_NAME_policy_product_name + " real not null,"
                    + COLLUMN_NAME_policy_cover_type + " real not null,"
                    + COLLUMN_NAME_policy_start_date + " real not null,"
                    + COLLUMN_NAME_policy_due_date + " real not null,"
                    + COLLUMN_NAME_policy_premium + " real not null);";
            Log.i("createDB=", policy_table_create);


            // Execute a single SQL statement that is NOT a SELECT or any other SQL statement that returns data.
            db.execSQL(policy_table_create);
            /*ContentValues cv = new ContentValues(2);
            cv.put(COLUMN_NAME_policy_number, "POL1234567789");
            cv.put(COLUMN_NAME_policy_type, "Motor Insurance");
            cv.put(COLLUMN_NAME_policy_product_name, "Ford Figo");
            cv.put(COLLUMN_NAME_policy_cover_type, "Accident Cover");
            cv.put(COLLUMN_NAME_policy_start_date, "12/12/2014");
            cv.put(COLLUMN_NAME_policy_due_date, "12/12/2015");
            cv.put(COLLUMN_NAME_policy_premium, "12000 INR");


            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //cv.put(COL_DATE, dateFormat.format(new Date()));
            db.insert(TABLE_NAME_POLICY, null, cv);
            Log.i("Table Insert", "onCreate:Data Inserted ");*/
        }

        // onUpgrade method is use when we need to upgrade the database in to a new version
        //As an example, the first release of the app contains DB_VERSION = 1
        //Then with the second release of the same app contains DB_VERSION = 2
        //where you may have add some new tables or alter the existing ones
        //Then we need check and do relevant action to keep our pass data and move with the next structure
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion == 1 && newVersion == 2) {
                // Upgrade the database
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_POLICY);
                onCreate(db);
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policy_detail);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        mHelper = new DBhelper(this);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // insertItem();
                showItems();

            }
        });

    }
    private void insertItem() {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql1 = "insert into " + TABLE_NAME_POLICY + " (" + COLUMN_NAME_policy_number + ", " + COLUMN_NAME_policy_type+", "
                +COLLUMN_NAME_policy_product_name+", "+COLLUMN_NAME_policy_cover_type+", "+COLLUMN_NAME_policy_start_date+", "
                +COLLUMN_NAME_policy_due_date+", "+COLLUMN_NAME_policy_premium+ ") values('POL1234567789', " +
                "'Motor Insurance','Ford Figo','Accident Cover','12/12/2014','12/12/2015','12000 INR');";

        try {
            Log.i("sql1=", sql1);
            //Log.i("sql2=", sql2);
            db.execSQL(sql1);
            //db.execSQL(sql2);
            setTitle("done");
        } catch (SQLException e) {
            setTitle("exception");
        }
    }
    private void showItems() {

        SQLiteDatabase db = mHelper.getReadableDatabase();
        //String col[] = { COLUMN_NAME_policy_number, COLUMN_NAME_policy_type,COLLUMN_NAME_policy_product_name,COLLUMN_NAME_policy_cover_type,COLLUMN_NAME_policy_start_date,COLLUMN_NAME_policy_due_date,COLLUMN_NAME_policy_premium};
        Cursor cur = db.rawQuery("SELECT * FROM policy_details_table", null);
        Integer num = cur.getCount();
        setTitle(Integer.toString(num));
        EditText ed1 = (EditText) findViewById(R.id.txt_policy_name);
        EditText ed2 = (EditText) findViewById(R.id.txt_policy_type);
        EditText ed3 = (EditText) findViewById(R.id.txt_product_name);
        EditText ed4 = (EditText) findViewById(R.id.txt_cover_type);
        EditText ed5 = (EditText) findViewById(R.id.txt_start_date);
        EditText ed6 = (EditText) findViewById(R.id.txt_due_date);
        EditText ed7 = (EditText) findViewById(R.id.txt_premium);
        //for (int i=; i<=cur.getCount(); i++) {
        if (cur.moveToFirst()) {
            ed1.setText(cur.getString(0));
            ed2.setText(cur.getString(1));
            ed3.setText(cur.getString(2));
            ed4.setText(cur.getString(3));
            ed5.setText(cur.getString(4));
            ed6.setText(cur.getString(5));
            ed7.setText(cur.getString(6));

        }

    }


}
