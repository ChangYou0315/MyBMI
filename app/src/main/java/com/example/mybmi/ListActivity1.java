package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("香蕉");
        list.add("橘子");
        list.add("西瓜");
        list.add("葡萄");
        list.add("芭樂");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
        ListView lvfruit = findViewById(R.id.lvFruit);
        lvfruit.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvfruit.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spfruit = findViewById(R.id.spFruit);
        TextView tvshow1 = findViewById(R.id.tvShow1);

//        spfruit.setAdapter(adapter);
        lvfruit.setAdapter(adapter);
        lvfruit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvshow1.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ListActivity1.this, "請選擇水果", Toast.LENGTH_SHORT).show();
            }
        });

        lvfruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvshow1.setText(list.get(position));
            }
        });
        lvfruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = "";
                for (int i = 0; i < lvfruit.getCount(); i++) {
                    if (lvfruit.isItemChecked(i)) {
                        s += list.get(i) + " ";
                    }
                }
                tvshow1.setText(s);
            }
        });
    }
}