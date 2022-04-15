package com.example.week8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView lv;
    private List<Book> booklist=new ArrayList<>();
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;
    String book[]=new String[]{"name","category_id","price"};
    int[] to=new int[]{R.id.name,R.id.categoryId,R.id.price};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        lv=(ListView) findViewById(R.id.list_view);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //查询数据
        Cursor c=db.query("Book",null, null, null, null, null, null);
        adapter=new SimpleCursorAdapter(this,R.layout.book_item,c,book,to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        /*while (c.moveToNext()) {
            String _id=c.getString(0);
            String name=c.getString(1);
            int caregory=c.getInt(2);
            double price=c.getDouble(3);
            Book book=new Book(_id,name,caregory,price);
            booklist.add(book);
        }*/
        lv.setAdapter(adapter);

        //BookAdapter bookAdapter=new BookAdapter(this);
        //lv.setAdapter(bookAdapter);

    }
}
