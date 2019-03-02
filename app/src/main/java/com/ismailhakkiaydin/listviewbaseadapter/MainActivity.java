package com.ismailhakkiaydin.listviewbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste= (ListView) findViewById(R.id.ulkelerListesi);

        CustomAdapter adapter=new CustomAdapter(this);
        liste.setAdapter(adapter);

    }
}
