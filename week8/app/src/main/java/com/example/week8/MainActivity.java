package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button forceOffline=(Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }*/

    private MyDatabaseHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createDataBase=(Button) findViewById(R.id.create_database);
        createDataBase.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addCategory=(Button) findViewById(R.id.add_category);
        addCategory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("category_name","science");
                values.put("category_code",10001);
                db.insert("Category",null,values);
                values.clear();

                values.put("category_name","history");
                values.put("category_code",10002);
                db.insert("Category",null,values);
            }
        });

        Button addData=(Button) findViewById(R.id.add_data_1);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddBookActivity.class);
                startActivity(intent);
            }
        });

        Button delete=(Button) findViewById(R.id.delete_data);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                db.delete("Book","pages<?",new String[]{"550"});
            }
        });

        Button bookView=(Button) findViewById(R.id.book_view);
        bookView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }
}