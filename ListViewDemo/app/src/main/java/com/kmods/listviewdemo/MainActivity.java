package com.kmods.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] names = {"Kuldip", "Aadil", "Saurabh", "Dhiren"};
    String[] decs = {"Student", "Engineer", "Builder", "Teacher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listv);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return names.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View my_item = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, null);

                TextView name = my_item.findViewById(R.id.name);
                name.setText(names[position]);

                TextView description = my_item.findViewById(R.id.desc);
                description.setText(decs[position]);

                Button button = my_item.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Button " + position + " Clicked!", Toast.LENGTH_SHORT).show();
                    }
                });

                return my_item;
            }
        });
    }
}
