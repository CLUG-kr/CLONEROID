package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        SingerAdapter adapter = new SingerAdapter();
        adapter.addItem(new Singeritem("snsd", "010292943848"));
        adapter.addItem(new Singeritem("6666", "0103434"));
        adapter.addItem(new Singeritem("w4yryfg", "01029295675678"));
        adapter.addItem(new Singeritem("asdfasdf", "010223455675678"));
        adapter.addItem(new Singeritem("df", "094949494"));

        listView.setAdapter(adapter);
    }



    class SingerAdapter extends BaseAdapter {
        ArrayList<Singeritem> items = new ArrayList<Singeritem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Singeritem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Singeritem view = new SingeritemView(getApplicationContext());

            Singeritem item = items.get(i);
            view.setName(item.getName());
            view.setMobile(item.getMobile());

            return view;
        }
    }

}